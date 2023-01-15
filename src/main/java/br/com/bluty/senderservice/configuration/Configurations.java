package br.com.bluty.senderservice.configuration;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class Configurations {

    @Bean
    Gson gson() {
        return new Gson();
    }

    @Bean
    public JavaMailSender javaMailSender() {
        var mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername(EnvironmentVariable.EMAIL_USER);
        mailSender.setPassword(EnvironmentVariable.EMAIL_PASS);

        var preperties = mailSender.getJavaMailProperties();
        preperties.put("mail.properties.mail.smtp.ssl.trust", "smtp.gmail.com");
        preperties.put("mail.transpost.protocol", "smtp");
        preperties.put("mail.smtp.starttls.enable", "true");
        preperties.put("mail.smtp.auth", "true");
        preperties.put("mail.tls", "true");

        return mailSender;
    }


}
