package com.crud.tasks.service;


import com.crud.tasks.domain.Mail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class SimpleEmailService {
    private final JavaMailSender mailSender;

    public void send(Mail mail) {
        log.info("Starting email preparation....");
       try {
           SimpleMailMessage message = createMailMessege(mail);
           mailSender.send(message);
           log.info("Email has been sent.");
       }catch (MailException e) {
            log.error("Failed to process email sending: " + e.getMessage());
       }
    }
    private SimpleMailMessage createMailMessege(final Mail mail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        Optional<String> optMailCc = Optional.ofNullable(mail.getMailToCc());
        if (optMailCc.isPresent()) {
            mailMessage.setCc(mail.getMailToCc());
        }
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        return mailMessage;
    }
}
