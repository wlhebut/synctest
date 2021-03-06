package com.huntech.pvs.service.services;

import com.huntech.pvs.core.feature.orm.mybatis.Page;
import com.huntech.pvs.model.services.Serv;
import com.huntech.pvs.view.request.DetailServRequest;
import com.huntech.pvs.view.services.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ServService {

    Page<ServView> getBaseServ(ServRequest servRequest);
    List<Serv> selectByExample(ServRequest servRequest);
    Page<Serv> selectByExampleAndPage(ServRequest servRequest);


    Page<ServView> getBaseServOnMap(ServRequest servRequest);

    Integer releaseServ(ReleaseServRequest releaseServRequest, HttpServletRequest request);

    Page<ServView>  getReleaseServs(ServRequest servRequest,HttpServletRequest request);

    Integer insertSelfAddServ(SelfAddServRequest selfAddServRequest, HttpServletRequest request);

    DetailServView getDetailServViewById(DetailServRequest detailServRequest);

}
