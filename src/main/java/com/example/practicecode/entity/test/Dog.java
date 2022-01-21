package com.example.practicecode.entity.test;

import cn.hutool.core.collection.CollectionUtil;

import java.util.*;

/**
 *  *@Description          
 *  *@Author  zhuyunsheng       //作者
 *  *@Date 2021/12/2 10:24      //创建时间
 **/
public class Dog extends Mammal {

    public static <T> List<List<T>> averageAssignByOrder(List<T> source, int limit) {
        if (null == source || source.isEmpty()) {
            return Collections.emptyList();
        }
        List<List<T>> result = new ArrayList<>();
        int listCount = source.size() / limit;
        int remaider = source.size() % limit; // (先计算出余数)
        for (int i = 0; i < limit; i++) {
            System.out.println();
            List<T> value = source.subList(i * listCount, (i + 1) * listCount);
            result.add(value);
        }
        if (remaider != 0) {
            List<T> ts = source.subList(source.size() - remaider, source.size());
            result.add(ts);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        list1.add(8);
        list1.add(9);
        list1.add(10);
        list1.add(11);
        list1.add(12);
        System.out.println(averageAssignByOrder(list1,7));;
        Map<Integer, Integer> param = new HashMap<>();
        for (int i = 0; i < list1.size(); i++) {
            int index = i % list.size();
            System.out.print("第一个"+list.get(index)+"   ");System.out.print(list1.get(i));
            System.out.println("");
        }
    }
}
