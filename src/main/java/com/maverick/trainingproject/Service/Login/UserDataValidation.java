package com.maverick.trainingproject.Service.Login;

import java.sql.Date;
import java.sql.Time;
import java.util.regex.Pattern;

import com.maverick.trainingproject.Model.DependentMedicalHistoryModel;
import com.maverick.trainingproject.Model.MedicalHistoryModel;
import com.maverick.trainingproject.Model.UserRegistrationInformationModel;

public class UserDataValidation {
	
	
	//checks Strings are not empty 
	public boolean isBlank(String str) {
		System.out.println("is blank");
		if(str.length()>0)
			return false;
		
		return true ;
	}
		
	
	//check Contact Number validity
	public boolean isValidContact(String contact) {
		System.out.println("valid contact");
		String digitRegex = "[0-9]+" ;
		Pattern pat = Pattern.compile(digitRegex); 
		if(contact.length()==10 && (pat.matcher(contact).matches())) {
			return true; 
		}
		return false; 
		
		
	}
	
	//check the email validity 
	public boolean isValidEmail(String email) {
		System.out.println("is valid email");
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$"; 
                  
		Pattern pat = Pattern.compile(emailRegex); 
		if (email.length()==0) 	
			return false; 
		return pat.matcher(email).matches();
	}
	
	//check the password validity 
	public boolean isValidPassword(String password) {
		System.out.println("is valid password");
		Pattern textPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");
		if(password.length()>=8) {
			
			return textPattern.matcher(password).matches();
		}
		
		return false  ;
	}
	
	//check the date validity 
	public boolean isValidDate() {
		
		// find the validity code for checking the correct date of birth of the User 
		return false ;
	}
	
	
	public boolean validateUserRegistrationData(UserRegistrationInformationModel userObj) {
		if(isBlank(userObj.getUserName()))
			return false;
		
		if(isBlank(userObj.getUserCountry()))
			return false ;
		
		if(isBlank(userObj.getSecretQuestion()))
			return false;
		if(isBlank(userObj.getSecretAnswer()))
			return false;
		
		
		if(!isBlank(userObj.getUserEmail())) {
			if(isValidEmail(userObj.getUserEmail())) {
				
			}
			else {
				return false ;
			}
		}
		if(!isBlank(userObj.getUserContact())) {
			if(isValidContact(userObj.getUserContact())) {
				
			}
			else {
				return false ;
			}
		}
		
		if(!isBlank(userObj.getUserPassword())) {
			if(isValidPassword(userObj.getUserPassword())) {
				
			}
			else {
				return false ;
			}
		}
		
		return true ;
	}
public boolean validateUserMedicalHistory(MedicalHistoryModel userObj) {
		
		if(isBlank(userObj.getIlliness()))
			return false ;
		if(isBlank(userObj.getDoctorDetails()))
			return false ;
		if(isBlank(userObj.getMedicine()))
			return false ;
		if(userObj.getDosageAmount()==0)
			return false ;
		if(isBlank(userObj.getDosageFrequency()))
			return false ;
		else {
			if(!userObj.getDosageFrequency().equals("once")&&!userObj.getDosageFrequency().equals("twice")&&userObj.getDosageFrequency().equals("thrice"))
				return false ;
		}
		if(userObj.getEmailNotification()!=0 && userObj.getEmailNotification()!=1) {
			return false; 
		}
		return true ;
		
	}
	
	
	public boolean validateDependentMedicalHistory(DependentMedicalHistoryModel dependentObj) {
		if(isBlank(dependentObj.getDependentRelation())) {
			System.out.println("relation");
			return false ;
		}	
		else {
			if(dependentObj.getDependentRelation().equals("Father") ||dependentObj.getDependentRelation().equals("Mother")||
			  dependentObj.getDependentRelation().equals("FatherinLaw")||dependentObj.getDependentRelation().equals("MotherInLaw")||
			  dependentObj.getDependentRelation().equals("Spouse")||dependentObj.getDependentRelation().equals("Children")) {
				System.out.println("inside1");
				
			}else {
				System.out.println("here");
				return false ;
			}
			
		}
		if(isBlank(dependentObj.getDependentName())) {
			System.out.println("name");
			return false ;
			
		}	
		
		if(isBlank(dependentObj.getIlliness())) {
			System.out.println("ill");
			return false ;
		}	
		if(isBlank(dependentObj.getDoctorDetails())) {
			System.out.println("doc");
			return false ;
		}	
		if(isBlank(dependentObj.getMedicine())) {
			System.out.println("med");
			return false ;
		}	
		if(dependentObj.getDosageAmount()==0) {
			System.out.println("yes amount incorrect ");
			return false ;
		}	
		if(isBlank(dependentObj.getDosageFrequency())) {
			System.out.println("freq");
			return false ;
		}else {
			if(!dependentObj.getDosageFrequency().equals("once")&&!dependentObj.getDosageFrequency().equals("twice")&&dependentObj.getDosageFrequency().equals("thrice")) {
				System.out.println("ur wrong");
				return false ;
			}	
		}
		if(dependentObj.getEmailNotification()!=0 && dependentObj.getEmailNotification()!=1) {
			System.out.println("notification" );
			return false; 
		}
		return true ;
		
	}
	
	
	
	
	
	public boolean validateUpdateMedicalHistoryData(int medicalHistoryId,Date medicineStartDate,Date medicineEndDate,int dosageAmount,String dosageFrequency,
															Time doageBreakfastTime,Time doageLunchTime,Time doageDinnerTime,int emailNotification) {
		if(medicalHistoryId==0 ) {
			System.out.println("id");
			return false;
		}	
				
		if(dosageAmount==0) {
			System.out.println("amt");
			return false ;
		}	
		if(isBlank(dosageFrequency)) {
			System.out.println("freq");
			return false ;
		}	
		else {
			if(!dosageFrequency.equals("once")&&!dosageFrequency.equals("twice")&& !dosageFrequency.equals("thrice")) {
				System.out.println("err");
				return false ;
			}	
		}
		if(medicineStartDate!=null && medicineEndDate!=null) {
			if(medicineStartDate.after(medicineEndDate)) {
				return false ;
			}
		}
		if(emailNotification!=0 &&emailNotification!=1) {
			System.out.println("notification" );
			return false; 
		}
		
		return true ;
	}
	
	
	
	
	
	
	
	
	

}
