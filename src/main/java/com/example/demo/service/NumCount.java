package com.example.demo.service;

public class NumCount {
    private int count=0;
    public synchronized  void numIncrement(){
        count++;
    }
    public synchronized void numDel(){
        count--;
    }
    public synchronized int getCounts(){
        return count;
    }
}
