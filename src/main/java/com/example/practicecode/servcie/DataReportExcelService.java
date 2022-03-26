package com.example.practicecode.servcie;

import com.example.practicecode.model.WellCondition;

import javax.servlet.http.HttpServletResponse;

/**
 *  *@Description          
 *  *@Author  zhuyunsheng       //作者
 *  *@Date 2021/7/17 14:06      //创建时间
 **/
public interface DataReportExcelService {
    void excel(HttpServletResponse response, WellCondition wellCondition) throws Exception;
    public static void testA(){

    }
    public void test();
    default void testDefault(){

    };
    // 从语法形式上看:成员变量是属于类的，⽽局部变量是在⽅法中定义的变量或是⽅法的参数；
    //成员变量可以被 public , private , static 等修饰符所修饰，⽽局部变量不能被访问控制修饰
    //符及 static 所修饰；但是，成员变量和局部变量都能被 final 所修饰。
    //2. 从变量在内存中的存储⽅式来看:如果成员变量是使⽤ static 修饰的，那么这个成员变量是属
    //于类的，如果没有使⽤ static 修饰，这个成员变量是属于实例的。对象存于堆内存，如果局
    //部变量类型为基本数据类型，那么存储在栈内存，如果为引⽤数据类型，那存放的是指向堆
    //内存对象的引⽤或者是指向常量池中的地址。
    //3. 从变量在内存中的⽣存时间上看:成员变量是对象的⼀部分，它随着对象的创建⽽存在，⽽局
    //部变量随着⽅法的调⽤⽽⾃动消失。
    //4. 成员变量如果没有被赋初值:则会⾃动以类型的默认值⽽赋值（⼀种情况例外:被 final 修饰
    //的成员变量也必须显式地赋值），⽽局部变量则不会⾃动赋值。
}
