package com.example.practicecode.designpattern.factory.simpleFactory.product;

import com.example.practicecode.designpattern.factory.simpleFactory.SimpleFactory;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp;

/**
 *  *@Description          
 *  *@Author  zhuyunsheng       //作者
 *  *@Date 2022/1/21 14:07      //创建时间
 **/
public class Client {
    public static void main(String[] args) {
        Product product;
        product = SimpleFactory.getProduct("A");
        product.methodDiff();
    }
}
