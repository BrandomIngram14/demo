package com.example.demo;

import com.example.demo.service.Animal;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.proxy.Enhancer;

@SpringBootTest
public class LearningTest {
    @Test
    public void testProxy(){
//        Animal proxy = (Animal) new AnimalProxy().getProxy(x->{
//            return 1;
//        });
//        System.out.println(proxy.toString());

        AnimalInterceptor animalInterceptor = new AnimalInterceptor(new Learntransaction());
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Animal.class);
        enhancer.setCallback(animalInterceptor);
        Animal o = (Animal) enhancer.create();
        o.getSum(1);
        System.out.println(animalInterceptor.toString());
    }
};
