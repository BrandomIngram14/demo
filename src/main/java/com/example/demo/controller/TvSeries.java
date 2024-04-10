package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.service.TvSeriesService;
import com.example.demo.vo.Student;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tv")
public class TvSeries {
    @Autowired
    private TvSeriesService tvSeries;

    @RequestMapping("/series")
    @ResponseBody
    List<Student> getTvSeries(){
        return tvSeries.getTvS();
    }

    @PostMapping("/insertSeries")
    String insertTvSeries(@RequestBody List<Student> list){
        log.info("接受的请求参数是：{}", JSON.toJSONString(list));
        try {
            tvSeries.insertStudent(list);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "SUCCESS";
    }
}
