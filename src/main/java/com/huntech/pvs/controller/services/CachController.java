package com.huntech.pvs.controller.services;

import com.alibaba.fastjson.JSONObject;
import com.huntech.pvs.common.redis.VCache;
import com.huntech.pvs.view.request.MessageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("cach")
public class CachController {


	//	展示用户信息
	@RequestMapping("insertCach")
	@ResponseBody
	public HashMap<String, Object>  information( @RequestBody MessageData messageData)
	{
		HashMap<String, Object> resMap = new HashMap<>();

		VCache.setVBySet(messageData.getMessage().getTo(), JSONObject.toJSON(messageData).toString());


		VCache.setCache(0,messageData.getMessage().getTo(), JSONObject.toJSON(messageData).toString(),1000*60*60*24*20);
		resMap.put("dataDesc","数据存储到了redis");
		System.out.println(messageData);
		resMap.put("dataCode","1");
		return resMap;
	}

}
