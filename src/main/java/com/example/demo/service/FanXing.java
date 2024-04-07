package com.example.demo.service;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FanXing {
    //T 和 ？
    public <T> List<T> fromArrayListToList(T[] t, List<T> list){
        return list;
    }
    public <T extends Fruit> T testTongPeiFu(T t){
        return t;
    }

    public <T> void testFanxing(T t){

    }

    public List<? super Fruit> testFx(List<? super Fruit> list){
        return list;
    }
}
