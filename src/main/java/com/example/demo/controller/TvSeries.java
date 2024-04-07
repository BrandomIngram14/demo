package com.example.demo.controller;

import com.example.demo.service.TvSeriesService;
import com.example.demo.vo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
