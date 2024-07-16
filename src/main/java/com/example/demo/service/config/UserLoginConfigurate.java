package com.example.demo.service.config;

import com.example.demo.service.MethodInterceptor;
import com.example.demo.vo.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description TODO
 * @Author os
 * @Date 2024/4/28 21:19
 * @Version 1.0
 */
@Configuration
public class UserLoginConfigurate implements WebMvcConfigurer {
    public static Logger logger = LogManager.getLogger(UserLoginConfigurate.class);
    private MethodInterceptor methodInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("interceptor");
        // 可以添加多个拦截器，一般只添加一个
        // addPathPatterns("/**") 表示对所有请求都拦截
        // .excludePathPatterns("/base/index") 表示排除对/base/index请求的拦截
        // 多个拦截器可以设置order顺序，值越小，preHandle越先执行，postHandle和afterCompletion越后执行
        // order默认的值是0，如果只添加一个拦截器，可以不显示设置order的值
//       registry.addInterceptor(methodInterceptor).addPathPatterns("/**").excludePathPatterns("/tv/getStudent");

    }
}

