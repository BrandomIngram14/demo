package com.example.demo.impl;

import com.example.demo.dao.StudentMapper;
import com.example.demo.service.TvSeriesService;
import com.example.demo.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TvSeriesServiceImpl implements TvSeriesService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List<Student> getTvS() {
        return studentMapper.findStuPageManual(0, 10);
    }
}
