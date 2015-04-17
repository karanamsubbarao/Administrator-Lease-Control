package com.pss.alcs.atlassian.service;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * Created by skaranam on 4/10/2015.
 */
@Service
@Configuration
@PropertySource(value = { "classpath:alcs-service.properties" })
public class EmailService implements IEmailService {

    private static final String SMTP_SERVER_NAME="smtp.server.name";
    private static final String SMTP_SERVER_PORT="smtp.server.port";
    private static final String SMTP_SERVER_USERNAME="smtp.server.username";
    private static final String SMTP_SERVER_PASSWORD="smtp.server.password";

    @Autowired
    private Environment environment;
    private Logger log  = LoggerFactory.getLogger(EmailService.class);

    @Override
    public boolean sendEmail(String from, String subject, String contents, String toAddressList)
    {
        boolean mailSent = true;
        String smtpHostName = environment.getProperty(SMTP_SERVER_NAME);
        int smtpPort = Integer.parseInt(environment.getProperty(SMTP_SERVER_PORT));
        String username = environment.getProperty(SMTP_SERVER_USERNAME);
        String password = environment.getProperty(SMTP_SERVER_PASSWORD);

        Email email = new HtmlEmail();
        email.setHostName(smtpHostName);
        email.setSmtpPort(smtpPort);
        email.setAuthenticator(new DefaultAuthenticator(username, password));
        email.setSSLOnConnect(true);
        try
        {
            email.setFrom(from);
            email.setSubject(subject);
            email.setMsg(contents);
            email.addTo(toAddressList);
            email.send();
        } catch (EmailException ex) {
            mailSent = false;
            log.error("Error in sending the email for Lease request for Administrator access",ex);
        }
        return mailSent;
    }
}
