package com.example.demo.service;

import org.springframework.util.StopWatch;

import java.util.*;


public class TestLearing {

    public static void main(String[] args) throws Exception {

        // 给你一个0-10^n次方之间的数，3>=n>0,求重复的数有几个
        System.out.println(getRepeatNum(1));
    }
    public static int getRepeatNum(int n){
        int count = 0;
        for(int i= 0;i<Math.pow(10,n);i++){
            if(n==1){
                return 1;
            }
        }
        if(n==1){
            return 1;
        }else if (n==2){
            for(int i= 10; i<=Math.pow(10,n);i++){
                String str = String.valueOf(i);
                char c = str.charAt(0);
                char c1 = str.charAt(1);
                if (c==c1){
                    count++;
                }
            }
            return count*n;
        }   else
            for(int i= 100; i<=Math.pow(10,n);i++){
                String str = String.valueOf(i);
                char c = str.charAt(0);
                char c1 = str.charAt(1);
                char c2 = str.charAt(2);
                if (c==c1&&c1==c2){
                    count++;
                }
            }
        return count*n;
    }


    private static void kuaiPai(int[] arr,int low,int high){
        int i,j,tmp;
        i = low;
        j= high;
        tmp = arr[low];
        while (i < j){
            while(i<j&&arr[high]<tmp){
                j--;
            }
            while(i<j&&arr[low]>tmp){
               i++;
            }
            if (i<j){
                int linshi = arr[i];
                arr[i]=arr[j];
                arr[j] = linshi;
            }
            // 第一轮结束
            arr[low] =arr[i];
            arr[i] = tmp;

        }
        kuaiPai(arr,low,i-1);
        kuaiPai(arr,i+1,high);
    }
    private static void erFen(int[] arr,int num){
        int low = 0;
        int high = arr.length -1;
        while(low < high){
            int mid = (low+high)/2;
            if (arr[mid] > num){
                high--;
            } else if (arr[mid] < num){
                low ++;
            }else{
                break;
            }

        }
    }
    private static boolean isHuiWen(String num){
        int right = num.length()-1;
        int left = 0;
        while(left < right){
            char c = num.charAt(left);
            char d = num.charAt(right);
            if (c != d){
               return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private static int midFind(int[] arr,int low,int high, int num) {

        if (low<=high){
            int mid = low+(high-low)/2;
            if (num == arr[mid]){
                return mid;
            }
            if(num > arr[mid]){
                return midFind(arr,mid+1,high,num);
            }
            if(num < arr[mid]){
                return midFind(arr,low,mid-1,num);
            }
        }




        return -1;
    }

    private static void bubbleSort(int[] arr) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < arr.length-1;i++){
            for(int j = 0; j< arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("第"+(i+1)+"次循环之后，数组的值为："+Arrays.toString(arr));
        }
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }


}


