package com.example.demo.impl;

import com.example.demo.dao.StudentMapper;
import com.example.demo.service.TvSeriesService;
import com.example.demo.vo.Student;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TvSeriesServiceImpl implements TvSeriesService {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<Student> getTvS() {
        // 1、获取sqlSessionfactory
        // 2、拿到sqlsession
        // 3、得到mapper
        // 4、执行批处理
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> allStudent = mapper.findAllStudent();
        return allStudent;
    }

    @Override
    public void insertStudent(List<Student> list) {
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        try {
            mapper.insertStudent(list);
            sqlSession.commit();
//            studentMapper.insertStudent(list);
        } catch (Exception e) {
            log.error("写入数据错误:{}",e.getMessage());
            sqlSession.rollback();
        } finally {
            if (sqlSession != null){
                sqlSession.close();
            }
        }
    }
}
