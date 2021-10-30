package com.example.practicecode.rabbitmq.direct;

import com.example.practicecode.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 *  *@Description          
 *  *@Author  zhuyunsheng       //作者
 *  *@Date 2021/10/30 15:37      //创建时间
 **/
public class Producer {
    private final static String EXCHANGE_NAME = "direct_exchange_name";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getRabbitmqConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        String message = "新增商品， id = 1001";
        channel.basicPublish(EXCHANGE_NAME, "insert", null, message.getBytes());
        channel.close();
        connection.close();
    }
}
