package com.xiayk.api.config;

import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName SwaggerConfig
 * @Author XiaYk
 * @Date 2019-10-09 14:07
 * @Version 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig{

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xiayk.api.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        //Contact contact=new Contact("作者名",
                //"http://www.jianshu.com/u/f192766abeab","email地址");
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2")
                .description("Hello Swagger2")
                //.termsOfServiceUrl("http://www.jianshu.com/u/f192766abeab")
                .contact("作者名")
                //.contact(contact)
                .version("1.0")
                .build();
    }
}