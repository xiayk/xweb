package com.xiayk.api.service;

import com.xiayk.api.common.po.User;
import com.xiayk.api.common.request.*;
import com.xiayk.api.common.result.VerifyGetCodeResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName UserService
 * @Author XiaYk
 * @Date 2019-10-09 13:37
 * @Version 1.0
 */
public interface UserService {

    /**
     * 登录
     * @param params
     * @return
     */
    String userLogin(LoginParams params);

    /**
     * 修改密码
     *
     * @param params
     * @return
     */
    String updatePass(UpdatePassParams params, HttpServletRequest request);

    /**
     * 微信登录
     * @param params
     * @return
     */
    String wxLogin(WxLoginParams params);

    /**
     * 解析获取微信用户信息
     * @param params
     * @param request
     * @return
     */
    String wxUserInfo(WxUserInfoParams params, HttpServletRequest request);

    /**
     * 验证token状态
     * @param request
     * @return
     */
    int verifyToken(HttpServletRequest request);

    String bindUser(HttpServletRequest request, BindUserParams params);

    String getPhoneCode(String phone);

    int newUser(HttpServletRequest request, NewUserParams params);
}
