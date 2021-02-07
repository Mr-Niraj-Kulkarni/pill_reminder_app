package com.maverick.trainingproject.Service.MedicalHistory;

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
		
//		System.out.println("send emial servise");
	    SimpleMailMessage msg = new SimpleMailMessage();
	    msg.setTo("akashpatole43@gmail.com", 
	    		"nirajkulkarni2609@gmail.com", "ardeshmukh98@gmail.com",
	    		userEmail);
	
	    msg.setSubject("Pill Reminder Email");
	    
	    String outputMsg = "Hello " +userName+", \n\n\t"
				+ "This mail is to remind you about your following pills: \n\n";
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
	    
	    outputMsg = outputMsg + "Thank You,\nPill Reminder App.";
	    
	    msg.setText(outputMsg);
//	    System.out.println(outputMsg);
	    javaMailSender.send(msg);
	    Thread.sleep(5000);
	
	}
	
	public void sendEmailOnReg(String userName, String userEmail) throws InterruptedException {
			
	//		System.out.println("send emial servise");
		    SimpleMailMessage msg = new SimpleMailMessage();
		    msg.setTo("akashpatole43@gmail.com", 
		    		"nirajkulkarni2609@gmail.com", "ardeshmukh98@gmail.com",
		    		userEmail);
		
		    msg.setSubject("Pill Reminder App");
		    
		    String outputMsg = "Hello " +userName+", \n\n"
					+ "Welcome to the Pill Reminder app.\n"
		    		+ "The App which reminds you of your pills as well as your dependents pills.\n"
					+ "You may forget to take your pills but we won't forget to remind you!\n\n"
		    		+ "Thank You,\nPill Reminder App.";
		   
		    
		    msg.setText(outputMsg);
		    System.out.println(outputMsg);
		    javaMailSender.send(msg);
//		    Thread.sleep(2000);
		
	}
	
	

	
}
	
	




