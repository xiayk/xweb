package com.xiayk.api.common.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xiayk.api.common.po.Goods;

import java.util.List;

/**
 * @ClassName GoodsInfoResult
 * @Author XiaYk
 * @Date 2019-10-22 17:28
 * @Version 1.0
 */
public class GoodsInfoResult extends Goods {

    @JsonProperty("img_urls")
    List<String> imgUrls;

    public List<String> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<String> imgUrls) {
        this.imgUrls = imgUrls;
    }
}
