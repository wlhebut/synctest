package com.huntech.pvs.service.services.impl;

import com.huntech.pvs.dao.services.LabelMapper;
import com.huntech.pvs.model.services.Label;
import com.huntech.pvs.model.services.LabelExample;
import com.huntech.pvs.service.services.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelMapper labelMapper;
    @Override
    public List<Label> getLabelsByServId(Long servId) {

        LabelExample labelExample = new LabelExample();
        LabelExample.Criteria criteria = labelExample.createCriteria();
        criteria.andServIdEqualTo(servId);
        List<Label> labels = labelMapper.selectByExample(labelExample);
        return labels;
    }

    @Override
    public int insertLabel(Label label) {
        int i = labelMapper.insertSelective(label);
        return i;
    }

    @Override
    public int deleteLabel(Long id) {
        int i = labelMapper.deleteByPrimaryKey(id);
        return i;
    }
}
