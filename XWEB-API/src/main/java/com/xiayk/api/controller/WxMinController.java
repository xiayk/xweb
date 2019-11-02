package com.xiayk.api.controller;

import com.xiayk.api.common.RestResult;
import com.xiayk.api.common.request.BindUserParams;
import com.xiayk.api.common.request.WxLoginParams;
import com.xiayk.api.common.request.WxUserInfoParams;
import com.xiayk.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName WxMinController
 * @Author XiaYk
 * @Date 2019-10-18 17:34
 * @Version 1.0
 */
@RestController
public class WxMinController {

    @Autowired
    UserService userService;

    @PostMapping("wx/login")
    public RestResult wxLogin(@RequestBody WxLoginParams params){
        return RestResult.ResultOk(userService.wxLogin(params));
    }

    @PostMapping("wx/getInfo")
    public RestResult wxGetInfo(@RequestBody WxUserInfoParams params){
        return RestResult.ResultOk("");
    }

    public RestResult WxBindUser(@RequestBody BindUserParams params, HttpServletRequest request){
        userService.bindUser(request, params);
        return RestResult.ResultOk("");
    }
}
