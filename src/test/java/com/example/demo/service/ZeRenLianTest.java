package com.example.demo.service;

import com.example.demo.vo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.time.LocalDate;
import java.util.List;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ZeRenLian.class)
public class ZeRenLianTest {
    @Mock
    private List<Zhuche> list;

    @InjectMocks
    private Zhuche zhuche;

    @Test
    public void testHandler(){
        Student student = new Student(1,"zhangsan","0",10, LocalDate.now());
//        PowerMockito.doNothing().when(zhuche.registry(student));
        zhuche.registry(student);
    }
}