package com.example.practicecode.dao.impl;

import com.example.practicecode.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 *  *@Description          
 *  *@Author  zhuyunsheng       //作者
 *  *@Date 2021/7/12 15:05      //创建时间
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
class UserDaoImplTest {


    @Test
    void rec() throws Exception {

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
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                // body 即消息体
                //int i = 1 / 0;
                String msg = new String(body);
                System.out.println(" [x] received : " + msg + "!");
                //手动确认ack
                 channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        //手动确认的时候将 自动确认给关闭掉
        channel.basicConsume("simple_queue", false, defaultConsumer);

    }
}