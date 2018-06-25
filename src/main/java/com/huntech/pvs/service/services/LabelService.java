package com.huntech.pvs.service.services;

import com.huntech.pvs.model.services.Label;

import java.util.List;

public interface LabelService {

    List<Label> getLabelsByServId(Long servId);

    int insertLabel(Label label);

    int deleteLabel(Long id);

}
