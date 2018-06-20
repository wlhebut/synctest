package com.huntech.pvs.service.services;

import com.huntech.pvs.model.services.ServContent;

import java.util.List;

public interface ServContentService {
    List<ServContent> getServContentByServId(ServContent servContent);
}
