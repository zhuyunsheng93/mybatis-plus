package com.example.practicecode.rabbitmq.work;

import com.example.practicecode.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 *  *@Description          
 *  *@Author  zhuyunsheng       //作者
 *  *@Date 2021/10/30 14:35      //创建时间
 **/
public class WorkPatternConsumer1 {
    private final static String QUEUE_NAME = "test_work_queue";

    public static void main(String[] args) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getRabbitmqConnection();
        // 从连接中创建通道，这是完成大部分API的地方。
        Channel channel = connection.createChannel();
        //声明（创建）队列，必须声明队列才能够发送消息，我们可以把消息发送到队列中。
        // 声明一个队列是幂等的 - 只有当它不存在时才会被创建
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.basicQos(1);
        //消息内容
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                // body 即消息体
                String msg = new String(body);
                System.out.println(" [x] received : " + msg + "!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //手动确认ack
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        //手动确认的时候将 自动确认给关闭掉
        channel.basicConsume(QUEUE_NAME, false, defaultConsumer);
    }
}
