package com.example.demo.service.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessDominion {
     String methodName() default "com.example.demo.xxx" ;
     String methodType() default "2024-04-27 21:13:50";
}
