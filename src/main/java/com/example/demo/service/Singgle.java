package com.example.demo.service;

public class Singgle {
    private static volatile Singgle singgle;

    private Singgle(){

    }

    public static Singgle getSinggle(){
        if(singgle==null){
            synchronized (Singgle.class){
                if(singgle==null){
                    singgle=new Singgle();
                }
            }
        }
        return singgle;
    }
}
