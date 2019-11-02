package com.xiayk.api.common.request;

import lombok.Data;

/**
 * @ClassName newUserParams
 * @Author XiaYk
 * @Date 2019-10-09 16:51
 * @Version 1.0
 */
@Data
public class NewUserParams {

    private String username;
    private String password;
    private String email;
    private String phone;
    private String code;
}
