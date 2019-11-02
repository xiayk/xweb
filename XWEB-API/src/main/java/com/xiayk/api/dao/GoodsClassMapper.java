package com.xiayk.api.dao;

import com.xiayk.api.common.po.GoodsClass;

public interface GoodsClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsClass record);

    int insertSelective(GoodsClass record);

    GoodsClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsClass record);

    int updateByPrimaryKey(GoodsClass record);
}