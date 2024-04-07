package com.example.demo.service;


public class ClassLoaderHwq extends ClassLoader{
    private String basePath;
    private final static String file_end =".class";

    public void setBasePath(){
        this.basePath = basePath;
    }

    public Class<?> loadClass(String name){
        return null;
    }
}
