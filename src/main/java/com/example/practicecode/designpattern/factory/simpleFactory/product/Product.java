package com.example.practicecode.designpattern.factory.simpleFactory.product;

/**
 *  *@Description          
 *  *@Author  zhuyunsheng       //作者
 *  *@Date 2022/1/21 13:53      //创建时间
 **/
public abstract class Product {
    public void methodSame() {
        System.out.println("公共属性方法");
    }
    public abstract void methodDiff();
}
