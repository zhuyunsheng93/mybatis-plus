package com.example.practicecode.rabbitmq.direct;

import com.example.practicecode.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 *  *@Description          
 *  *@Author  zhuyunsheng       //作者
 *  *@Date 2021/10/30 15:48      //创建时间
 **/
public class Consumer {
    private final static String EXCHANGE_NAME = "direct_exchange_name";
    private final static String QUEUE_NAME = "direct_exchange_queue_0";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getRabbitmqConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "insert");
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "delete");
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "update");
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body);
                System.out.println("消费者得到消息" + message);
                channel.basicAck(envelope.getDeliveryTag(), true);
            }
        };
        channel.basicConsume(QUEUE_NAME, false, consumer);
    }
}
