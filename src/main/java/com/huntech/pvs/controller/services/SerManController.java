package com.huntech.pvs.controller.services;

import com.huntech.pvs.common.BaseController;
import com.huntech.pvs.common.util.JWT;
import com.huntech.pvs.dto.sys.User;
import com.huntech.pvs.model.services.ServMan;
import com.huntech.pvs.model.sys.WeiXinUser;
import com.huntech.pvs.service.services.ServManService;
import com.huntech.pvs.service.sys.WeiXinUserService;
import com.huntech.pvs.view.request.AddressRequest;
import com.huntech.pvs.view.request.ServManRequest;
import com.huntech.pvs.view.services.BaseServTypeView;
import com.huntech.pvs.view.services.ServManView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("serMan")
public class SerManController extends BaseController {

    @Autowired
    private ServManService servManService;
    @Autowired
    private WeiXinUserService weiXinUserService;


    @RequestMapping(value = "getServMan")
    @ResponseBody
    public Map<String, Object> getServMan(@RequestBody ServManRequest servManRequest) {
        try {
            if(servManRequest!=null&&servManRequest.getOpenid()!=null){
                String openid=servManRequest.getOpenid();
                ServMan servMan = servManService.getServMan(openid);
                resultMap.put("data",servMan);
                resultMap.put("dataCode",-1);
            }else{
                resultMap.put("dataCode",1);
            }

        } catch (Exception e) {
            resultMap.put("dataCode",-1);
            e.printStackTrace();
        }
        return resultMap;
    }


    @RequestMapping(value = "getServManByServType")
    @ResponseBody
    public Map<String, Object> getServManByServType(ServManRequest servManRequest) {

        List<ServManView> servMan = servManService.getServMan(servManRequest);
        resultMap.put("data",servMan);
        return resultMap;
    }


    @RequestMapping(value = "getServManById")
    @ResponseBody
    public Map<String, Object> getServManById( List<Object> ids) {
        List<ServMan> servMan = servManService.getServMan( ids);
        resultMap.put("data",servMan);
        return resultMap;
    }
    /*@RequestMapping(value = "getBaseServTypeView")
    @ResponseBody
    public Map<String, Object> getBaseServTypeView(AddressRequest addressRequest) {
        List<BaseServTypeView> list = servManService.getBaseServTypeView(addressRequest);
        resultMap.put("data",list);
        return resultMap;
    }*/

    //	上传头像
    /**
    * @Description: 修改我的资料 包括上传图片
    * @Param: [man, file, request, redirectAttributes]
    * @return: java.util.Map<java.lang.String,java.lang.Object>
    * @Author: Mr.Wang
    * @Date: 2018/6/25
    */
    @RequestMapping("/update")
    @ResponseBody
    public Map<String, Object> update(ServManRequest manRequest, MultipartFile file, HttpServletRequest request, RedirectAttributes redirectAttributes) throws IllegalStateException, IOException {

        String token = request.getHeader("token");
        String openid = JWT.unsign(token, String.class);
        if(openid==null||openid.equals("")){
            openid=manRequest.getOpenid();
        }

        String real=request.getServletContext().getRealPath("/");
        String imagename=file.getOriginalFilename();
        System.out.println("imagename:"+imagename);
        String imageurlnotag=File.separator+openid+imagename.substring(imagename.lastIndexOf("."));
        File file1=new File(real+"images");
        if(!file1.exists())
        {
            file1.mkdirs();
        }
        File imageurl=new File(real+"images"+File.separator+imageurlnotag);
        file.transferTo(imageurl);//将源图片复制到制定位置
        WeiXinUser weiXinUser = weiXinUserService.getWeiXinUserByOpenId(openid);

        if(weiXinUser!=null){
            Long servManid = weiXinUser.getServManid();
            if(servManid!=null){
                ServMan man = new ServMan();
                man.setId(servManid);
                man.setSpic(imageurlnotag);
                man.setSname(manRequest.getSname()==null?"-":manRequest.getSname());
                man.setSsex(manRequest.getSsex()==null?"-":manRequest.getSsex());//0-女；1:-男.
                man.setStel(manRequest.getStel()==null?"-":manRequest.getStel());
                man.setEnable("1");
                int i = servManService.updateByPriKey(man);
                resultMap.put("dataCode",i);
                return resultMap;
            }
        }
        resultMap.put("dataCode",-1);
        return resultMap;
    }

}
