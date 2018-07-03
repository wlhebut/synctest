package com.huntech.pvs.controller.login;

import com.huntech.pvs.common.redis.JedisManager;
import com.huntech.pvs.common.util.JWT;
import com.huntech.pvs.common.util.SpringContextUtil;
import com.huntech.pvs.dto.sys.User;
import com.huntech.pvs.model.services.BaseServType;
import com.huntech.pvs.model.services.SelfBaseServType;
import com.huntech.pvs.model.sys.WeiXinLoginRequest;
import com.huntech.pvs.model.sys.WeiXinUser;
import com.huntech.pvs.service.services.BaseServTypeService;
import com.huntech.pvs.service.services.SelfServTypeService;
import com.huntech.pvs.service.sys.WeiXinLoginService;
import com.huntech.pvs.view.request.BaseServTypeRequest;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JHT0701 on 2015/11/19.
 */
@Controller
@RequestMapping(value = "login")
public class WeinXinLoginController {
	@Resource
	private WeiXinLoginService weiXinLoginService;
	private static String sqliteMD5;

	private static int ERROCODE0=0;//参数不全
	private static int ERROCODE1=1;//参数不全

    private Logger log = Logger.getLogger(getClass().getName());


    @Autowired
    private BaseServTypeService baseServTypeService;
    @Autowired
    private SelfServTypeService selfServTypeService;

	@RequestMapping(value = "login")
	@ResponseBody
	public HashMap<String, Object> login(@RequestBody WeiXinLoginRequest weiXinLoginRequest, HttpServletRequest request) {

		HashMap<String, Object> resMap = new HashMap<>();
		String code = weiXinLoginRequest.getCode();
		String encryptedData = weiXinLoginRequest.getEncryptedData();
		String iv = weiXinLoginRequest.getIv();
		if(null==code||code.equals("")){
			resMap.put("dataCode",ERROCODE0);
			resMap.put("JSESSIONID","BROWSETOURISTS");//浏览游客，拒绝获取用户的信息。
			insertIntoRedis("JSESSIONID","BROWSETOURISTS");
			return resMap;
		}
		System.out.println("----------------------11111111---------------------------");
		System.out.println("encryptedData="+encryptedData);
		System.out.println("iv="+iv);
		System.out.println("code="+code);
		System.out.println("------------------------2222222-------------------------");
//		String openid = weiXinLoginService.HasUser(weiXinLoginRequest);
		String openid="okTs65C1THvPV39Q9uuqW_p4h7Jk";
		System.out.println("当前登录openid:"+openid);
//		request.getSession().setAttribute("openid",openid);
//		weiXinLoginService.insertInToRedis(openid);
		BaseServTypeRequest baseServTypeRequest = new BaseServTypeRequest();
		baseServTypeRequest.setOpenid(openid);
		/*List<BaseServType> baseServTypes = baseServTypeService.getBaseServTypeByOpenId(baseServTypeRequest);
		if(baseServTypes!=null&&baseServTypes.size()>0){
		}else{
			selfServTypeService.insertAllType(openid);
		}*/


		if(openid!=null){
			//给用户jwt加密生成token
			String token = JWT.sign(openid, 60*1000*60*24*10);
			resMap.put("dataCode",ERROCODE1);//数据库现在已经有了。
			resMap.put("token",token);//给小程序前端，有小程序需要携带此信息到后台。
			resMap.put("openid",openid);//给小程序前端，有小程序需要携带此信息到后台。
//			insertIntoRedis(openid,openid);
			weiXinLoginService.insertInToRedis(openid);
			System.out.println("insert ok"+weiXinLoginRequest.getCode());
		}

		return resMap;
	}

	private void insertIntoRedis(String key,String value) {
		Object testSource = SpringContextUtil.getBean("jedisManager",JedisManager.class);
		JedisManager jedisManager=(JedisManager)testSource;
		try {
			jedisManager.saveValueByKey(1,key,value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "getWeinXinUser")
	@ResponseBody
	public Map<String, Object> getWeinXinUser(HttpServletRequest request){
		Map<String, Object> resMap = new HashMap<>();
		WeiXinUser weinXinUser = null;
		try {
			weinXinUser = weiXinLoginService.getWeinXinUser(request);
			if(weinXinUser!=null){
				resMap.put("data","weinXinUser");
				resMap.put("dataCode","1");
			}
		} catch (Exception e) {
			resMap.put("dataCode","-1");
			e.printStackTrace();
		}

		resMap.put("data",weinXinUser);
		return resMap;

	}

	@RequestMapping(value = "updateWeinXinUser")
	@ResponseBody
	public Map<String, Object> updateWeinXinUser(WeiXinUser user){
		Map<String, Object> resMap = new HashMap<>();
		Integer integer=0;
		try {
			integer = weiXinLoginService.updateWeiXinUser(user);
			if(integer!=null){
				resMap.put("data","weinXinUser");
				resMap.put("dataCode","1");
			}
		} catch (Exception e) {
			resMap.put("dataCode","-1");
			e.printStackTrace();
		}

		resMap.put("data",integer);
		return resMap;

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