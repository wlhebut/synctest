package com.huntech.pvs.controller.services;

import com.alibaba.fastjson.JSON;
import com.huntech.pvs.common.BaseController;
import com.huntech.pvs.common.util.JWT;
import com.huntech.pvs.dto.sys.User;
import com.huntech.pvs.model.services.Serv;
import com.huntech.pvs.model.services.ServMan;
import com.huntech.pvs.model.services.ServManGps;
import com.huntech.pvs.model.sys.WeiXinUser;
import com.huntech.pvs.service.services.ServManGpsService;
import com.huntech.pvs.service.services.ServManService;
import com.huntech.pvs.service.services.ServService;
import com.huntech.pvs.service.sys.WeiXinUserService;
import com.huntech.pvs.view.request.AddressRequest;
import com.huntech.pvs.view.request.ServManRequest;
import com.huntech.pvs.view.services.BaseServTypeView;
import com.huntech.pvs.view.services.ServManView;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("serMan")
public class SerManController extends BaseController {

    @Autowired
    private ServManService servManService;
    @Autowired
    private WeiXinUserService weiXinUserService;

    @Autowired
    private ServManGpsService servManGpsService;
    @Autowired
    private ServService servService;
    @RequestMapping(value = "getServMan")
    @ResponseBody
    public Map<String, Object> getServMan(@RequestBody ServManRequest servManRequest) {
        if (servManRequest != null && servManRequest.getOpenid() != null && !"".equals(servManRequest.getOpenid())) {
            String openid = servManRequest.getOpenid();
            ServManView servMan = servManService.getServMan(openid);
            resultMap.clear();
            resultMap.put("data", servMan);
            resultMap.put("dataCode", 1);
            return  resultMap;
        } else {
            resultMap.clear();
            resultMap.put("data", new ServMan());
            resultMap.put("dataCode", -1);
            return  resultMap;
        }
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
    @RequestMapping("/uploadImg")
    @ResponseBody
    public Map<String, Object> uploadImg(ServManRequest manRequest, MultipartFile file, HttpServletRequest request, RedirectAttributes redirectAttributes) throws IllegalStateException, IOException {

        String token = request.getHeader("token");
        String openid = JWT.unsign(token, String.class);
        String imagename="";
        String imageurlnotag="";
        if(openid==null||openid.equals("")){
            openid=manRequest.getOpenid();
        }

        String real=request.getServletContext().getRealPath("/");
        if(file!=null){
            imagename=file.getOriginalFilename();
            System.out.println("imagename:"+imagename);
            imageurlnotag=File.separator+openid+imagename.substring(imagename.lastIndexOf("."));
            File file1=new File(real+"images");
            if(!file1.exists())
            {
                file1.mkdirs();
            }
            File imageurl=new File(real+"images"+File.separator+imageurlnotag);
            file.transferTo(imageurl);//将源图片复制到制定位置
        }
        resultMap.clear();
        resultMap.put("dataCode",-1);
        return resultMap;
    }


    @RequestMapping("/saveServMan")
    @ResponseBody
    public Map<String, Object> saveServMan(@RequestBody ServManRequest manRequest, HttpServletRequest request) throws IllegalStateException, IOException {

        String token = request.getHeader("token");
        String openid = JWT.unsign(token, String.class);

        if(openid==null||openid.equals("")){
            openid=manRequest.getOpenid();
        }
        if(openid==null){
            resultMap.clear();
            resultMap.put("dataCode",-1);
            return resultMap;
        }

        WeiXinUser weiXinUser = weiXinUserService.getWeiXinUserByOpenId(openid);
        weiXinUser.setLongitude(manRequest.getLongitude());
        weiXinUser.setLatitude(manRequest.getLatitude());
        weiXinUser.setUserTel(manRequest.getStel());
        weiXinUser.setUnionId(manRequest.getIdentityCard());
        weiXinUser.setCompanyAddress(manRequest.getServAddress());
        weiXinUser.setNickName(manRequest.getSname());

        weiXinUserService.updateWeiXinUserByOpenId(weiXinUser);

        if(weiXinUser!=null){
            Long servManid = weiXinUser.getServManid();
            if(servManid!=null){
                ServMan man = new ServMan();
                man.setId(servManid);
                if(manRequest.getSname()!=null&&manRequest.getSname().length()!=0){
                    man.setSname(manRequest.getSname());
                }
                if(manRequest.getSsex()!=null&&manRequest.getSsex().length()!=0){
                    man.setSsex(manRequest.getSsex());//0-女；1:-男.
                }
                if(manRequest.getStel()!=null&&manRequest.getStel().length()!=0){
                    man.setStel(manRequest.getStel());
                }
                if(manRequest.getLocationname()!=null&&manRequest.getLocationname().length()!=0){
                    man.setServAddress(manRequest.getLocationname());
                }
                if(manRequest.getIdentityCard()!=null&&manRequest.getIdentityCard().length()!=0){
                    man.setIdentityCard(manRequest.getIdentityCard());
                }

                man.setEnable("1");
                int i = servManService.updateByPriKey(man);
                Long servManGpsid = man.getServManGpsid();

                ServManGps servManGps ;

                if(servManGpsid==null){
                    servManGps = servManGpsService.getServManGps(servManid);
                }else{
                    servManGps =servManGpsService.getServManGps(servManGpsid);
                }
                if(servManGps!=null){
                    servManGps.setLongitude(manRequest.getLongitude());
                    servManGps.setLatitude(manRequest.getLatitude());
                    servManGpsService.saveServManGpa(servManGps);
                }
                resultMap.clear();
                resultMap.put("dataCode",i);
                return resultMap;
            }else{
                servService.insertServMan(openid, weiXinUser);
                resultMap.clear();
                resultMap.put("dataCode",1);
                return resultMap;
            }
        }
        resultMap.clear();
        resultMap.put("dataCode",-1);
        return resultMap;
    }



    //获取头像

    @RequestMapping("pic/{openid}")
    public void getServManPic(@PathVariable("openid")String openid, HttpServletRequest request, HttpServletResponse response ) throws IOException{
        String realPath = request.getServletContext().getRealPath("/");
        String url=realPath+File.separator+"images"+File.separator+openid;
        logger.info("log:reuest-->url:{}"+url);
        System.out.println(url);
        String png=".png";
        String jpg=".jpg";
        String jpeg=".jpeg";
        InputStream inputStream;
        if(new File(url+png).exists()){
            inputStream=new FileInputStream(url+png);
        }else if(new File(url+jpg).exists()){
            inputStream=new FileInputStream(url+jpg);
        }else if(new File(url+jpeg).exists()){
            inputStream=new FileInputStream(url+jpeg);
        }else{
            url=realPath+File.separator+"images"+File.separator+"default.png";
            inputStream=new FileInputStream(url);
        }
        ServletOutputStream outputStream = response.getOutputStream();
        response.setContentType("image/jpeg; charset=UTF-8");

        byte[] bytes = new byte[1024];
        int i;
        while ((i=inputStream.read(bytes))!=-1){
            outputStream.write(bytes,0, i);
        }
        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }
}
