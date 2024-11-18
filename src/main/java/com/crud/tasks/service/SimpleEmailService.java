package com.crud.tasks.service;


import com.crud.tasks.domain.Mail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@Slf4j
@RequiredArgsConstructor
@Service
public class SimpleEmailService {
    private final JavaMailSender mailSender;
    @Autowired
    private MailCreatorService mailCreatorService;

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

    private MimeMessagePreparator createMimeMessage(final Mail mail) {
        return mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setTo(mail.getMailTo());
            messageHelper.setSubject(mail.getSubject());
            messageHelper.setText(mailCreatorService.buildTrelloCardEmail(mail.getMessage()));
        };
    }



    private SimpleMailMessage createMailMessege(final Mail mail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        ofNullable(mail.getMailToCc()).ifPresent(mailToCc -> mailMessage.setTo(mailToCc));
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        return mailMessage;
    }
}
