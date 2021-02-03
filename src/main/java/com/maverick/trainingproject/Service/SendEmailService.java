package com.maverick.trainingproject.Service;

import java.io.IOException;
import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.maverick.trainingproject.Model.SendEmailModel;
import com.maverick.trainingproject.Repository.SendEmailRepository;

@Service
public class SendEmailService {

	
	
	@Autowired
	private JavaMailSender javaMailSender;
	

	public void sendEmail(String userName, String userEmail, ArrayList<SendEmailModel> arr1) throws InterruptedException {
		
		System.out.println("send emial servise");
	    SimpleMailMessage msg = new SimpleMailMessage();
	    msg.setTo("akashpatole43@gmail.com", "preetuagrawal123@gmail.com", 
	    		"nirajkulkarni2609@gmail.com", "ardeshmukh98@gmail.com",
	    		"arkumari@mdsol.com", userEmail);
	
	    msg.setSubject("Pill Reminder Email");
	    
	    String outputMsg = "Hello Sir/Maam, \n\n\t" +userName+" \n\n\t"
				+ "This mail is to remind you about your pills, do have your medince. \n\n"
				+ "Its your Medicine time, following are your pills detail to eat. \n\n\n";
	    int i = 0;
	    for (SendEmailModel sendEmailModel : arr1) {
	    	i++;
			outputMsg = outputMsg + "Sr.no : " +i
					+ "\n Medicine : "+sendEmailModel.getUserMedicine()
					+ "\n For Illiness : "+sendEmailModel.getUserIlliness()
					+ "\n By Doctor : "+sendEmailModel.getUserDoctorDetails()
					+ "\n From Date : "+sendEmailModel.getUserMedicineStartDate()
					+ "\n To Date : "+sendEmailModel.getUserMedicineEndDate()
					+ "\n\n";
		}
	    
	    outputMsg = outputMsg + "\n\n\t\t Thank You....";
	    
	    msg.setText(outputMsg);
	    System.out.println(outputMsg);
	    javaMailSender.send(msg);
	    Thread.sleep(5000);
	
	}
	
	

	
}
	
	




