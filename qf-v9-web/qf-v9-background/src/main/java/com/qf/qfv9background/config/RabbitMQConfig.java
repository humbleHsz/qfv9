package com.qf.qfv9background.config;


import constant.RabbitMQConstant;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

//    @Bean
//    public TopicExchange getBackgroundTopicExchange(){
//        return new TopicExchange(RabbitMQConstant.BACKGROUND_EXCHANGE);
//    }

    @Bean
    public TopicExchange getItemTopicExchange(){

        return new TopicExchange(RabbitMQConstant.ITEM_EXCHANGE);
    }






}
