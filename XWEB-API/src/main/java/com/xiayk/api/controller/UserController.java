package com.xiayk.api.controller;

import com.xiayk.api.common.RestResult;
import com.xiayk.api.common.request.UpdatePassParams;
import com.xiayk.api.utils.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName UserController
 * @Author XiaYk
 * @Date 2019-10-15 12:22
 * @Version 1.0
 */
@RestController
@Api(value = "用户")
@RequestMapping("/u/")
public class UserController {

    @PostMapping("user/editPass")
    @ApiOperation(value = "修改密码")
    public RestResult editPass(@RequestBody UpdatePassParams params, HttpServletRequest request){
        String token = Utils.getToken(request);
        return RestResult.ResultOk("");
    }
}
