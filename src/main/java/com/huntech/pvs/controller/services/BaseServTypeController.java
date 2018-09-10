package com.huntech.pvs.controller.services;

import com.huntech.pvs.common.BaseController;
import com.huntech.pvs.model.services.BaseServType;
import com.huntech.pvs.model.sys.WeiXinUser;
import com.huntech.pvs.service.services.BaseServTypeService;
import com.huntech.pvs.service.sys.WeiXinUserService;
import com.huntech.pvs.view.request.BaseServTypeRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Slf4j
@Controller
@RequestMapping("baseServType")
public class BaseServTypeController extends BaseController {

    @Autowired
    private BaseServTypeService baseServTypeService;

    @Autowired
    private WeiXinUserService weiXinUserService;
    /**
    * @Description:
    * @Param: [baseServType]
    * @return: java.util.Map<java.lang.String,java.lang.Object>
    * @Author: Mr.Wang
    * @Date: 2018/5/25
    */
    @RequestMapping(value = "getBaseServType")
    @ResponseBody
    public Map<String, Object> getBaseServType(@RequestBody BaseServType baseServType) {
        try {
            List<BaseServType> list = baseServTypeService.getBaseServType( baseServType);
            ArrayList<BaseServType> baseServTypes = new ArrayList<>();

            for (BaseServType servType : list) {
                if(servType.getId()!=1&&servType.getId()!=2){//去除关注与推荐分类
                    baseServTypes.add(servType);
                }
            }

            resultMap.put("data",baseServTypes);
            resultMap.put("dataCode","1");
        } catch (Exception e) {
            resultMap.put("dataCode","0");
            e.printStackTrace();
        }
        return resultMap;
    }

    /**
    * @Description:  根据用户的penid获取私服分类
    * @Param: [baseServType]
    * @return: java.util.Map<java.lang.String,java.lang.Object>
    * @Author: Mr.Wang
    * @Date: 2018/6/22
    */
    @RequestMapping(value = "getBaseServTypeByOpenId")
    @ResponseBody
    public Map<String, Object> getBaseServTypeByOpenId(@RequestBody  BaseServTypeRequest baseServType) {

        String openid = baseServType.getOpenid();//用户的openid。
        log.info("getBaseServTypeByOpenId():openid:{}",openid);
        try {
            List<BaseServType> list = baseServTypeService.getBaseServTypeByOpenId( baseServType);
            resultMap.put("data",list);
            resultMap.put("dataCode","1");
            resultMap.put("dataDesc","返回了私人定制版私人服务！");
            log.info("getBaseServTypeByOpenId():openid:返回数据 {}"+list.toString());
        } catch (Exception e) {
            resultMap.put("dataCode","-1");
            resultMap.put("dataDesc","系统错误");
            e.printStackTrace();
        }
        return resultMap;
    }

    @RequestMapping(value = "getBaseServTypeAnon")
    @ResponseBody
    public Map<String, Object> getBaseServTypeAnon() {

        try {
            List<BaseServType> list = baseServTypeService.getBaseServTypeAnon();
            resultMap.put("data",list);
            resultMap.put("dataCode","1");
            resultMap.put("dataDesc","匿名访问");
        } catch (Exception e) {
            resultMap.put("dataCode","0");
            e.printStackTrace();
        }
        return resultMap;
    }
    /**
    * @Description: 获取全部私服当前用户的补集
    * @Param: [baseServType]
    * @return: java.util.Map<java.lang.String,java.lang.Object>
    * @Author: Mr.Wang
    * @Date: 2018/6/22
    */
    @RequestMapping(value = "getOtherBaseServTypeByOpenId")
    @ResponseBody
    public Map<String, Object> getOtherBaseServTypeByOpenId(@RequestBody BaseServTypeRequest baseServType) {
        try {
            List<BaseServType> list = baseServTypeService.getOtherBaseServTypeByOpenId( baseServType);
            resultMap.put("data",list);
            resultMap.put("dataCode","1");
        } catch (Exception e) {
            resultMap.put("dataCode","0");
            e.printStackTrace();
        }
        return resultMap;
    }
    /**
    * @Description: 更新分类
    * @Param: [baseServTypes]
    * @return: java.util.Map<java.lang.String,java.lang.Object>
    * @Author: Mr.Wang
    * @Date: 2018/6/22
    */
    @RequestMapping(value = "updateBaseServTypeByOpenId")
    @ResponseBody
    public Map<String, Object> updateBaseServTypeByOpenId(@RequestBody BaseServTypeRequest baseServTypes) {
        try {
            Integer integer = baseServTypeService.updateByOpenId(baseServTypes);
            resultMap.put("dataCode","1");
        } catch (Exception e) {
            resultMap.put("dataCode","-1");
            e.printStackTrace();
        }
        return resultMap;
    }

}
