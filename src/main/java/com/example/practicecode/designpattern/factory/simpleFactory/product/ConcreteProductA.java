package com.example.practicecode.designpattern.factory.simpleFactory.product;

/**
 *  *@Description          
 *  *@Author  zhuyunsheng       //作者
 *  *@Date 2022/1/21 13:59      //创建时间
 **/
public class ConcreteProductA extends Product {
    @Override
    public void methodDiff() {
        System.out.println("ConcreteProductA的具体方法");
    }
}
