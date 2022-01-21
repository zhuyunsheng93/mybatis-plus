package com.example.practicecode.designpattern.factory.simpleFactory.product;

/**
 *  *@Description          
 *  *@Author  zhuyunsheng       //作者
 *  *@Date 2022/1/21 14:02      //创建时间
 **/
public class ConcreteProductB extends Product {
    @Override
    public void methodDiff() {
        System.out.println("ConcreteProductB的特有");
    }
}
