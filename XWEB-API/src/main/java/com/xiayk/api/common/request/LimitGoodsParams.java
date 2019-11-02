package com.xiayk.api.common.request;

import com.xiayk.api.common.Page;

/**
 * @ClassName LimitGoodsParams
 * @Author XiaYk
 * @Date 2019-10-22 12:58
 * @Version 1.0
 */
public class LimitGoodsParams extends Page {

    private String goodsId;

    private String goodsName;

    private String date1;

    private String date2;

    public String getDate2() {
        return date2;
    }

    public String getDate1() {
        return date1;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
