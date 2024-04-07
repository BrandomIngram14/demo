package com.example.demo.dao;

import com.example.demo.vo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface StudentMapper {

    /**
     * 查找指定范围的记录
     * @param begin 开始位置
     * @param pageSize 开始位置 + pageSize
     * @return 学生集合
     */
    List<Student> findStuPageManual(Integer begin, Integer pageSize);

    /**
     * 查找记录总条数
     * @return 总条数
     */
    Long findCount();
}
