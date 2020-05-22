package com.qf.qfv9userservice;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDubbo
@EnableJpaRepositories(basePackages = "com.qf.jpa.repository")
@ComponentScan( basePackages = {"com.qf.api.user","com.qf.qfv9userservice.config"})
@EntityScan("com.qf.v9.entity")
public class QfV9UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(QfV9UserServiceApplication.class, args);
    }

}
