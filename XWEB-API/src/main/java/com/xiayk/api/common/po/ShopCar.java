package com.xiayk.api.common.po;

import lombok.Data;

import java.util.List;

/**
 * @ClassName ShopCar 购物车
 * @Author XiaYk
 * @Date 2019-10-21 17:15
 * @Version 1.0
 */
@Data
public class ShopCar {

    private List<GoodsDetailFromShopCar> carsDetail;

    private String carId;

    private String createDate;

    private String username;

    private String amount;
}
