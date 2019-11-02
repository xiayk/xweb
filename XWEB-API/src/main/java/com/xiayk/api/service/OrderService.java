package com.xiayk.api.service;

import com.xiayk.api.common.po.Order;

public interface OrderService {

    /**
     * 创建订单
     * @param carId
     * @return
     */
    Order createOrder(String carId);

    /**
     * 删除订单
     * @param orderId
     * @return
     */
    int delOrder(String orderId);
}
