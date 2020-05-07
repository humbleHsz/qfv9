package com.qf.qfv9searchservice.config;

import constant.RabbitMQConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.*;

@Configuration
public class RabbitMQConfig {


    //声明队列
    @Bean
    public Queue getQueue(){
        return new Queue(RabbitMQConstant.BACKGROUND_PRODUCT_UPDATE_QUEUE);
    }
    //声明交换机

    @Bean
    public TopicExchange getTopicExchange(){
        return new TopicExchange(RabbitMQConstant.BACKGROUND_EXCHANGE);
    }

    //简历绑定关系
    @Bean
    public Binding getBinding(Queue getQueue,TopicExchange getTopicExchange) {
        return BindingBuilder.bind(getQueue).to(getTopicExchange).with("product.add");
    }


}
