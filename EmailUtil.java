package com.project.util;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailUtil {

    private static final String FROM_EMAIL =
            "YOUR_EMAIL";

    private static final String APP_PASSWORD =
            "YOUR_APP_PASSWORD";

    public static void sendEmail(
            String to,
            String subject,
            String messageText) {

        try {

            Properties props =
                    new Properties();

            props.put(
                    "mail.smtp.host",
                    "smtp.gmail.com");

            props.put(
                    "mail.smtp.port",
                    "587");

            props.put(
                    "mail.smtp.auth",
                    "true");

            props.put(
                    "mail.smtp.starttls.enable",
                    "true");

            Session session =
                    Session.getInstance(
                            props,

                            new Authenticator() {

                                protected PasswordAuthentication
                                getPasswordAuthentication() {

                                    return new PasswordAuthentication(
                                            FROM_EMAIL,
                                            APP_PASSWORD);
                                }
                            });

            Message message =
                    new MimeMessage(session);

            message.setFrom(
                    new InternetAddress(
                            FROM_EMAIL));

            message.setRecipients(
                    Message.RecipientType.TO,

                    InternetAddress.parse(
                            to));

            message.setSubject(
                    subject);

            message.setText(
                    messageText);

            Transport.send(
                    message);

            System.out.println(
                    "Email Sent Successfully");

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}