package com.xiayk.api.controller;

import com.xiayk.api.common.RestResult;
import com.xiayk.api.common.request.LimitGoodsParams;
import com.xiayk.api.common.request.LoginParams;
import com.xiayk.api.common.request.NewUserParams;
import com.xiayk.api.common.request.WxLoginParams;
import com.xiayk.api.service.GoodsService;
import com.xiayk.api.service.UserService;
import com.xiayk.api.utils.VerifyCodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName IndexController
 * @Author XiaYk
 * @Date 2019-10-09 13:01
 * @Version 1.0
 */
@RestController
@RequestMapping("/g/")
@Api(tags = "开放接口")
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private GoodsService goodsService;

    @PostMapping("u/login")
    @ApiOperation(value = "登录", tags = "登录")
    public RestResult login(@RequestBody LoginParams params){
        return RestResult.ResultOk(userService.userLogin(params));
    }

    @PostMapping("u/newUser")
    @ApiOperation(value = "创建用户", tags = "创建")
    public RestResult newUser(@RequestBody NewUserParams params, HttpServletRequest request){
        return RestResult.ResultOk(userService.newUser(request, params));
    }

    @PostMapping("u/login/wx")
    @ApiOperation(value = "微信登录", tags = "微信登录")
    public RestResult wxLogin(@RequestBody WxLoginParams params){
        return RestResult.ResultOk(userService.wxLogin(params));
    }

    @ApiOperation(value = "获取商品列表")
    @RequestMapping("goods")
    public RestResult getGoods(@RequestBody LimitGoodsParams params){
        return RestResult.ResultOk(goodsService.getGoods(params));
    }

    @RequestMapping(value = "code")
    public void getCode(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        VerifyCodeUtil verifyCodeUtil = new VerifyCodeUtil();
        verifyCodeUtil.getRandcode(request, response);
    }
}
