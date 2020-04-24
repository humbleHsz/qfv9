package com.qf.qfv9search;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class QfV9SearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(QfV9SearchApplication.class, args);
    }

}
