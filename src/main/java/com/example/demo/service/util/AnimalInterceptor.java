package com.example.demo.service.util;

import com.example.demo.service.Animal;
import com.example.demo.service.Learntransaction;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


public class AnimalInterceptor implements MethodInterceptor {
    private Learntransaction learntransaction;

    public AnimalInterceptor(Learntransaction learntransaction) {
        this.learntransaction = learntransaction;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        learntransaction.before();
        Object invoke = proxy.invoke(obj, args);
        learntransaction.after();
        return invoke;
    }
}
