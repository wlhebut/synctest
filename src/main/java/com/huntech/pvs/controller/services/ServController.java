package com.huntech.pvs.controller.services;

import com.huntech.pvs.common.BaseController;
import com.huntech.pvs.core.feature.orm.mybatis.Page;
import com.huntech.pvs.model.services.SelfServ;
import com.huntech.pvs.model.services.Serv;
import com.huntech.pvs.model.services.ServMan;
import com.huntech.pvs.service.services.SelfServService;
import com.huntech.pvs.service.services.ServManService;
import com.huntech.pvs.service.services.ServService;
import com.huntech.pvs.view.request.DetailServRequest;
import com.huntech.pvs.view.request.OptServRequest;
import com.huntech.pvs.view.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("serv")
public class ServController extends BaseController {

    @Autowired
    private ServService servService;

    @Autowired
    private SelfServService selfServService;

    @Autowired
    private ServManService servManService;
/**
* @Description: find serv
* @Param: [servRequest]
* @return: java.util.Map<java.lang.String,java.lang.Object>
* @Author: Mr.Wang
* @Date: 2018/5/25
*/
    @RequestMapping(value = "getBaseServ")
    @ResponseBody
    public Map<String, Object> getBaseServ(@RequestBody ServRequest servRequest) {

        if(servRequest.getBaseservTypeid()==null){
            resultMap.put("dataCode","0");
            resultMap.put("dataDesc","缺少参数");
            return resultMap;
        }
        try {
            Page<ServView> list = servService.getBaseServ( servRequest);
            resultMap.put("data",list);
            resultMap.put("dataCode","1");
            return resultMap;
        } catch (Exception e) {
            resultMap.put("dataCode","-1");
            resultMap.put("dataDesc","后台错误");
            e.printStackTrace();
            return resultMap;
        }
    }
    /**
    * @Description: get serv on map
    * @Param: [servRequest]
    * 	"state":"1",
    *   "servType":"0",
        "baseservTypeid":"4",
        "longitude":2.123213,
        "latitude":234.324222222,
        "zoom":15
    * @return: java.util.Map<java.lang.String,java.lang.Object>
    * @Author: Mr.Wang
    * @Date: 2018/5/25
    */
    @RequestMapping(value = "getBaseServOnMap")
    @ResponseBody
    public Map<String, Object> getBaseServOnMap(@RequestBody ServRequest servRequest) {
        Page<ServView> list = servService.getBaseServOnMap( servRequest);
        resultMap.put("data",list);
        return resultMap;
    }

    /*@RequestMapping(value = "getAllBaseServ")
    @ResponseBody
    public Map<String, Object> getAllBaseServ(ServRequest servRequest) {
//        List<ServView> list = servService.getBaseServ( servRequest);
        Page<Serv> list = servService.selectByExampleAndPage( servRequest);
        resultMap.put("data",list);
        return resultMap;
    }*/
    @RequestMapping(value = "releaseServ")
    @ResponseBody
    public Map<String, Object> releaseServ(@RequestBody ReleaseServRequest releaseServRequest, HttpServletRequest request) {
//        List<ServView> list = servService.getBaseServ( servRequest);
        try {
            servService.releaseServ( releaseServRequest,request);
            resultMap.put("dataCode",1);
        } catch (Exception e) {
            resultMap.put("dataCode",-1);
            e.printStackTrace();
        }
        return resultMap;
    }
    @RequestMapping(value = "insertSelfAddServ")
    @ResponseBody
    public Map<String, Object> insertSelfAddServ(@RequestBody SelfAddServRequest selfAddServRequest, HttpServletRequest request) {
//        List<ServView> list = servService.getBaseServ( servRequest);
        Integer integer;
        try {
            integer = selfServService.insertSelfAddServ( selfAddServRequest,request);
            resultMap.put("data",integer);
            resultMap.put("dataCode","1");
        } catch (Exception e) {
            resultMap.put("dataCode","-1");
            e.printStackTrace();
        }
        return resultMap;
    }
    @RequestMapping(value = "getSelfServ")
    @ResponseBody
    public Map<String, Object> getSelfServ(HttpServletRequest request) {
        List<SelfServ> selfServs;
        try {
            selfServs = selfServService.getSelfServs(request);
            resultMap.put("data",selfServs);
            resultMap.put("dataCode","1");
        } catch (Exception e) {
            resultMap.put("dataCode","-1");
            e.printStackTrace();
        }
        return resultMap;
    }
    @RequestMapping(value = "getReleaseServs")
    @ResponseBody
    public Map<String, Object> getReleaseServs(@RequestBody ServRequest servRequest,HttpServletRequest request) {
//        List<ServView> list = servService.getBaseServ( servRequest);
        try {
            Page<ServView> releaseServs = servService.getReleaseServs(servRequest,request);
            resultMap.put("data",releaseServs);
            resultMap.put("dataCode",1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            resultMap.put("dataCode",0);
        }

        return resultMap;
    }

    @RequestMapping(value = "getDetailBaseServ")
    @ResponseBody
    public Map<String, Object> getDetailBaseServ(@RequestBody DetailServRequest detailServRequest) {

        if(detailServRequest!=null&&detailServRequest.getId()!=null){
            try {
                DetailServView detailServView = servService.getDetailServViewById(detailServRequest);
                resultMap.put("data",detailServView);
                resultMap.put("dataCode","1");
                return resultMap;
            } catch (Exception e) {
                resultMap.put("dataCode","-1");
                e.printStackTrace();
                return  resultMap;
            }
        }
        resultMap.put("dataCode","0");//参数不全
        resultMap.put("dataDesc","参数不全");//参数不全
        return resultMap;
    }

    /**
    * @Description:
     *
     * 输入参数	servid	必填项	对应列表id
                disserv		 （喜欢：1，不喜欢0）
                attention		红心（关注：1，不关注0 ）
                illegal		违法内容 illegal  （违法：1，不违法0）
                classification		（分类错误1，没错误0）
                openid		用户的openid

     *
    * @Param: [detailServRequest]
    * @return: java.util.Map<java.lang.String,java.lang.Object>
    * @Author: Mr.Wang
    * @Date: 2018/6/22
    */
    @RequestMapping(value = "optBaseServByUser")
    @ResponseBody
    public Map<String, Object> optBaseServByUser(@RequestBody OptServRequest optServRequest) {
        try {
            servService.optBaseServByUser(optServRequest);
            resultMap.put("dataCode","1");
        } catch (Exception e) {
            resultMap.put("dataCode","0");
            e.printStackTrace();
        }
        return resultMap;
    }

    //	用于获取发送信息时的头像，使用流
    @RequestMapping("/head/{servManid}")
    public void gethead(@PathVariable("servManid")Long servManid, HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String realurl=request.getServletContext().getRealPath("/");
        ServMan man = servManService.getServManByPriKey(servManid);
        if(man!=null){
            String imageurl=man.getSpic();
            String url=realurl+"images"+ File.separator+imageurl;
            InputStream inputStream;
            if(new File(url).exists()){
                inputStream=new FileInputStream(url);
            }else{
                url=realurl+"images"+ File.separator+"default.png";
                inputStream=new FileInputStream(url);
            }

            ServletOutputStream outputStream=response.getOutputStream();
            response.setContentType("image/jpeg; charset=UTF-8");
            byte[] buffer=new byte[1024];
            int i;
            while((i=inputStream.read(buffer))!=-1)
            {
                outputStream.write(buffer, 0, i);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        }







    }



}
