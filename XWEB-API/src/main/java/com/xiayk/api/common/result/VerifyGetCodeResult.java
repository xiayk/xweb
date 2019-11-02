package com.xiayk.api.common.result;

import lombok.Data;

/**
 * @ClassName VerifyGetCodeResult
 * @Author XiaYk
 * @Date 2019-10-22 19:33
 * @Version 1.0
 */
@Data
public class VerifyGetCodeResult {

    private String hashCode;

    private String codeImgUrl;
}
