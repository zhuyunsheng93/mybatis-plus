package com.example.practicecode.rabbitmq.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


/**
 *  *@Description          
 *  *@Author  zhuyunsheng       //作者
 *  *@Date 2021/10/29 17:49      //创建时间
 **/
public class ConnectionUtil {
    public static Connection getRabbitmqConnection() throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.56.10");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("zhuyunsheng");
        connectionFactory.setUsername("zhuyunsheng");
        connectionFactory.setPassword("zhuyunsheng");
        Connection connection = connectionFactory.newConnection();
        return connection;
    }

}
