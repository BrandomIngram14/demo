package com.example.demo.utils;

import com.example.demo.vo.Apple;
import com.example.demo.vo.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author os
 * @Date 2024/7/3 21:56
 * @Version 1.0
 */
@Configuration
public class TestConfiguration {
    @Bean (name="redApple")
    public Apple getApple11(){
        Apple apple = new Apple(10);
        return apple;
    }

    @Bean(name = "testmap")
    public Map getMap11(){
        Map<String, Student> map = new HashMap<>();
        return map;
    }
}

