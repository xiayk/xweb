package com.xiayk.api.config;

import com.xiayk.api.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @ClassName MyWebAppConfigurer
 * @Author XiaYk
 * @Date 2019-06-24 00:21
 * @Version 1.0
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurationSupport {

    @Bean
    LoginInterceptor interceptor() {
        return new LoginInterceptor();
    }

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(interceptor())
                .excludePathPatterns("/wx/login", "/login", "/g/**")
                .addPathPatterns("/a/**");
    }
}
