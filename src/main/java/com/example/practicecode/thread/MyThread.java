package com.example.practicecode.thread;

/**
 *  *@Description          
 *  *@Author  zhuyunsheng       //作者
 *  *@Date 2021/6/30 0:27      //创建时间
 **/
public class MyThread  extends Thread {
    @Override
    public void run() {
        System.out.println("子线程启动,ID为:" + Thread.currentThread().getId() + ",名字为" + Thread.currentThread().getName());
    }
}
