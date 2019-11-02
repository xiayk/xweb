package com.xiayk.api.common.po;

public class Goods {

    private Integer id;

    private String goodsId;

    private String goodsName;

    private String goodsPrice;

    private Integer goodsSum;

    private String goodsOther;

    private String goodsCreateDate;

    private String goodsUpdateDate;

    private String goodsIcon;

    private Integer goodsState;

    private Integer goodsShowNav;

    public String getGoodsId() {
        return goodsId;
    }

    public Integer getId() {
        return id;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice == null ? null : goodsPrice.trim();
    }

    public Integer getGoodsSum() {
        return goodsSum;
    }

    public void setGoodsSum(Integer goodsSum) {
        this.goodsSum = goodsSum;
    }

    public String getGoodsOther() {
        return goodsOther;
    }

    public void setGoodsOther(String goodsOther) {
        this.goodsOther = goodsOther == null ? null : goodsOther.trim();
    }

    public String getGoodsCreateDate() {
        return goodsCreateDate;
    }

    public void setGoodsCreateDate(String goodsCreateDate) {
        this.goodsCreateDate = goodsCreateDate == null ? null : goodsCreateDate.trim();
    }

    public String getGoodsUpdateDate() {
        return goodsUpdateDate;
    }

    public void setGoodsUpdateDate(String goodsUpdateDate) {
        this.goodsUpdateDate = goodsUpdateDate == null ? null : goodsUpdateDate.trim();
    }

    public String getGoodsIcon() {
        return goodsIcon;
    }

    public void setGoodsIcon(String goodsIcon) {
        this.goodsIcon = goodsIcon == null ? null : goodsIcon.trim();
    }

    public Integer getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(Integer goodsState) {
        this.goodsState = goodsState;
    }

    public Integer getGoodsShowNav() {
        return goodsShowNav;
    }

    public void setGoodsShowNav(Integer goodsShowNav) {
        this.goodsShowNav = goodsShowNav;
    }
}