package com.xiayk.api.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.xiayk.api.common.RestResult;
import com.xiayk.api.config.JwtConfig;
import com.xiayk.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 拦截器  token
 * @ClassName LoginInterceptor
 * @Author XiaYk
 * @Date 2019-06-23 22:06
 * @Version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private UserService userService;

    private String notloginRes = JSONObject.toJSONString(new RestResult(false, 401, "", "未登录"));
    private String errRes = JSONObject.toJSONString(new RestResult(false, 401, "", "登录过期, 请重新登录"));
    private String notRole = JSONObject.toJSONString(new RestResult(false, 403, "", "NOT ROLE"));
    private String Ys = JSONObject.toJSONString(new RestResult(false, -3, "", "该程序仅供演示使用"));
    private String notBindUser = JSONObject.toJSONString(new RestResult(false, 409, "", "请绑定账户后操作"));

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取访问接口
        String path = request.getServletPath();

        //获取token
        String token = jwtConfig.parseToken(request);

        if (token == null){
            PrintWriter out = response.getWriter();
            out.append(notloginRes);
            return false;
        }

        //验证token
        if (jwtConfig.verifyToken(token)){
            if (jwtConfig.getTokenType(request) == null && path.indexOf("/bind") >= 0){
                PrintWriter out = response.getWriter();
                out.println(notBindUser);
                return false;
            }
            return true;
        }else {
            logger.info("token 过期");
            PrintWriter out = response.getWriter();
            out.println(errRes);
            return false;
        }
    }

    /**
     * // 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
