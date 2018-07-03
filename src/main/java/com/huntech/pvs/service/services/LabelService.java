package com.huntech.pvs.service.services;

import com.huntech.pvs.model.services.Label;
import com.huntech.pvs.view.request.LabelRequest;

import java.util.List;

public interface LabelService {

    List<Label> getLabelsByServId(Long servId);

    Integer insertLabel(LabelRequest label);

    Integer deleteLabel(Long id);

    int getLabelNums(LabelRequest labelRequest);

}
