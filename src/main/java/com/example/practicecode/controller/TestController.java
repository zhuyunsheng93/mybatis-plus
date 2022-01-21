package com.example.practicecode.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

/**
 *  *@Description          
 *  *@Author  zhuyunsheng       //作者
 *  *@Date 2021/6/3 13:38      //创建时间
 **/
@RestController
public class TestController {
    @Resource
    private AmqpTemplate amqpTemplate;

    @PostMapping("/test")
    public String test(HttpServletRequest request) {
        InputStream is = null;
        StringBuilder sb = new StringBuilder();
        try {
            is = request.getInputStream();
            sb = new StringBuilder();
            byte[] b = new byte[4096];
            for (int n; (n = is.read(b)) != -1; ) {
                sb.append(new String(b, 0, n));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String name = request.getParameter("test");
        return "test" + sb;
    }

    @RequestMapping("sendMessage")
    public void sendMessage() {
        String message = "hello,Spring boot rabbitmq";
        amqpTemplate.convertAndSend("spring.test.exchange", "computer.test", message);
    }

    @GetMapping("publishMessage")
    public void publish(String exchange, String routing, String data) {
        amqpTemplate.convertAndSend(exchange, routing, data);
    }
}
