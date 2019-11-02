package com.xiayk.api.common.po;

import lombok.Data;

/**
 * @ClassName GoodsDetailFromShopCar 购物车内商品详情
 * @Author XiaYk
 * @Date 2019-10-21 17:16
 * @Version 1.0
 */
@Data
public class GoodsDetailFromShopCar {

    private String goodsId;

    private String goodsName;

    private String goodsNum;

    private String goodsOther;

    private String goodsAddDate;

    private String goodsState;
}
