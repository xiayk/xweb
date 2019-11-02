package com.xiayk.api.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName UserInfo
 * @Author XiaYk
 * @Date 2019-10-09 13:04
 * @Version 1.0
 */
@Data
@ApiModel(value = "用户信息", parent = UserInfoDTO.class)
public class UserInfoDTO {

    @ApiModelProperty(name = "用户名",value = "用户名")
    private String username;
}
