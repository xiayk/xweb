package com.xiayk.api.service.impl;

import com.xiayk.api.common.po.Order;
import com.xiayk.api.common.po.ShopCar;
import com.xiayk.api.dao.OrderMapper;
import com.xiayk.api.service.OrderService;
import com.xiayk.api.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @ClassName OrderServiceImpl
 * @Author XiaYk
 * @Date 2019-10-21 17:21
 * @Version 1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public Order createOrder(String carId) {
        ShopCar car = new ShopCar();

        //创建订单对象
        Order order = new Order();
        //生成订单编号
        order.setOrderId("");

        //订单创建时间
        order.setOrderCreateDate(Utils.toDate(new Date()));

        //订单状态 0.创建
        order.setOrderState(0);

        //订单类型 1.购买
        order.setOrderType(1);

        //订单金额
        order.setOrderAmount(car.getAmount());

        //所属用户
        order.setOrderUser(car.getUsername());
        return null;
    }

    @Override
    public int delOrder(String orderId) {
        return 0;
    }
}
