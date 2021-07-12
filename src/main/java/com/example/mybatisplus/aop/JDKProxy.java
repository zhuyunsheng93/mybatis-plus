package com.example.mybatisplus.aop;

import com.example.mybatisplus.dao.UserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  *@Description          
 *  *@Author  zhuyunsheng       //作者
 *  *@Date 2021/7/12 14:26      //创建时间
 **/
public class JDKProxy implements InvocationHandler {
    //得将被增强的对象传递到我们的代理当中
    private UserDao userDao;//被增强的对象

    public JDKProxy(UserDao userDao) {
        this.userDao = userDao;
    }
    /*
     * 产生UserDao代理的方法
     */
    public UserDao createProxy() {
        UserDao userDaoProxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(),
                userDao.getClass().getInterfaces(), this);
        return userDaoProxy;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //判断方法名是不是save？
        if ("save".equals(method.getName())) {
            //增强save方法，进行一个权限校验
            System.out.println("权限校验~~~~~~~~~~~~~~~");
            return method.invoke(userDao, args);
        }
        return method.invoke(userDao, args);
    }

}
