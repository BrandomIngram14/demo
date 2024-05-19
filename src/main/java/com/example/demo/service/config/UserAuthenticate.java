package com.example.demo.service.config;

import com.example.demo.service.enumType.AuthenticationTypeEnum;
import jakarta.annotation.Resource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserAuthenticate {

    /**
     * @description: 权限校验
     * @Param:
     * @Return: boolean
     */
    boolean permission() default false;

    AuthenticationTypeEnum type() default AuthenticationTypeEnum.VISITOR;
}
