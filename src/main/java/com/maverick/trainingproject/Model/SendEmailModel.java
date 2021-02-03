package com.maverick.trainingproject.Model;

public class SendEmailModel {

	private int userId;
	private String userName;
	private String userEmail;
	
	public SendEmailModel(int userId, String userName, String userEmail) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	 private String userIlliness; 
	 private String userMedicine;
	 private String userDoctorDetails;
	 private String userMedicineStartDate; 
	 private String userMedicineEndDate;

	public SendEmailModel(int userId, String userName, String userEmail, String userIlliness, String userMedicine, String userDoctorDetails,
			String userMedicineStartDate, String userMedicineEndDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userIlliness = userIlliness;
		this.userMedicine = userMedicine;
		this.userDoctorDetails = userDoctorDetails;
		this.userMedicineStartDate = userMedicineStartDate;
		this.userMedicineEndDate = userMedicineEndDate;
	}

	public String getUserIlliness() {
		return userIlliness;
	}

	public String getUserMedicine() {
		return userMedicine;
	}

	public String getUserDoctorDetails() {
		return userDoctorDetails;
	}

	public String getUserMedicineStartDate() {
		return userMedicineStartDate;
	}

	public String getUserMedicineEndDate() {
		return userMedicineEndDate;
	}

	
	 
	
	
	
}
