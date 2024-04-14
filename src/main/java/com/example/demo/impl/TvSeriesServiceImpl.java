package com.example.demo.impl;

import com.example.demo.dao.StudentMapper;
import com.example.demo.service.TvSeriesService;
import com.example.demo.vo.Student;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

@Slf4j
@Service
public class TvSeriesServiceImpl implements TvSeriesService {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    private static final Integer BATCH_SIZE = 800;

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
        // batchUtils.batchUpdateOrInsert(数据集合, xxxxx.class,
        // (item, mapper实例对象) -> mapper实例对象.insert方法(item));
        List<List<Student>> partition = Lists.partition(list, 500);
        insertBatch(partition,StudentMapper.class,(item,StudentMapper)-> studentMapper.insertStudent((List<Student>) item));
    }
    private <T,U,R> int insertBatch(List<T> partition,Class<U> mapper,BiFunction<T,U,R> function){
        int i = 0;
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        try {

            U mp = sqlSession.getMapper(mapper);
            int size = partition.size();
            for(T t: partition){
                function.apply(t,mp);
                if(i%BATCH_SIZE==0 || i==size){
                    sqlSession.flushStatements();
                }
                i++;
            }
            // 非事务环境下强制commit，事务情况下该commit相当于无效
            sqlSession.commit(!TransactionSynchronizationManager.isSynchronizationActive());

        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }

        return i-1;
    }
}
