package com.xiayk.api.dao;

import com.xiayk.api.common.po.Order;
import com.xiayk.api.common.request.LimitOrderParams;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Order record);

    List<Order> getOrderByKey(LimitOrderParams params);

    int getOrderByKeyCount(LimitOrderParams params);

}