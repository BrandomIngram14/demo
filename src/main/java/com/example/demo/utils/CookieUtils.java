package com.example.demo.utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Description TODO
 * @Author os
 * @Date 2024/6/11 20:46
 * @Version 1.0
 */
public class CookieUtils {
    public static String getCookies(HttpServletRequest httpServletRequest,String cookieName, String unicode){
        Cookie[] cookies = httpServletRequest.getCookies();
        for (Cookie cookie : cookies){
            if(cookie.getName().equals(cookieName)){
                return cookie.getName();
            }
        }
        return "xxx";
    }
    public static final void setCookie(HttpServletRequest request, HttpServletResponse response,String cookieName,
                                       String cookieValue,int cookieMaxAge,Boolean encoding) throws UnsupportedEncodingException {
        if (StringUtils.isBlank(cookieName)){
            cookieName = "hwq";
        }
        if (StringUtils.isBlank(cookieValue)){
            cookieValue = "test";
        }
        if (encoding){
            URLEncoder.encode(cookieValue,"utf-8");
        }
        Cookie cookie = new Cookie(cookieName, cookieValue);
        if (cookieMaxAge > 0){
            cookie.setMaxAge(cookieMaxAge);
        }
        if (request != null){
            getDomainName(request);
        }
        // 根路径下的任意地址都有效
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    private static String getDomainName(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        if (StringUtils.isBlank(requestURI)){
            return "";
        }
        String uri = requestURI.toLowerCase();
        String subUri = "";
        if (uri.startsWith("http://")){
            subUri = uri.substring(7);
        } else if (uri.startsWith("https://")) {
            subUri=uri.substring(8);
        }
        String subUriLast = subUri.substring(0, subUri.indexOf("/"));

        return "";
    }
}

