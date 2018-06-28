package ua.com.travel.service;

public interface MailSenderService {

	
	void sendMail(String content, String mailBody, String email);
	
}
