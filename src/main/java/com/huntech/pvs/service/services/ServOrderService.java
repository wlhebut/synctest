package com.huntech.pvs.service.services;

import com.huntech.pvs.model.services.ServOrder;

import java.util.List;

public interface ServOrderService {
    List<ServOrder> getServOrders(ServOrder servOrder);
    int delServOrder(Long serOrderId);
    int insertServOrder(ServOrder servOrder);
}
