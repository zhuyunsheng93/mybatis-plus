package com.example.practicecode.controller;

import com.example.practicecode.annotation.TestAnnotation;
import com.example.practicecode.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
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
    void test() throws Exception {
    }

    public static void main(String[] args) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getRabbitmqConnection();
        // 从连接中创建通道，这是完成大部分API的地方。
        Channel channel = connection.createChannel();
        //声明（创建）队列，必须声明队列才能够发送消息，我们可以把消息发送到队列中。
        // 声明一个队列是幂等的 - 只有当它不存在时才会被创建
        channel.queueDeclare("simple_queue", false, false, false, null);
        //消息内容

        for (int i = 0; i < 100; i++) {
            String message = "Hello world" +" "+ i;
            channel.basicPublish("", "simple_queue", null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'" + i);
            Thread.sleep(1000);
        }

        channel.close();
        connection.close();
    }
}