package com.example.practicecode.designpattern.factory.simpleFactory;

import com.example.practicecode.designpattern.factory.simpleFactory.product.ConcreteProductA;
import com.example.practicecode.designpattern.factory.simpleFactory.product.ConcreteProductB;
import com.example.practicecode.designpattern.factory.simpleFactory.product.Product;

/**
 *  *@Description          
 *  *@Author  zhuyunsheng       //作者
 *  *@Date 2022/1/21 13:47      //创建时间
 **/
public class SimpleFactory {
    public static Product getProduct(String arg) {
        Product product = null;
        if (arg.equalsIgnoreCase("A")) {
            product = new ConcreteProductA();
        } else if (arg.equalsIgnoreCase("B")) {
            product = new ConcreteProductB();
        }
        return product;
    }
}
