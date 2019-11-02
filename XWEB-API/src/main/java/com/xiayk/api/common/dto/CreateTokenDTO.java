package com.xiayk.api.common.dto;

import lombok.Data;

/**
 * @ClassName CreateTokenDTO
 * @Author XiaYk
 * @Date 2019-10-21 22:35
 * @Version 1.0
 */
@Data
public class CreateTokenDTO {

    private String username;

    private String openId;

    private String loginType;
}
