package com.example.demo.service;

import com.example.demo.service.enumType.AuthenticationTypeEnum;
import com.example.demo.vo.UserContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description 用户登陆信息管理
 * @Author john
 * @Date 2024/4/28 20:28
 * @Version 1.0
 */
public class UserLoginMessageManage {
    private static final String COOKIE_KEY = "__userToken";

    /**
     * @description: 查询用户信息
     * @Param: request
     * @Return: com.example.demo.vo.UserContext
     */
    public UserContext getUserContext(HttpServletRequest request){
        String userToken = getUserToken(request, COOKIE_KEY);
        if (!StringUtils.isEmpty(userToken)){
            // 从缓存或者第三方获取用户的信息，没装redis 暂时new一个对象
            UserContext userContext = new UserContext();
            userContext.setUserName("张飞");
            userContext.setUserId("001");
            userContext.setAuthenticationTypeEnum(AuthenticationTypeEnum.VISITOR);
            return userContext;

        }
        return null;
    }

    public void saveUserContext(HttpServletResponse response, String userContext){
        String s = UUID.randomUUID().toString();
        Cookie cookie = new Cookie(COOKIE_KEY,s);
        cookie.setPath("/");
        response.addCookie(cookie);
        // 后续存redis缓存
    }

    private String getUserToken(HttpServletRequest request, String cookieKey) {
        Cookie cookie = Arrays.stream(request.getCookies())
                .filter(a -> StringUtils.equals(a.getName(), cookieKey))
                .collect(Collectors.toList()).get(0);
        if (cookie != null){
            return cookie.getValue();
        }
        return null;
    }
}

