package com.example.C_Vitae.Email;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender{
    private final static Logger logger = LoggerFactory.getLogger(EmailService.class);
    private final JavaMailSender mailSender ;
    @Override
    @Async
    public void Send(String to, String email) {
    try{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,"utf-8");
        helper.setText(email,true);
        helper.setTo(to);
        helper.setSubject("Confirme your email");
        helper.setFrom("vitae@gmail.com");
        mailSender.send(mimeMessage);

    } catch (MessagingException e){
        logger.error("failed to send eamil",e);
        throw new IllegalStateException("failed to send email");
    }
    }
}
