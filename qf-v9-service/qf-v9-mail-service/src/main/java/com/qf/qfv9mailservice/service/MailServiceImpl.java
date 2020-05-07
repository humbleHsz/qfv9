package com.qf.qfv9mailservice.service;

import com.qf.api.mail.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailServiceImpl implements IMailService {

    @Autowired
    private JavaMailSender sender;

    @Value("${mail.address}")
    private String from;

    @Override
    public String sendSimpleMail(String to, String subject, String context) {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(from);
        message.setText(context);
        message.setSubject(subject);
        message.setTo(to);
        sender.send(message);
        return "success!";
    }


}
