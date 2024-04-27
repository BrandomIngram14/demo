package com.example.demo.service;

import java.sql.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMianshi {
    public static void main(String[] args) {
        //给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
        // 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
        //示例 1：
        //输入：nums = [4,3,2,7,8,2,3,1]
        //输出：[5,6]
        //示例 2：
        //输入：nums = [1,1]
        //输出：[2]
//        int[] arr = {1,2,3,1};
//        int[] anInt = getInt(arr);
//        System.out.println("xxx");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();
        String format2 = dateTimeFormatter.format(now);

        LocalDate localDate = now.minusDays(1);
        String format = dateTimeFormatter.format(localDate);

        System.out.println(format.compareTo(format2));

    }

    private static int[] getInt(int[] arr) {
        int length = arr.length;
        if (length == 0) {
            return null;
        } else {
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i <= arr.length; i++) {
                set.add(i);
            }
            Set<Integer> collect =
                    Arrays.stream(arr).boxed().collect(Collectors.toSet());
            set.removeAll(collect);
            int[] ints = set.stream().mapToInt(Integer::intValue).toArray();
            return ints;
        }
    }
    private static int[] getInts(int[] arr){
        Set<Integer> set = new HashSet<>();
        
        return null;
    }
}
