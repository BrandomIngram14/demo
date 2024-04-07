package com.example.demo.service;

public class PrintABC implements Runnable{

    private String ThreadName;
    private Object pre;
    private Object self;

    public PrintABC(String threadName, Object pre, Object self) {
        ThreadName = threadName;
        this.pre = pre;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (pre) {
                synchronized (self) {
                    System.out.print(ThreadName);
                    count--;
                    self.notify();
                }
                try {
                    pre.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
