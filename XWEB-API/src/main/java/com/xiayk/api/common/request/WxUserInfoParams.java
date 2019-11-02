package com.xiayk.api.common.request;

import lombok.Data;

/**
 * @ClassName WxUserInfoParams
 * @Author XiaYk
 * @Date 2019-10-18 21:51
 * @Version 1.0
 */
@Data
public class WxUserInfoParams {

    private String iv;

    private String encryptedData;
}
