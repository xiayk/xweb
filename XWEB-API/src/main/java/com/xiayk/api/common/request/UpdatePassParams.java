package com.xiayk.api.common.request;

import lombok.Data;

/**
 * @ClassName updatePassParams
 * @Author XiaYk
 * @Date 2019-10-09 17:00
 * @Version 1.0
 */
@Data
public class UpdatePassParams {

    private String oldPass;
    private String newPass;
}
