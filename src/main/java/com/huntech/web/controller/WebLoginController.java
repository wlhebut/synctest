package com.huntech.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.huntech.pvs.dto.sys.User;
import com.huntech.pvs.service.sys.UserService;
import com.huntech.pvs.common.ResourceLoad;
import com.huntech.pvs.common.UrlUtil;
import com.huntech.pvs.model.sys.WeinXinCode;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JHT0701 on 2015/11/19.
 */
@Controller
@RequestMapping(value = "/web")
public class WebLoginController {
	@Resource
	private UserService userService;
	private static String sqliteMD5;

    private Logger log = Logger.getLogger(getClass().getName());
	@RequestMapping(value = "/login")
	@ResponseBody
	public HashMap<String, WeinXinCode> login(String loginName, String password, String code, HttpServletRequest request) {

		HashMap<String, WeinXinCode> resMap = new HashMap<>();


		JSONObject sessionKeyOropenid = getSessionKeyOropenid(code);
		//解析返回的json数据，获得OPPID
		Map<String, String> params = JSONObject.parseObject(sessionKeyOropenid.toJSONString(), new TypeReference<Map<String, String>>(){});
		String openid=params.get("openid");
		String session_key=params.get("session_key");
		if(openid!=null){
            /*在此处添加自己的逻辑代码，将openid保存在数据库，或是，使用session_key去微信服务器换取用户头像、昵称等信息。我在这里并没有用到，因此我只保存了用户的openid*/

		}



		User user = new User();
		user.setLoginName(openid);
		user.setPassword(session_key);
		updateSession(user, request);

		User user1 = userService.selectByUsername(user.getLoginName());
		if (null != user1){
			WeinXinCode weinXinCode = new WeinXinCode();
			weinXinCode.setOpenid(openid);
			weinXinCode.setSessionKey(session_key);
			resMap.put("data",weinXinCode);
		}else{
			userService.insert(user);
		}
		return resMap;
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
		return jsonObject;
	}


	/**
	 * 解密用户敏感数据获取用户信息
	 *
	 * @author wl
	 * @param1 sessionKey 数据进行加密签名的密钥
	 * @param1 encryptedData 包括敏感数据在内的完整用户信息的加密数据
	 * @param1 iv 加密算法的初始向量
	 * @return
	 */
	/*public  JSONObject getUserInfo(String encryptedData,String sessionKey,String iv){
		// 被加密的数据
		byte[] dataByte = Base64.decode(encryptedData);
		// 加密秘钥
		byte[] keyByte = Base64.decode(sessionKey);
		// 偏移量
		byte[] ivByte = Base64.decode(iv);
		try {
			// 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
			int base = 16;
			if (keyByte.length % base != 0) {
				int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
				byte[] temp = new byte[groups * base];
				Arrays.fill(temp, (byte) 0);
				System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
				keyByte = temp;
			}
			// 初始化
			Security.addProvider(new BouncyCastleProvider());
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");
			SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
			AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
			parameters.init(new IvParameterSpec(ivByte));
			cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
			byte[] resultByte = cipher.doFinal(dataByte);
			if (null != resultByte && resultByte.length > 0) {
				String result = new String(resultByte, "UTF-8");
				return JSON.parseObject(result);
			}
		} catch (NoSuchAlgorithmException e) {
			log.error(e.getMessage(), e);
		} catch (NoSuchPaddingException e) {
			log.error(e.getMessage(), e);
		} catch (InvalidParameterSpecException e) {
			log.error(e.getMessage(), e);
		} catch (IllegalBlockSizeException e) {
			log.error(e.getMessage(), e);
		} catch (BadPaddingException e) {
			log.error(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage(), e);
		} catch (InvalidKeyException e) {
			log.error(e.getMessage(), e);
		} catch (InvalidAlgorithmParameterException e) {
			log.error(e.getMessage(), e);
		} catch (NoSuchProviderException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}*/



	private void updateSession(User user,  HttpServletRequest request) {
		log.info("[RemoteAddr] >>> "+request.getRemoteAddr());
		try {
			Subject subject = SecurityUtils.getSubject();
			subject.login(new UsernamePasswordToken(user.getLoginName(), user.getPassword()));// validate
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
	}





}