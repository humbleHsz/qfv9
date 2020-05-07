package com.qf.rabbitmq.work;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recv1 {

    private static final String QUEUE_NAME="work";

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


        Channel channel = connection.createChannel();

        Consumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //处理接受得到的回调的信息
                String s = new String(body,"UTF-8");
                System.out.println("Recv1--》接收到的消息为"+s);
            }
        };

        //让消费者去监听队列
        //为true的时候是自动回复，给服务器反馈，说明已经处理完这个消息
        channel.basicConsume(QUEUE_NAME,true,consumer);
        



    }
}
