package com.aicps.aicpsbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author T-bk
 * @version 1.0
 * @date 2023/1/19 19:50
 */
@Configuration //配置类
@EnableSwagger2// 开启Swagger2的自动配置
//http://localhost:8080/swagger-ui.html#/
//http://localhost:8080/docs.html
public class SwaggerConfig {
    //配置了Swagger 的Docket的bean实例
    @Bean
    public Docket docket(Environment environment) {
        // 设置要显示swagger的环境
        Profiles of = Profiles.of("dev", "test");
        // 判断当前是否处于该环境
        // 通过 enable() 接收此参数判断是否要显示
        boolean b = environment.acceptsProfiles(of);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(b)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.aicps.aicpsbackend.controller"))
                .build();
    }


    //配置Swagger信息=apiInfo
    public ApiInfo apiInfo() {
        //作者信息
        Contact contact = new Contact("Binkai", "", "binkai@ualberta.ca");
        return new ApiInfo("AI-CPS Backend API Document",
                "-",
                "v1.0",
                "urn:tos",
                contact, "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
