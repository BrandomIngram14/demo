package com.example.demo.service.util;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;
import java.text.SimpleDateFormat;


public class DateTypeHandler implements TypeHandler<Date> {


    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        preparedStatement.setDate(i, date);
    }

    @Override
    public Date getResult(ResultSet resultSet, String s) throws SQLException {
        return resultSet.getDate(s);
    }

    @Override
    public Date getResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getDate(i);
    }

    @Override
    public Date getResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getDate(i);
    }
}
