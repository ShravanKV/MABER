package com.example.demo.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.emaildao;

@Service
public class PasswordService {
	@Autowired
	emaildao daoimpl;
	public boolean sendEmail(String email)
	{
		
		boolean f = false;
        String host="smtp.gmail.com";
		String from = "shravaniaskhandery@gmail.com";
		String password = daoimpl.getemail(email);
		String message = "Your Password is"+password;
		String subject = "You have your password";
		//get the system properties
		Properties properties = System.getProperties();
		//System.out.println("PROPERTIES "+properties);
		
		//setting important information to properties object
		
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//Step 1: to get the session object..
		Session session=Session.getInstance(properties, new Authenticator() {
		 
		 
			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {				
				return new javax.mail.PasswordAuthentication("shravaniaskhandery@gmail.com", "sandhya12345");
			}
			
			
			
		});
		
		session.setDebug(true);
		
		//Step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);
		
		try {
		
		//from email
		m.setFrom(from);
		
		//adding recipient to message
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		
		//adding subject to message
		m.setSubject(subject);
	    
		
		//attachment..
		
		//file path
		
		
		
		MimeMultipart mimeMultipart = new MimeMultipart();
		//text
		//file
		
		MimeBodyPart textMime = new MimeBodyPart();
		
		
		
		try {
			
			textMime.setText(message);
			
			//File file=new File(path);
			//fileMime.attachFile(file);
			
			
			mimeMultipart.addBodyPart(textMime);
			
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		m.setContent(mimeMultipart);
		
		
		//send 
		
		//Step 3 : send the message using Transport class
		Transport.send(m);
		f=true;
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}


}
