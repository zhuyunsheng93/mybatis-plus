package com.example.practicecode.controller;

import com.example.practicecode.annotation.TestAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 *  *@Description          
 *  *@Author  zhuyunsheng       //作者
 *  *@Date 2021/6/15 11:05      //创建时间
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
@TestAnnotation
class TestControllerTest {

    @Test
    void test1() {
        Boolean hasAnnotation = TestControllerTest.class.isAnnotationPresent(TestAnnotation.class);
        if(hasAnnotation){
            TestAnnotation testAnnotation = TestControllerTest.class.getAnnotation(TestAnnotation.class);
            System.out.println(testAnnotation.id());
            System.out.println(testAnnotation.msg());
            LocalDateTime dateTime =LocalDateTime.ofEpochSecond(1623738453,0, ZoneOffset.ofHours(8));
            System.out.println("fdsfdf"+dateTime);
        }
    }
}