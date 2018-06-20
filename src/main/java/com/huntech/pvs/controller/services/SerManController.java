package com.huntech.pvs.controller.services;

import com.huntech.pvs.common.BaseController;
import com.huntech.pvs.model.services.ServMan;
import com.huntech.pvs.service.services.ServManService;
import com.huntech.pvs.view.request.AddressRequest;
import com.huntech.pvs.view.request.ServManRequest;
import com.huntech.pvs.view.services.BaseServTypeView;
import com.huntech.pvs.view.services.ServManView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("serMan")
public class SerManController extends BaseController {

    @Autowired
    private ServManService servManService;

    @RequestMapping(value = "getServMan")
    @ResponseBody
    public Map<String, Object> getServMan() {
        List<ServMan> servMan = servManService.getServMan();
        resultMap.put("data",servMan);
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
    @RequestMapping(value = "getBaseServTypeView")
    @ResponseBody
    public Map<String, Object> getBaseServTypeView(AddressRequest addressRequest) {
        List<BaseServTypeView> list = servManService.getBaseServTypeView(addressRequest);
        resultMap.put("data",list);
        return resultMap;
    }

}
