package com.qf.rabbitmqspringboot.simple;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class SimpleSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void send(String msg){
        rabbitTemplate.convertAndSend("","springboot-simpleQ-queue",msg);
        System.out.println("发送成功");
    }
}
