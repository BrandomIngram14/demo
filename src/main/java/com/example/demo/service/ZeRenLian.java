package com.example.demo.service;

import com.example.demo.vo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ZeRenLian {
    @Autowired
    private List<Zhuche> list;

    public void handler(Student student){
        for(Zhuche zc : list){
            if (!zc.registry(student)){
                break;
            }
        }
    }
}
