package com.qf.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class sender {

    //队列
    private static final String QUEUE_NAME="simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        //链接服务器
        ConnectionFactory connectionFactory=new ConnectionFactory();
        connectionFactory.setVirtualHost("/hsz");
        connectionFactory.setUsername("hsz");
        connectionFactory.setPassword("123456");
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        //拿到链接
        Connection connection = connectionFactory.newConnection();

        //基于Channel交互，类似于会话
        Channel channel = connection.createChannel();

        //声明一个队列，如果队列不存在，则会创建，如果存在，则不做处理
        channel.queueDeclare(QUEUE_NAME,true,false,false,null);

        //发布消息
        String msg="消息发送成功";

        channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());

        System.out.println("消息发送完毕");




    }
}
