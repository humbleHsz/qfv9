package com.qf.rabbitmqspringboot.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class HszConfig {

    @Bean
    public Queue getQueue(){
        return new Queue("springboot-simpleQ-queue",true,false,false);
    }


    @Bean
    public FanoutExchange getFanoutExchange(){
        return new FanoutExchange("springboot-fanout-exchange");
    }


    @Bean
    public Queue getQueueOne(){
        return new Queue("springboot-simpleQ-queue-1",true,false,false);
    }


    @Bean
    public Queue getQueueTwo(){
        return new Queue("springboot-simpleQ-queue-2",true,false,false);
    }

    @Bean
    public Binding getBindingOne(FanoutExchange fanoutExchange,Queue getQueueOne){
            return BindingBuilder.bind(getQueueOne).to(fanoutExchange);
    }

    @Bean
    public Binding getBindingTwo(FanoutExchange fanoutExchange,Queue getQueueTwo){
        return BindingBuilder.bind(getQueueTwo).to(fanoutExchange);
    }


    @Bean
    public TopicExchange getTopicExchange(){
        return new TopicExchange("springboot-topic-exchange");
    }

    @Bean
    public Binding getBindingTopic(TopicExchange getTopicExchange,Queue getQueueOne){
        return BindingBuilder.bind(getQueueOne).to(getTopicExchange).with("nba.#");
    }


    @Bean
    public TopicExchange getTopicExchangehsz(){
        return new TopicExchange("hsz-TopicExchange");
    }

    @Bean
    public TopicExchange getTopicExchangejsw(){
        return new TopicExchange("jsw-TopicExchange");
    }

}
