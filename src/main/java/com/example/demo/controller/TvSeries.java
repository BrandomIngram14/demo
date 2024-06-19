package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.service.TvSeriesService;
import com.example.demo.service.ZeRenLian;
import com.example.demo.service.config.AccessDominion;
import com.example.demo.utils.CookieUtils;
import com.example.demo.vo.People;
import com.example.demo.vo.Student;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/tv")
public class TvSeries {
    @Autowired
    private TvSeriesService tvSeries;

    @Autowired
    private ZeRenLian zeRenLian;

    @RequestMapping("/series")
    @ResponseBody
    List<Student> getTvSeries(){
        return tvSeries.getTvS();
    }

    @RequestMapping("/getPeople")
    @ResponseBody
    List<People> getPeople(){
        List<Student> tvS = tvSeries.getTvS();
        // 今天工作中遇到一个list集合中的对象需要复制到另一个集合中的不同对象，
        // 下面是三种方式：
//        方法一：BeanUtils.copyProperties
//        List<People> collect = tvS.stream().map(a -> {
//            People people = new People();
//            BeanUtils.copyProperties(a, people);
//            return people;
//        }).collect(Collectors.toList());
//        return collect;
        // 方法二：前提是复制生成的对象要有@Builder注解
        List<People> collect = tvS.stream().
                map(a -> People.builder().id(String.valueOf(a.getId())).build()).collect(Collectors.toList());
        return collect;
        // 方法三：普通for循环，new 对象赋值，不介绍∂

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
    @RequestMapping("/getStudent")
    @AccessDominion(methodName = "getZhuCe",methodType = "postman")
    String getZhuCe(){
          zeRenLian.handler(new Student());
          return "Success";
    }

    @RequestMapping("setCookie")
    String setCookie(HttpServletRequest request, HttpServletResponse response){
        String cookie = "hwq";
        String unicode = "UTF-8";
        CookieUtils.getCookies(request,cookie,unicode);
        return "Success";
    }
}
