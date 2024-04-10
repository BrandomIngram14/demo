package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("Student")
public class Student implements Serializable {

    private  Integer id;
    private String name;
    private  String gender;
    private Integer age;
    private LocalDate createTime;
}
