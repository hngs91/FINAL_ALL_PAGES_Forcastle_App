package com.example.forcastle_app;

import android.os.AsyncTask;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/*
Code implemented by Eugenia Vuong
 */
public class JavaMailAPI extends AsyncTask<Void, Void, Void> {

    private android.content.Context Context;
    private Session session;
    private String email, message, subject;
    public static final  String EMAIL = "forcastleteam16@gmail.com"; //newly generatred sender's (Forcastle) email
    public static final String PASSWORD = "For/castle@Team16"; //sender's (Forcastle) account password

    public JavaMailAPI(android.content.Context context, String email, String message, String subject) {
        Context = context;
        this.email = email;
        this.message = message;
        this.subject = subject;
    }

    /*
    This method is used to send an email in java from a generated Forcastle email account using Gmail. This email contains the
    summary of the user's selected bus journey route and the total price of the journey.
     */
    @Override
    protected Void doInBackground(Void... voids) {
        //setting up the mail server
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com"); //sending email through gmail
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");

        //pass in the sender's username and password of the email account
        session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL, PASSWORD);
            }
        });

        session.setDebug(true);

        MimeMessage mimeMessage = new MimeMessage(session); //create default MimeMessage
        try {
            mimeMessage.setFrom(new InternetAddress(EMAIL)); //set From: header field to forcastleteam16@gmail.com
            mimeMessage.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(email))); //set To: header field to user's email
            mimeMessage.setSubject(subject); //set Subject: header field
            mimeMessage.setText(message); //set message
            Transport.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return null;
    }
}