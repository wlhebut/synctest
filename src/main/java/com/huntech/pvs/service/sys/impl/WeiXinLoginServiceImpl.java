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
import com.huntech.pvs.model.sys.WeiXinLoginRequest;
import com.huntech.pvs.model.sys.WeiXinUser;
import com.huntech.pvs.model.sys.WeiXinUserExample;
import com.huntech.pvs.service.address.AddressService;
import com.huntech.pvs.service.services.SelfServTypeService;
import com.huntech.pvs.service.sys.WeiXinLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.*;

@Slf4j
@Service
public class WeiXinLoginServiceImpl implements WeiXinLoginService {

    @Autowired
    private SelfServTypeService selfServTypeService;

    @Autowired
    private WeiXinUserMapper weiXinUserMapper;

    @Autowired
    private AddressService addressService;
    @Override
    public String HasUser(WeiXinLoginRequest weiXinLoginRequest, HttpServletRequest request) {

        JSONObject userInfo = null;
        JSONObject sessionKeyOropenid=null;
        Map<String, String> params=null;
        String openid="";
        String session_key=null;


        if(weiXinLoginRequest.getCode()!=null&&weiXinLoginRequest.getCode().length()!=0){
            sessionKeyOropenid = getSessionKeyOropenid(weiXinLoginRequest.getCode());
        }

        //解析返回的json数据，获得OPPID
        if(sessionKeyOropenid!=null){
            params = JSONObject.parseObject(sessionKeyOropenid.toJSONString(), new TypeReference<Map<String, String>>(){});
        }
        if(params!=null){
            openid=params.get("openid");
            session_key=params.get("session_key");
            log.info("111......解析的params:{}",params);
        }else{
            return  null;
        }
        log.info("session_key{}",session_key);

        try {
            if(weiXinLoginRequest.getEncryptedData()!=null&&session_key!=null&&weiXinLoginRequest.getIv()!=null){
                try {
                    userInfo = DECRYPT.getUserInfo(weiXinLoginRequest.getEncryptedData(), session_key, weiXinLoginRequest.getIv());
                    log.info("22222.....微信服务器获取的用户信息：{}",userInfo);
                    if(null==userInfo){
                        return  openid;
                    }

                } catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidAlgorithmParameterException | InvalidKeyException e) {
                    log.error(e.toString());
                    e.printStackTrace();
                }
            }

        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }

        WeiXinUserExample weiXinUserExample = new WeiXinUserExample();
        WeiXinUserExample.Criteria criteria = weiXinUserExample.createCriteria();
        List<WeiXinUser> weiXinUsers =null;
        if(openid!=null&&!openid.equals("")){
            criteria.andOpenIdEqualTo(openid);
            weiXinUsers = weiXinUserMapper.selectByExample(weiXinUserExample);
        }

        System.out.println("查询当前登录用户的信息："+weiXinUsers.toString());

        WeiXinUser weiXinUser = new WeiXinUser();
        String country= (String)userInfo.get("country");
        String avatarUrl= (String)userInfo.get("avatarUrl");
        String nickName= (String)userInfo.get("nickName");
        String gender =String.valueOf(userInfo.get("gender"));
        if(weiXinUsers!=null){
            if(weiXinUsers.size()==0){
                weiXinUser.setOpenId(openid);
                if(userInfo!=null){
                    log.debug("gender:{}",gender);
                    weiXinUser.setCountry(country);
                    weiXinUser.setAvatarUrl(avatarUrl);
                    weiXinUser.setNickName(nickName);
                    weiXinUser.setGender(new Byte(gender));
                }
                weiXinUserMapper.insert(weiXinUser);
            }else if(weiXinUsers.size()==1){
                weiXinUser = weiXinUsers.get(0);
                weiXinUser.setCountry(country);
                weiXinUser.setAvatarUrl(avatarUrl);
                weiXinUser.setNickName(nickName);
                weiXinUser.setGender(new Byte(gender));
                weiXinUserMapper.updateByPrimaryKeySelective(weiXinUser);
            }
        }else{
            weiXinUser = weiXinUsers.get(0);
            weiXinUser.setCountry(country);
            weiXinUser.setAvatarUrl(avatarUrl);
            weiXinUser.setNickName(nickName);
            weiXinUser.setGender(new Byte(gender));
            weiXinUserMapper.updateByPrimaryKeySelective(weiXinUser);
        }
        if(openid!=null){
            Integer integer = selfServTypeService.selectCount(openid);
            if(integer<1){
                selfServTypeService.insertAllType(openid);
            }
        }
        return openid;
    }

    private void setparams(JSONObject userInfo, WeiXinUser weiXinUser) {
        weiXinUser.setNickName((String)userInfo.get("nickName"));
        weiXinUser.setAvatarUrl((String)userInfo.get("avatarUrl"));
        String gender =String.valueOf(userInfo.get("gender"));
        weiXinUser.setGender(new Byte(gender));
    }

    @Override
    public int insertUser(WeiXinUser weiXinUser) {
        int i=0;
        WeiXinUserExample example = new WeiXinUserExample();
        WeiXinUserExample.Criteria criteria = example.createCriteria();
        if(weiXinUser!=null){
            if(weiXinUser.getOpenId()!=null){
                criteria.andOpenIdEqualTo(weiXinUser.getOpenId());
                List<WeiXinUser> weiXinUsers = weiXinUserMapper.selectByExample(example);
                if(weiXinUsers!=null&&weiXinUsers.size()==0){
                    i = weiXinUserMapper.insertSelective(weiXinUser);
                }
            }
        }
        return i;
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
            if(weiXinUser1==null||!weiXinUser.equals(weiXinUser1)){
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
