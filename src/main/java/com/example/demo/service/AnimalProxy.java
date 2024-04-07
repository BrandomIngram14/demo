package com.example.demo.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AnimalProxy implements InvocationHandler {
    private Animal target;

    // 生成目标类的代理对象
   public Object getProxy(Animal obj){
        this.target = obj;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), obj.getClass().getInterfaces(),this);
   }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我要打你");
        Object invoke = method.invoke(target, args);
        System.out.println("疼不疼");
        return invoke;
    }
}
