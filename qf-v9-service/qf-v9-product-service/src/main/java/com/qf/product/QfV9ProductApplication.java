package com.qf.product;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableDubbo
@EnableJpaRepositories(basePackages = "com.qf.jpa.repository")
@ComponentScan(basePackages = "com.qf.api.product")
@EntityScan("com.qf.v9.entity")
public class QfV9ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(QfV9ProductApplication.class, args);
    }

}
