package com.example.demo.service.impl;

import com.example.demo.service.Zhuche;
import com.example.demo.vo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Order(2)
@Service
@Slf4j
public class SendMessage implements Zhuche {
    @Override
    public boolean registry(Student student) {
        if (student == null){
            return false;
        }
        log.info("发送短信成功");
        return true;
    }
}
