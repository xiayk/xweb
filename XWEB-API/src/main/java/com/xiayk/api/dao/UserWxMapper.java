package com.xiayk.api.dao;

import com.xiayk.api.common.po.User;
import com.xiayk.api.common.po.UserWx;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserWxMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserWx record);

    int insertSelective(UserWx record);

    User selectByPrimaryKey(String openId);

    int updateByPrimaryKeySelective(UserWx record);

    int updateByPrimaryKey(UserWx record);
}