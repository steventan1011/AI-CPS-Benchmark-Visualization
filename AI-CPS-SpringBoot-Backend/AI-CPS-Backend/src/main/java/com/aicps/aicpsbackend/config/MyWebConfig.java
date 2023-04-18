package com.aicps.aicpsbackend.config;

/**
 * @author T-bk
 * @version 1.0
 * @date 2023/4/17 21:31
 */
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * @author jj
 * @date 2020/09/08
 */
@SpringBootConfiguration
public class MyWebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //所有请求都允许跨域，使用这种配置方法就不能在 interceptor 中再配置 header 了
        registry.addMapping("/**")
                .allowCredentials(true)

                //填上允许跨域的 地址:端口
                .allowedOrigins("http://localhost:8081")
                //(上面一行与下面一行二选一)
                //如果需要全部则用*表示
                //.allowedOrigins("*")

                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowedHeaders("*")
                .maxAge(3600);
    }
}
