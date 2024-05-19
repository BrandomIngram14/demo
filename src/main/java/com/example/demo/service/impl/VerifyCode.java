package com.example.demo.service.impl;

import com.example.demo.service.Zhuche;
import com.example.demo.vo.Student;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Order(2)
@Service
@Slf4j
public class VerifyCode implements Zhuche {
    @Override
    public boolean registry(Student student) {
        if (student.getId()==null){
            return false;
        }
        log.info("验证码校验成功");
        return true;
    }
}
