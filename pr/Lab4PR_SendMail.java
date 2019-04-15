package ua.pr;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Lab4PR_SendMail {

    public static void main(String[] args)
    {
        // change below lines accordingly 
        String to = "stanislav-fridman@rambler.ru";
        String from = "stasfree155@gmail.com";
        String host = "smtp.gmail.com"; // or IP address
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.from", from);
        properties.setProperty("mail.smtp.user", from);
        properties.setProperty("mail.smtp.password", PasswordManager.gmailPassword);
        properties.setProperty("mail.smtp.port","587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getDefaultInstance(properties,
                new Authenticator() {
                    protected PasswordAuthentication  getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                from, PasswordManager.gmailPassword);
                    }
                });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            message.setSubject("This is LAB 4. Please approve it");
            message.setText("Kindly ask you to put me good mark. Pleeaase :) ");
            Transport.send(message);
            System.out.println("Yo it has been sent..");
        }
        catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
} 