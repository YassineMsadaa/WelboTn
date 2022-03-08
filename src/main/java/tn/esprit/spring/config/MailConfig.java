package tn.esprit.spring.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import tn.esprit.spring.entities.MyConstants;

@Configuration
public class MailConfig {
	 @Bean
	    public JavaMailSender getJavaMailSender() {
	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        mailSender.setHost("chaima.trabelsi@esprit.tn");
	        mailSender.setPort(587);

	        mailSender.setUsername(MyConstants.MY_EMAIL);
	        mailSender.setPassword(MyConstants.MY_PASSWORD);

	        Properties props = mailSender.getJavaMailProperties();
	        props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.debug", "true");

	        return mailSender;
	    }

	}

