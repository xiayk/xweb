package com.xiayk.api.dao;

import com.xiayk.api.common.po.GClass;

public interface GClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GClass record);

    int insertSelective(GClass record);

    GClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GClass record);

    int updateByPrimaryKey(GClass record);
}