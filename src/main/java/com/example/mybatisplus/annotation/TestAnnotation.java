package com.example.mybatisplus.annotation;

import java.lang.annotation.*;

/**
 *  *@Description          
 *  *@Author  zhuyunsheng       //作者
 *  *@Date 2021/6/15 10:56      //创建时间
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface TestAnnotation {
    //八种基本类型，接口，类，以及他们的数组。
    public int id() default -1;
    public String msg() default "Hi";
}
