package com.huntech.pvs.service.services;

import com.huntech.pvs.core.feature.orm.mybatis.Page;
import com.huntech.pvs.model.services.Serv;
import com.huntech.pvs.model.sys.WeiXinUser;
import com.huntech.pvs.view.request.DetailServRequest;
import com.huntech.pvs.view.request.OptServRequest;
import com.huntech.pvs.view.services.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ServService {

    Page<ServView> getBaseServ(ServRequest servRequest);
    Page<ServView> getBaseServAnon(ServRequest servRequest);
    List<Serv> selectByExample(ServRequest servRequest);
//    Page<Serv> selectByExampleAndPage(ServRequest servRequest);


    Page<ServView> getBaseServOnMap(ServRequest servRequest);

    Integer releaseServ(ReleaseServRequest releaseServRequest, HttpServletRequest request);

    Page<ServView>  getReleaseServs(ServRequest servRequest,HttpServletRequest request);
     void insertServMan(String openid, WeiXinUser weiXinUser);
    Integer insertSelfAddServ(SelfAddServRequest selfAddServRequest, HttpServletRequest request);

    DetailServView getDetailServViewById(DetailServRequest detailServRequest);

    Serv selectByPrimaryKey(Long id);
    void optBaseServByUser(OptServRequest optServRequest);

    Integer deleteServ(ServRequest request) throws Exception;

    DetailServView getServById(ServRequest servRequest);

    Integer updateReleaseServ(ReleaseServRequest releaseServRequest);

    void transmits(OptServRequest optServRequest);
}
