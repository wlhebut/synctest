package com.huntech.pvs.service.services.impl;

import com.huntech.pvs.common.redis.VCache;
import com.huntech.pvs.dao.services.LabelMapper;
import com.huntech.pvs.dao.services.ServStarMapper;
import com.huntech.pvs.model.services.*;
import com.huntech.pvs.model.sys.WeiXinUser;
import com.huntech.pvs.service.services.LabelService;
import com.huntech.pvs.service.services.ServManService;
import com.huntech.pvs.service.services.ServService;
import com.huntech.pvs.service.services.ServStarService;
import com.huntech.pvs.service.sys.WeiXinUserService;
import com.huntech.pvs.view.request.LabelRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class LabelServiceImpl implements LabelService {


    @Autowired
    private WeiXinUserService weiXinUserService;

    @Autowired
    private ServManService servManService;

    @Autowired
    private ServService servService;
    @Autowired
    private LabelMapper labelMapper;

    @Autowired
    private ServStarService servStarService;
    @Override
    public List<Label> getLabelsByServId(Long servId) {

        LabelExample labelExample = new LabelExample();
        LabelExample.Criteria criteria = labelExample.createCriteria();
        criteria.andServIdEqualTo(servId);
        List<Label> labels = labelMapper.selectByExample(labelExample);
        return labels;
    }

    @Override
    public Integer insertLabel(LabelRequest labelRequest) {
        String openid = labelRequest.getOpenid();
        Long id = labelRequest.getId();
        String servManid = null;
        int servStar = labelRequest.getServStar();
        Serv serv = servService.selectByPrimaryKey(id);
        WeiXinUser weiXinUser1 = VCache.get(openid, WeiXinUser.class);
        if(weiXinUser1==null){
             weiXinUser1 = weiXinUserService.getWeiXinUserByOpenId(openid);
            VCache.setCache(1,openid,weiXinUser1,1000*60*60*24*30);
        }
        if(serv!=null){
            if(weiXinUser1!=null){
                 servManid = serv.getServManid();
                labelRequest.setServManid(servManid);
                Long servManid1 = weiXinUser1.getServManid();
                if(Objects.equals(servManid, servManid1)){
                    return 2;
                }
            }else{
                //需要获取微信授权。
                return -3;
            }

        }else{
            return -1;//系统错误
        }
        int labelNums = this.getLabelNums(labelRequest);
        if(labelNums>10){
            return 0;
        }
        Label label = new Label();

        label.setLabelContent(labelRequest.getLabelContent());
        label.setServId(labelRequest.getId());//对此服务做了评价
        label.setServManid(servManid);//对此人做了评价
        label.setOpenid(openid);//此人做了评价。
        label.setServManid(serv.getServManid());
        int i = labelMapper.insertSelective(label);
        if(labelRequest.getId()!=null&&servStar==1){
            ServStar servStar1 = servStarService.getServStarByServId(labelRequest.getId());
            if(servStar1!=null){
                servStar1.setServStar(servStar1.getServStar()+servStar);
                servStarService.updateByPrimaryKey(servStar1);
            }else{
                ServStar servStar2 = new ServStar();
                servStar2.setServId(labelRequest.getId());
                servStar2.setServStar(servStar);
                servStar2.setServManid(servManid);
                servStarService.insertSelective(servStar2);
            }
        }
        return i;
    }

    @Override
    public Integer deleteLabel(Long id) {
        int i = labelMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public int getLabelNums(LabelRequest labelRequest) {

        LabelExample example = new LabelExample();
        LabelExample.Criteria criteria = example.createCriteria();
        String servManid = labelRequest.getServManid();
        if(servManid!=null&&labelRequest.getOpenid()!=null){
//            criteria.andServManidEqualTo(labelRequest.getServManid());
            criteria.andOpenidEqualTo(labelRequest.getOpenid());
            criteria.andServIdEqualTo(labelRequest.getId());//对某个服务最多评价三次，以免恶意评价。
            return labelMapper.countByExample(example);
        }else{
            return 0;
        }
    }
}
