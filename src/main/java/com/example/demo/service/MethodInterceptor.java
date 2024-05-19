package com.example.demo.service;

import com.example.demo.service.config.UserAuthenticate;
import com.example.demo.service.enumType.AuthenticationTypeEnum;
import com.example.demo.vo.UserContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.lang.annotation.Annotation;

public class MethodInterceptor implements HandlerInterceptor {
    @Autowired
    private UserLoginMessageManage userLoginMessageManage;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod){
            HandlerMethod methodHandle = (HandlerMethod) handler;
            UserAuthenticate annotation = methodHandle.getMethod().getDeclaringClass().
                    getAnnotation(UserAuthenticate.class);
            if (annotation != null && annotation.permission()){
                UserContext userContext = userLoginMessageManage.getUserContext(request);
                if (!userContext.getAuthenticationTypeEnum().equals(annotation.type())){
                    return false;
                }
            }
        }
        return true;
    }
}
