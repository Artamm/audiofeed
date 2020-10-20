package com.artamm.audiofeed.service;

import com.artamm.audiofeed.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class MailService {

    private final JavaMailSender javaMailSender;
    private final SubscriberService subscriberService;

    @Autowired
    public MailService(JavaMailSender javaMailSender, SubscriberService subscriberService) {
        this.javaMailSender = javaMailSender;
        this.subscriberService = subscriberService;
    }

    @Async
    public void sendGreeting(Subscriber subscriber){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(subscriber.getEmail());

        msg.setSubject("Hello from Audiofeed");
        msg.setText("Hello! You've subscribed to new music tracks. We'll send you message automatically, once something new appears");

        javaMailSender.send(msg);
    }

    @Async
    public void sendNotification(String musicName, String email){

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);

        msg.setSubject("New music added");
        msg.setText("Hello! You've subscribed to new music tracks. A new track added: "+musicName);

    }
}
