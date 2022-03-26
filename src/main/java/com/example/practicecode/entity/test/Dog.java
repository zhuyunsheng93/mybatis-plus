package com.example.practicecode.entity.test;

import cn.hutool.core.collection.CollectionUtil;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;

import java.util.*;

/**
 *  *@Description          
 *  *@Author  zhuyunsheng       //作者
 *  *@Date 2021/12/2 10:24      //创建时间
 **/
@Data
public class Dog {
    private String name;
    private Integer age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(name, dog.name) &&
                Objects.equals(age, dog.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
