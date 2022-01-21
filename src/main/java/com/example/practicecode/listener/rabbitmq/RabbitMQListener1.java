package com.example.practicecode.listener.rabbitmq;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *  *@Description          
 *  *@Author  zhuyunsheng       //作者
 *  *@Date 2021/11/1 18:07      //创建时间
 **/
@Component
public class RabbitMQListener1 {
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "spring.test.queue1", durable = "true", ignoreDeclarationExceptions = "true"),
            exchange = @Exchange(value = "spring.test.exchange", type = ExchangeTypes.TOPIC, durable = "true"),
            key = "computer.test", ignoreDeclarationExceptions = "true"))
    public void listen(String msg) {
        System.out.println("RabbitMQListener1接收的消息为: " + msg);
    }
}
