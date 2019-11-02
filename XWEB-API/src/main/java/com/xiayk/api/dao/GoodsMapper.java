package com.xiayk.api.dao;

import com.xiayk.api.common.po.Goods;
import com.xiayk.api.common.request.LimitGoodsParams;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {
    int deleteByPrimaryKey(Goods key);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByPrimaryKey(LimitGoodsParams params);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    int selectByPrimaryKeyCount(LimitGoodsParams params);
}