package com.xiayk.api.filter;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyFilter
 * @Author XiaYk
 * @Date 2019-09-03 00:55
 * @Version 1.0
 */
@Component
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.setCharacterEncoding("UTF-8");
        // 这是要放行通过的域名 如果不限制用一个 * 也可以，就是不安全
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 允许的方法 例如GET POST PUT DELETE，只要放行用过的
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        // 这个对应的是ajax里设置了header，例如存了token 或者 ontentType: "application/json"
        response.setContentType("application/json; charset=utf-8");
        response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
        if(HttpMethod.OPTIONS.matches(request.getMethod())){
            return;
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
