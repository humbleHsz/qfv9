package com.qf.email;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

@SpringBootTest
class EmailApplicationTests {


    @Autowired
    private MailSender mailSender;

    @Value("${mail.address}")
    private String from;

    @Test
    void contextLoads() {

        SimpleMailMessage message =new SimpleMailMessage();
        message.setFrom(from);
        message.setTo("535142099@qq.com");
        message.setSubject("合作");
        message.setText("关系可以");

        mailSender.send(message);

    }

}
