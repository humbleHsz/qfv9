package com.qf.rabbitmqspringboot.simple;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class simplerecv {

    @RabbitListener(queues = "springboot-simpleQ-queue")
    public void recv(String msg){
        System.out.println("接收到的信息为"+msg);
    }
}
