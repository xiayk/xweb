package com.xiayk.api.service;

import com.xiayk.api.common.request.LimitGoodsParams;
import com.xiayk.api.common.result.LimitResult;

import java.util.List;

/**
 * @ClassName GoodsService
 * @Author XiaYk
 * @Date 2019-10-22 13:35
 * @Version 1.0
 */
public interface GoodsService {

    /**
     * 获取商品
     * @param params 查询参数
     * @return 商品集合,总数
     */
    LimitResult getGoods(LimitGoodsParams params);


}
