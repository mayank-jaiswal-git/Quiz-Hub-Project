package in.QuizHub.Services.Impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
    
    public String emailbody(int validOTP) {
    	String body = "Dear User,\r\n" + "\r\n"
				+ "We received a request to reset your password for your QuizHub account. Use the One-Time Password (OTP) below to proceed:\r\n"
				+ "\r\n" + "🔢 Your OTP: " + validOTP + "\r\n" + "\r\n"
				+ "This OTP is valid for the next 3 minutes. Please do not share it with anyone for security reasons.\r\n"
				+ "\r\n"
				+ "If you did not request this, please ignore this email, and your account will remain secure.\r\n"
				+ "\r\n" + "For any assistance, feel free to contact our support team.\r\n" + "\r\n"
				+ "Best regards,\r\n" + "QuizHub Team\r\n" + "quizhub96.info@gmail.com";
    	return body;
    }
    
    public String emailSubject() {
    	String subject = "QuizHub - Your OTP to Reset Your Password";
    	return subject;
    }
    
    public int getOTP() {
    	Random random = new Random();
		int OTP = random.nextInt(1000, 9999);
		return OTP;
    }
}
