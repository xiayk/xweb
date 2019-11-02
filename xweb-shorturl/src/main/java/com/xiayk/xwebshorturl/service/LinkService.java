package com.xiayk.xwebshorturl.service;

import com.xiayk.xwebshorturl.model.po.Link;

/**
 * @ClassName LinkService
 * @Author XiaYk
 * @Date 2019-11-02 02:42
 * @Version 1.0
 */
public interface LinkService {

    /**
     * 长转短
     * @param longUrl
     * @return
     */
    String longToShort(String longUrl);

    /**
     * 短转长
     * @param code
     * @return
     */
    String shortToLong(String code);
}
