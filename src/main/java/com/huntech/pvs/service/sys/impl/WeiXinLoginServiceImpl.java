package com.huntech.pvs.service.sys.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.huntech.pvs.common.DECRYPT;
import com.huntech.pvs.common.ResourceLoad;
import com.huntech.pvs.common.UrlUtil;
import com.huntech.pvs.common.redis.VCache;
import com.huntech.pvs.common.util.JWT;
import com.huntech.pvs.dao.sys.WeiXinUserMapper;
import com.huntech.pvs.model.services.SelfBaseServType;
import com.huntech.pvs.model.sys.WeiXinLoginRequest;
import com.huntech.pvs.model.sys.WeiXinUser;
import com.huntech.pvs.model.sys.WeiXinUserExample;
import com.huntech.pvs.service.services.SelfServTypeService;
import com.huntech.pvs.service.sys.WeiXinLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class WeiXinLoginServiceImpl implements WeiXinLoginService {

    @Autowired
    private SelfServTypeService selfServTypeService;

    @Autowired
    private WeiXinUserMapper weiXinUserMapper;
    @Override
    public String HasUser(WeiXinLoginRequest weiXinLoginRequest) {
        JSONObject sessionKeyOropenid = getSessionKeyOropenid(weiXinLoginRequest.getCode());
        //解析返回的json数据，获得OPPID
        Map<String, String> params = JSONObject.parseObject(sessionKeyOropenid.toJSONString(), new TypeReference<Map<String, String>>(){});
        String openid=params.get("openid");
        String session_key=params.get("session_key");
        if(openid!=null){
            System.out.println("------------------------------------------------");
            Set<String> strings = params.keySet();
            for (String string : strings) {
                System.out.println("微信服务器获取的参数:key"+string+"------value:"+params.get(string));
            }
            System.out.println("------------------------------------------------");
            /*在此处添加自己的逻辑代码，将openid保存在数据库，或是，使用session_key去微信服务器换取用户头像、昵称等信息。我在这里并没有用到，因此我只保存了用户的openid*/
        }
        WeiXinUserExample weiXinUserExample = new WeiXinUserExample();
        WeiXinUserExample.Criteria criteria = weiXinUserExample.createCriteria();
        criteria.andOpenIdEqualTo(openid);
        List<WeiXinUser> weiXinUsers = weiXinUserMapper.selectByExample(weiXinUserExample);
        System.out.println("查询当前登录用户的信息："+weiXinUsers);
        JSONObject userInfo = null;
        try {
            if(weiXinLoginRequest.getEncryptedData()!=null&&session_key!=null&&weiXinLoginRequest.getIv()!=null){
                System.out.println("1111111111");
                try {
                    userInfo = DECRYPT.getUserInfo(weiXinLoginRequest.getEncryptedData(), session_key, weiXinLoginRequest.getIv());
                    System.out.println("解密用户userInfo:"+userInfo);
                } catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidAlgorithmParameterException | InvalidKeyException e) {
                    e.printStackTrace();
                }
//                userInfo.get("");
            }

        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }

        if(weiXinUsers!=null){
            System.out.println("null...........");
            if(weiXinUsers.size()>0){
                //查询是否存在
                Integer integer = selfServTypeService.selectCount(openid);
                if(integer<1){
                    selfServTypeService.insertAllType(openid);
                }
            }else{
                WeiXinUser weiXinUser = new WeiXinUser();
                weiXinUser.setOpenId(openid);
                if(userInfo!=null){
                    weiXinUser.setNickName((String)userInfo.get("nickName"));
                    weiXinUser.setAvatarUrl((String)userInfo.get("avatarUrl"));
                    String gender =String.valueOf(userInfo.get("gender"));
                    weiXinUser.setGender(new Byte(gender));
                }
                weiXinUserMapper.insert(weiXinUser);
                Integer integer = selfServTypeService.selectCount(openid);
                if(integer<1){
                    selfServTypeService.insertAllType(openid);
                }
            }

        }else{
            System.out.println("查询当前的登录用户为null。。。。。");
            WeiXinUser weiXinUser = new WeiXinUser();
            weiXinUser.setOpenId(openid);
            weiXinUserMapper.insert(weiXinUser);
            selfServTypeService.insertAllType(openid);
        }
        return openid;
    }

    @Override
    public int insertUser(WeiXinLoginRequest weiXinLoginRequest) {
        return 0;
    }

    @Override
    public WeiXinUser getWeinXinUser(HttpServletRequest request) {
        String token = request.getHeader("token");
        String openid = JWT.unsign(token, String.class);
        WeiXinUserExample example = new WeiXinUserExample();
        WeiXinUserExample.Criteria criteria = example.createCriteria();
        criteria.andOpenIdEqualTo(openid);
        List<WeiXinUser> weiXinUsers = weiXinUserMapper.selectByExample(example);
        WeiXinUser weiXinUser = null;
        if(weiXinUsers!=null&&weiXinUsers.size()>0){
            weiXinUser=weiXinUsers.get(0);
        }
        return weiXinUser;
    }

    @Override
    public void insertInToRedis(String openid) {
        WeiXinUserExample example = new WeiXinUserExample();
        WeiXinUserExample.Criteria criteria = example.createCriteria();
        criteria.andOpenIdEqualTo(openid);
        List<WeiXinUser> weiXinUsers = weiXinUserMapper.selectByExample(example);
        if(weiXinUsers!=null&&weiXinUsers.size()>0){
            WeiXinUser weiXinUser = weiXinUsers.get(0);
            WeiXinUser weiXinUser1 = VCache.get(openid, WeiXinUser.class);
            if(weiXinUser1==null){
                VCache.set(openid,weiXinUser);
            }
        }
    }

    @Override
    public Integer updateWeiXinUser(WeiXinUser user) {
        Integer i ;
        try {
            i = weiXinUserMapper.insertSelective(user);
        } catch (Exception e) {
            i = 0;
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 获取微信小程序 session_key 和 openid
     *
     * @author wl
     * @param code 调用微信登陆返回的Code
     * @return
     */
    public JSONObject getSessionKeyOropenid(String code){
        //微信端登录code值
        String appid = ResourceLoad.getResource("appid");
        String appsecret = ResourceLoad.getResource("appsecret");
        String requestUrl = ResourceLoad.getResource("url"); //请求地址 https://api.weixin.qq.com/sns/jscode2session

        Map<String,String> requestUrlParam = new HashMap<String,String>();
        requestUrlParam.put("appid", appid);  //开发者设置中的appId
        requestUrlParam.put("secret", appsecret); //开发者设置中的appSecret
        requestUrlParam.put("js_code", code); //小程序调用wx.login返回的code
        requestUrlParam.put("grant_type", "authorization_code");    //默认参数

        //发送post请求读取调用微信 https://api.weixin.qq.com/sns/jscode2session 接口获取openid用户唯一标识

        JSONObject jsonObject = JSON.parseObject(UrlUtil.sendPost(requestUrl, requestUrlParam));
        System.out.println("调用微信接口获取的数据："+jsonObject);
        return jsonObject;
    }
}
