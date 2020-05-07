package com.qf.qfv9itemservice.config;


import constant.RabbitMQConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitMQConfig {


    //声明队列
    @Bean
    public Queue getQueue(){
        return new Queue(RabbitMQConstant.ITEM_CREATE_HTML_QUEUE);
    }

    //声明交换机
    @Bean
    public TopicExchange getTopicExchange(){
        return new TopicExchange(RabbitMQConstant.ITEM_EXCHANGE);
    }

    //进行队列和交换机的绑定
    @Bean
    public Binding getBinding(Queue getQueue,TopicExchange getTopicExchange){
        return BindingBuilder.bind(getQueue).to(getTopicExchange).with("html.create");
    }
}
