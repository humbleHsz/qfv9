package com.qf.rabbitmqspringboot.publish;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Recv {

    @RabbitListener(queues = "springboot-simpleQ-queue-1")
    public void process1(String msg){

        System.out.println("监听队列1 ：接收到的信息为"+msg);
    }


    @RabbitListener(queues = "springboot-simpleQ-queue-2")
    public void process2(String msg){

        System.out.println("监听队列2 ：接收到的信息为"+msg);
    }
}
