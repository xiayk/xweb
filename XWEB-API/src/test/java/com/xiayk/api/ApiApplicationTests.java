package com.xiayk.api;

import com.xiayk.api.common.request.WxLoginParams;
import com.xiayk.api.config.JwtConfig;
import com.xiayk.api.dao.WxMapper;
import com.xiayk.api.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiApplicationTests {

    @Autowired
    JwtConfig jwtConfig;

    @Test
    public void contextLoads() {
        System.out.println(jwtConfig.getUsernameByToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqd3QtaWQiOiJlODY4MmVlMS1mY2I5LTRjOGMtYmVmZC1hYTdmODY5ODFmODIiLCJleHAiOjE1NzExMTc3OTYsInVzZXJuYW1lIjoiWGlhWWsifQ.WlBAf4A8D1mlF5AOuBs83j6RC1QRpOrFJvHYYCAE8zI"));
    }


    @Autowired
    UserService userService;

    @Resource
    WxMapper wxMapper;
    @Test
    public void getOpenId(){
        wxMapper.selectByPrimaryKey("1234");
    }

}
