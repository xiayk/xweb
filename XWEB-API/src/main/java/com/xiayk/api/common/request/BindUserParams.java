package com.xiayk.api.common.request;

import lombok.Data;

/**
 * @ClassName BindUserParams
 * @Author XiaYk
 * @Date 2019-10-23 10:30
 * @Version 1.0
 */
@Data
public class BindUserParams {

    private String username;

    private String password;
}
