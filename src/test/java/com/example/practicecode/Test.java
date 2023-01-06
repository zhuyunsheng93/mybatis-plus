package com.example.practicecode;

import cn.hutool.core.util.NumberUtil;
import com.example.practicecode.entity.User;
import com.example.practicecode.spi.Search;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Test {

    @org.junit.Test
    public void testSelect() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        log.info("根据类名:\t" + User.class);
//        log.info("根据全限定类名:\t" + Class.forName("com.example.practicecode.entity.User"));
//        log.info("根据对象:\t" + new User().getClass());
//        log.info("获取全限定类名:\t" + User.class.getName());
//        log.info("获取类名:\t" + User.class.getSimpleName());
//        log.info("实例化:\t" + User.class.newInstance());
//        log.info("获取类的变量:\t" + User.class.getDeclaredFields());
//        Field[] fieldList = User.class.getDeclaredFields();
//        Method[] methods = User.class.getMethods();
//        for (Field field : fieldList) {
//            System.out.println(field.getName());
//            System.out.println(field.getAnnotations()[0].toString());
//        }
//        for (Method method : methods) {
//            System.out.println(method.getName());
//        }
    ServiceLoader<Search> s = ServiceLoader.load(Search.class);
    Iterator<Search> it = s.iterator();
    while(it.hasNext()){
         Search search = it.next();
         search.search("hello test");
    }}
}

