package com.example.practicecode.entity.test;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

/**
 *  *@Description          
 *  *@Author  zhuyunsheng       //作者
 *  *@Date 2021/12/2 10:23      //创建时间
 **/
public class Mammal extends RepTitle implements Animal {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setAge(1);
        dog.setName("HAHA");
        Dog dog1 = new Dog();
        dog1.setAge(1);
        dog1.setName("HAHA");
        List<Dog> list = new ArrayList<>();
        list.add(dog);
        list.add(dog1);
        Map<Dog, Dog> map = new HashMap<>();
        map.put(dog, dog);
        map.put(dog1, dog1);
        System.out.println(map);
        System.out.println(map.size());
    }
}
