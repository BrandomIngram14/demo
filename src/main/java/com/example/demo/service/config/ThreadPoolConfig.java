package com.example.demo.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadPoolConfig {
   @Bean
    public ThreadPoolExecutor threadPoolExecutor(
            @Value("${thread.pool.corePoolSize}") Integer corePoolSize,
            @Value("${thread.pool.maxSize}") Integer maxsize,
            @Value("${thread.pool.keepAliveTime}") Long keepAliveTime,
            @Value("${thread.pool.queueNum}") Integer queueNum
   ){
       ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
               corePoolSize,
               maxsize,
               keepAliveTime,
               TimeUnit.MILLISECONDS,
               new ArrayBlockingQueue<>(queueNum),
               Executors.defaultThreadFactory(),
               new ThreadPoolExecutor.AbortPolicy()
       );
       return  threadPoolExecutor;
   }
}
