package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("PageBean")
public class PageBean {

    /**
     * 当前页的内容，学生对象集合
     */
    private List<Student> rows;

    /**
     * 记录总条数
     */
    private long total;
}
