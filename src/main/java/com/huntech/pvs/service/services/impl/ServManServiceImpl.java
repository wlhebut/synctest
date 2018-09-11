package com.huntech.pvs.service.services.impl;

import com.huntech.pvs.dao.services.ServManGpsMapper;
import com.huntech.pvs.dao.services.ServManMapper;
import com.huntech.pvs.model.address.Address;
import com.huntech.pvs.model.services.ServMan;
import com.huntech.pvs.model.services.ServManExample;
import com.huntech.pvs.model.services.ServManGps;
import com.huntech.pvs.model.services.ServManGpsExample;
import com.huntech.pvs.model.sys.WeiXinUser;
import com.huntech.pvs.service.address.AddressService;
import com.huntech.pvs.service.services.ServManGpsService;
import com.huntech.pvs.service.services.ServManService;
import com.huntech.pvs.service.sys.WeiXinUserService;
import com.huntech.pvs.view.request.ServManRequest;
import com.huntech.pvs.view.services.ServManView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ServManServiceImpl implements ServManService {


//    static  Long BASESERVTYPEID;

    @Autowired
    private WeiXinUserService weiXinUserService;
    @Autowired
    private ServManMapper servManMapper;
    @Autowired
    private ServManGpsMapper servManGpsMapper;
    @Autowired
    private ServManGpsService servManGpsService;
    @Autowired
    private AddressService addressService;
    @Override
    public ServManView getServMan(String openid) {

        WeiXinUser weiXinUserByOpenId = weiXinUserService.getWeiXinUserByOpenId(openid);
        ServManView servManView = new ServManView();
        List<Address> addressList=null;
        addressList = addressService.getAddress(weiXinUserByOpenId.getOpenId());
        Address address=null;
        if(addressList!=null&&addressList.size()>0){
            address=addressList.get(0);
        }
        if(openid!=null){
            if(weiXinUserByOpenId.getServManid()!=null){
                ServMan servMan= servManMapper.selectByPrimaryKey(weiXinUserByOpenId.getServManid());
                ServManGps servManGps=null;
                if(servMan!=null){
                    servManGps = servManGpsService.getServManGps(openid);
                }
                if(servMan!=null){
                    servManView.setId(servMan.getId());
                    servManView.setSage(servMan.getSage());
                    servManView.setSname(servMan.getSname());
                    servManView.setSsex(servMan.getSsex());
                    servManView.setStel(servMan.getStel());
                    servManView.setServAddress(servMan.getServAddress());
                    servManView.setIdentityCard(servMan.getIdentityCard());
                    insertGps(address,servManGps,servManView);
                    servManView.setSpic(openid);
                }
            }else{
                ServMan servMan = new ServMan();
                servMan.setEnable("1");
                servManMapper.insertSelective(servMan);
                servManView.setId(servMan.getId());
                servManView.setSname(weiXinUserByOpenId.getNickName());
                Byte gender = weiXinUserByOpenId.getGender();
                servManView.setSsex(String.valueOf(gender));
                servManView.setStel(weiXinUserByOpenId.getUserTel()==null?"":weiXinUserByOpenId.getUserTel());
                insertGps(address,null,servManView);
                servManView.setSpic(openid);
            }
            return servManView;
        }
        return null;

    }

    private void insertGps(Address address,ServManGps  servManGps ,ServManView servManView) {
        if(servManGps!=null){
            servManView.setLongitude(servManGps.getLongitude());
            servManView.setLatitude(servManGps.getLatitude());
        }else{
            if(address!=null){
                servManView.setLongitude(address.getLongitude());
                servManView.setLatitude(address.getLatitude());
            }else{
                servManView.setLongitude("");
                servManView.setLatitude("");
            }
        }

    }

    @Override
    public ServMan getServManByPriKey(Long id) {

        if(id!=null){
            ServMan servMan = servManMapper.selectByPrimaryKey(id);
            return servMan;
        }
        return null;
    }

    @Override
    public List<ServManView> getServMan(ServManRequest servManRequest) {
        Long id = servManRequest.getBaseservTypeid();
        String cityCode = servManRequest.getCityCode();
        String townCode = servManRequest.getTownCode();
        ServManExample example = new ServManExample();
        ServManExample.Criteria criteria = example.createCriteria();

        if(id!=null){
            criteria.andBaseservTypeidEqualTo(id);
        }
        if (cityCode!=null){
            criteria.andCityCodeEqualTo(cityCode);
        }
        if (townCode!=null){
            criteria.andTownCodeEqualTo(townCode);
        }
        List<ServMan> servMEN = servManMapper.selectByExample(example);

        ArrayList<ServManView> servManViews = new ArrayList<>();
        ArrayList<Long> longs = new ArrayList<>();
        for (ServMan servMan : servMEN) {
            longs.add(servMan.getServManGpsid());
        }

        ServManGpsExample example1 = new ServManGpsExample();
        ServManGpsExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andIdIn(longs);
        List<ServManGps> servManGps = servManGpsMapper.selectByExample(example1);
        HashMap<Long, ServManGps> servManGpsMap = new HashMap<>();
        for (ServManGps servManGp : servManGps) {
            servManGpsMap.put(servManGp.getId(),servManGp);
        }

        for (ServMan servMAN : servMEN) {
            ServManGps servManGps1 = servManGpsMap.get(servMAN.getServManGpsid());
            ServManView servManView = new ServManView();
            servManView.setId(servMAN.getId());
            if(servManGps1!=null){
                servManView.setLatitude(servManGps1.getLatitude());
                servManView.setLongitude(servManGps1.getLongitude());
            }
            servManView.setSname(servMAN.getSname());
            servManView.setSage(servMAN.getSage());
            servManView.setSsex(servMAN.getSsex());
            servManView.setStel(servMAN.getStel());
            servManViews.add(servManView);
        }

        return servManViews;
    }

    @Override
    public List<ServMan> getServMan(List<Object> ids) {
        ServManExample example = new ServManExample();
        ServManExample.Criteria criteria = example.createCriteria();
        List<Long> longs = (List<Long>)(List)ids;
        criteria.andIdIn(longs);
        List<ServMan> servMEN = servManMapper.selectByExample(example);
        return servMEN;
    }

    @Override
    public int updateByPriKey(ServMan man) {
        int i = servManMapper.updateByPrimaryKeySelective(man);
        return i;
    }

    /*@Override
    public List<BaseServTypeView> getBaseServTypeView(AddressRequest addressRequest) {

        Map<String,Object> params=new HashMap<>();
        String cityCode = addressRequest.getCityCode();
        String townCode = addressRequest.getTownCode();
        if(cityCode!=null){
            params.put("cityCode",cityCode);
        }
        if(townCode!=null){
            params.put("townCode",townCode);
        }
        List<BaseServTypeView> baseServTypeViewList = servManMapper.selectCountByServType(params);

        return  baseServTypeViewList;
    }*/

}
