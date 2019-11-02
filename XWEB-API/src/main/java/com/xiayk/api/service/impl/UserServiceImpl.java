package com.xiayk.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiayk.api.common.XException;
import com.xiayk.api.common.po.User;
import com.xiayk.api.common.po.UserKey;
import com.xiayk.api.common.po.UserWx;
import com.xiayk.api.common.po.Wx;
import com.xiayk.api.common.request.*;
import com.xiayk.api.common.result.VerifyGetCodeResult;
import com.xiayk.api.config.JwtConfig;
import com.xiayk.api.dao.UserMapper;
import com.xiayk.api.dao.UserWxMapper;
import com.xiayk.api.dao.WxMapper;
import com.xiayk.api.service.UserService;
import com.xiayk.api.utils.Utils;
import com.xiayk.api.utils.WxUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName UserServiceImpl
 * @Author XiaYk
 * @Date 2019-10-09 13:53
 * @Version 1.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Autowired
    JwtConfig jwtConfig;

    @Resource
    WxMapper wxMapper;

    @Resource
    private UserWxMapper userWxMapper;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public String userLogin(LoginParams params) {
        User user = userMapper.selectByPrimaryKey(params.getUsername());
        if (user == null){
            throw new XException(4011, "用户名不存在");
        }else {
            if (!user.getPassword().equals(params.getPassword())){
                throw new XException(4013, "密码错误");
            }
        }
        user.setLastLoginDate(Utils.toDate(new Date()));
        userMapper.updateByPrimaryKeySelective(user);
        return jwtConfig.createTokenAccount(params.getUsername());
    }

    @Override
    public String updatePass(UpdatePassParams params, HttpServletRequest request) {
        String username = jwtConfig.getUsernameByToken(jwtConfig.parseToken(request));
        if (!params.getOldPass().equals(userMapper.selectByPrimaryKey(username).getPassword())){
            throw new XException(4013, "密码错误");
        }
        User user = new User();
        user.setPassword(params.getNewPass());
        user.setUsername(username);
        return userMapper.updateByPrimaryKeySelective(user)+"";
    }

    @Override
    public int newUser(HttpServletRequest request, NewUserParams params) {
        User user = userMapper.selectByPrimaryKey(params.getUsername());
        if (user != null){
            throw new XException(4017, "用户名已存在");
        }
        String code;
        try {
            code = redisTemplate.opsForValue().get("phone_code_"+params.getPhone());
            if (code == null){
                throw new XException(40042, "验证码异常");
            }
            if (!code.equals(params.getCode())){
                throw new XException(40041, "验证码错误");
            }
        }catch (Exception e){
            throw new XException(40042, "验证码异常");
        }
        user = new User();
        user.setCreateDate(Utils.toDate(new Date()));
        user.setLastLoginDate(Utils.toDate(new Date()));

        try {
            user.setUsername(params.getUsername());
        }catch (NullPointerException e){
            throw new XException(40075, "用户名不能为空");
        }
        try {
            user.setPassword(params.getPassword());
        }catch (NullPointerException e){
            throw new XException(40076, "密码不能为空");
        }
        user.setUserState(1);
        userMapper.insert(user);
        return 1;
    }

    @Override
    public String wxLogin(WxLoginParams params) {
        JSONObject jsonObject;
        try {
            //获取openid sessionkey
            jsonObject = JSON.parseObject(WxUtils.jscode2session(params.getCode()));
        }catch (Exception e){
            throw new XException(40067, "code 异常");
        }
        Wx wx = new Wx();
        wx.setOpenId(jsonObject.getString("openid"));
        wx.setSessionKey(jsonObject.getString("session_key"));

        //sessionKey存入redis  时间 2小时过期
        redisTemplate.opsForValue().set(wx.getOpenId(), wx.getSessionKey(), 7200, TimeUnit.SECONDS);
        log.info("wx => {}", wx.getOpenId());

        wx.setLastDate(Utils.toDate(new Date()));

        //判断是否存在
        if (wxMapper.selectByPrimaryKey(wx.getOpenId()) == null){
            //添加
            wx.setCreateDate(Utils.toDate(new Date()));
            wxMapper.insert(wx);
        }else {
            //更新sessionkey
            wxMapper.updateByPrimaryKeySelective(wx);
            User user = userWxMapper.selectByPrimaryKey(wx.getOpenId());
            if (user != null){
                return jwtConfig.createTokenAccount(user.getUsername());
            }
        }
        //返回token
        return jwtConfig.createTokenAccount(wx.getOpenId());
    }

    @Override
    public String wxUserInfo(WxUserInfoParams params, HttpServletRequest request) {
        String token = jwtConfig.parseToken(request);
        String openId = jwtConfig.getUsernameByToken(token);
        String sessionKey;
        try {
            sessionKey = redisTemplate.opsForValue().get(openId);
            String json = WxUtils.getUserInfo(params.getEncryptedData(), sessionKey, params.getIv());
            log.info("userInfo: {}",json);
        }catch (Exception e){
            throw new XException(40018, "信息更新失败");
        }
        return null;
    }

    @Override
    public int verifyToken(HttpServletRequest request) {
        String auth = jwtConfig.getTokenType(request);
        if (auth.length() > 15) {
            return 0;
        }
        return 1;
    }

    @Override
    public String getPhoneCode(String phone) {

        return null;
    }

    @Override
    public String bindUser(HttpServletRequest request, BindUserParams params) {
        User user = userMapper.selectByPrimaryKey(params.getUsername());
        if (user == null) {
            throw new XException(40015, "用户名为空");
        }

        if (!user.getPassword().equals(params.getPassword())){
            throw new XException(40016, "密码错误");
        }

        UserWx userWx = new UserWx();
        userWx.setUid(user.getUid());
        userWx.setOpenId("");
        userWxMapper.insert(userWx);
        return null;
    }
}
