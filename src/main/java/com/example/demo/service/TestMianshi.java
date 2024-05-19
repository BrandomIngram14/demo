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
        long a = 9;
        long sum = 0;
        for (int i = 0; i < 10 ;i++){
            sum+=a;
            a = a * 10 +9;
        }
        System.out.println(sum);

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
