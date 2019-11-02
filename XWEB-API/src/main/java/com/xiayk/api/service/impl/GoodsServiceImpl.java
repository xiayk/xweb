package com.xiayk.api.service.impl;

import com.xiayk.api.common.request.LimitGoodsParams;
import com.xiayk.api.common.result.LimitResult;
import com.xiayk.api.dao.GoodsMapper;
import com.xiayk.api.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * @ClassName GoodsService
 * @Author XiaYk
 * @Date 2019-10-22 13:39
 * @Version 1.0
 */
@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public LimitResult getGoods(LimitGoodsParams params) {
        LimitResult result = new LimitResult();
        //商品名称添加 % 模糊查询
        params.setGoodsName("%"+params.getGoodsName()+"%");
        result.setCount(goodsMapper.selectByPrimaryKeyCount(params));
        result.setData(goodsMapper.selectByPrimaryKey(params));
        return result;
    }
}
