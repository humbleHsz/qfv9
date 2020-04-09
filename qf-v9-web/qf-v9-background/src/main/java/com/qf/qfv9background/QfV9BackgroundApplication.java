package com.qf.qfv9background;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDubbo
@ComponentScan({"com.qf.api.product","com.qf.qfv9background.controller"})

public class QfV9BackgroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(QfV9BackgroundApplication.class, args);

    }

}
