package com.service;

import com.model.Employee;
import com.service.EmailService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailTrapService implements EmailService {
    @Override
    public void sendEmail(Employee employee) throws MessagingException {
        // Assuming you have a valid SMTP configuration for an EmailTrap service
        String host = "sandbox.smtp.mailtrap.io"; // Replace with your SMTP server
        final String username = "df52686549b330"; // Replace with your username
        final String password = "c473029b662d0c"; // Replace with your password
        int port = 25; // Typically 587 for TLS

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.ssl.protocols", "TLSv1.2"); // Ensure using TLSv1.2 or TLSv1.3
        //props.put("mail.debug", "true");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("mailtrap@demomailtrap.com")); // Replace with your sender address
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(employee.getEmail()));
        message.setSubject("Notification for " + employee.getMonth()+"salary");
        message.setText("Dear " + employee.getName() + ",\n\nThis is a test email.\n\nBest regards,\n My friends");

        Transport.send(message);
    }
    }
