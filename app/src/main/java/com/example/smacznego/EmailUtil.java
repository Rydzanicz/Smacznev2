package com.example.smacznego;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailUtil extends AppCompatActivity {

    /*public void onCreate(){
        sendActivationEmail();
        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(intent);
    }*/

    //konfiguruje poczty i wysłanie maila
    public static void sendActivationEmail() {
        String mailRecipient="Smacznego12@gmail.com";
        String from = "Smacznego12@gmail.com";
        final String username = "Smacznego12@gmail.com";
        final String password = "Jav@Smaczna!2";

        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", username);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            javax.mail.Message message = new MimeMessage(session);

            //set From email field
            message.setFrom(new InternetAddress(from));

            //set To email field
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailRecipient));

            //set email subject field
            message.setSubject("Potwierdzenie maila");

            //set the content of the email message
            message.setContent("<h2>Smaczne</h2><p>Udało ci się pomyślnie zarejestrować!" + "</p>", "text/html");

            //send the email message
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}