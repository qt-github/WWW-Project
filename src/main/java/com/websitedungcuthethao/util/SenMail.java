package com.websitedungcuthethao.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
@Component
public class SenMail {
	@Autowired
	MailSender mailSender;
	
	public void SenEmail(String to, String subjcet,String mess) {
		SimpleMailMessage mailMessage= new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setSubject(subjcet);
		mailMessage.setText(mess);
		mailSender.send(mailMessage);
	}

}
