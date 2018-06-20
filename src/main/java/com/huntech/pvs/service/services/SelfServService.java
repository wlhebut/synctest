package com.huntech.pvs.service.services;

import com.huntech.pvs.core.feature.orm.mybatis.Page;
import com.huntech.pvs.model.services.SelfServ;
import com.huntech.pvs.model.services.Serv;
import com.huntech.pvs.view.services.ReleaseServRequest;
import com.huntech.pvs.view.services.SelfAddServRequest;
import com.huntech.pvs.view.services.ServRequest;
import com.huntech.pvs.view.services.ServView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SelfServService {

    List<SelfServ>  getSelfServs(HttpServletRequest request);

    Integer insertSelfAddServ(SelfAddServRequest selfAddServRequest, HttpServletRequest request);
}
