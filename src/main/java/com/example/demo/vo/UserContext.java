package com.example.demo.vo;

import com.example.demo.service.enumType.AuthenticationTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description 用户请求内容
 * @Author john
 * @Date 2024/4/28 20:41
 * @Version 1.0
 */
@Getter
@Setter
@ToString
public class UserContext {
    private String userName;
    private String userId;
    private AuthenticationTypeEnum authenticationTypeEnum;
}

