package com.xiayk.api.dao;

import com.xiayk.api.common.po.Wx;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WxMapper {
    int deleteByPrimaryKey(String openId);

    int insert(Wx record);

    int insertSelective(Wx record);

    Wx selectByPrimaryKey(String openId);

    int updateByPrimaryKeySelective(Wx record);

    int updateByPrimaryKey(Wx record);
}