package com.xiayk.xwebshorturl.dao;

import com.xiayk.xwebshorturl.model.po.Link;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LinkMapper {
    /**
     * 添加
     * @param record
     * @return
     */
    int insert(Link record);

    /**
     * 查询ById
     * @param id
     * @return
     */
    Link selectByPrimaryKey(Integer id);

    /**
     * 通过长链获取短链
     * @param loginUrl
     * @return
     */
    String findShortUrlByLongUrl(String loginUrl);

    /**
     * 通过短链获取长链
     * @param shortUrl
     * @return
     */
    String findLongUrlByShortUrl(String shortUrl);
}