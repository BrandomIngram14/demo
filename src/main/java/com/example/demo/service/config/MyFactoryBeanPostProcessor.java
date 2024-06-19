package com.example.demo.service.config;

import com.example.demo.service.MethodInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
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
public class MyFactoryBeanPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition threadPoolExecutor = beanFactory.getBeanDefinition("threadPoolExecutor");
        String beanClassName = threadPoolExecutor.getBeanClassName();
        System.out.println("xxxx"+beanClassName);
    }
}

