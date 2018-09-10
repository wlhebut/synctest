package com.huntech.pvs.controller.login;

import com.huntech.pvs.common.BaseController;
import com.huntech.pvs.common.redis.JedisManager;
import com.huntech.pvs.common.util.JWT;
import com.huntech.pvs.common.util.SpringContextUtil;
import com.huntech.pvs.dto.sys.User;
import com.huntech.pvs.model.sys.WeiXinLoginRequest;
import com.huntech.pvs.model.sys.WeiXinUser;
import com.huntech.pvs.service.services.BaseServTypeService;
import com.huntech.pvs.service.services.SelfServTypeService;
import com.huntech.pvs.service.sys.WeiXinLoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JHT0701 on 2015/11/19.
 */
@Slf4j
@Controller
@RequestMapping(value = "login")
public class WeinXinLoginController  extends BaseController {
	@Resource
	private WeiXinLoginService weiXinLoginService;

    @Autowired
    private BaseServTypeService baseServTypeService;
    @Autowired
    private SelfServTypeService selfServTypeService;

	@RequestMapping(value = "login")//登录信息保存在服务器etc/wise_serv
	@ResponseBody
	public  Map<String, Object> login(@RequestBody WeiXinLoginRequest weiXinLoginRequest, HttpServletRequest request) {
//获取所有的头部参数
		log.info("{}访问login方法：",new Date());
		String code = weiXinLoginRequest.getCode();
		String encryptedData = weiXinLoginRequest.getEncryptedData();
		String iv = weiXinLoginRequest.getIv();
		log.info("code:{}",code);
		log.info("encryptedData:{}",encryptedData);
		log.info("iv:{}",iv);
		String openid=weiXinLoginService.HasUser(weiXinLoginRequest,request);
		if(null!=openid&&!"".equals(openid)){
			//给用户jwt加密生成token
			String token = JWT.sign(openid, 60*1000*60*24*10);
			resultMap.put("dataCode", RESCODE);//
			resultMap.put("token",token);//给小程序前端，有小程序需要携带此信息到后台。
			resultMap.put("openid",openid);//给小程序前端，有小程序需要携带此信息到后台。
			weiXinLoginService.insertInToRedis(openid);
			log.info("登录login方法返回的token:{}",token);
			log.info("openid:{}",openid);
			System.out.println(openid+":insert redis");
			return resultMap;
		}
			resultMap.put("dataCode", SYS_ERROR_CODE);//
			resultMap.put("token","");//给小程序前端，有小程序需要携带此信息到后台。
			resultMap.put("openid","");//给小程序前端，有小程序需要携带此信息到后台。
			return resultMap;


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