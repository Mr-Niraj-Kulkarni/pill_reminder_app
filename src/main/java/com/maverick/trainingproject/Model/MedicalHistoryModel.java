package com.maverick.trainingproject.Model;

import java.sql.Time;
import java.sql.Date;

public class MedicalHistoryModel {
		protected int medicalHistoryId;
		protected String userEmail;
		protected String illiness ;
		protected String doctorDetails ;
		protected String medicine;
		protected Date medicineStartDate ;
		protected Date medicineEndDate ;
		protected int dosageAmount ;
		protected String dosageFrequency ;
		protected Time doageBreakfastTime ;
		protected Time doageLunchTime ;
		protected Time doageDinnerTime ;
		protected int emailNotification ;
		
		
		public int getMedicalHistoryId() {
			return medicalHistoryId;
		}
		public void setMedicalHistoryId(int medicalHistoryId) {
			this.medicalHistoryId = medicalHistoryId;
		}
		
		
		
		public String getUserEmail() {
			return userEmail;
		}

		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
         
		
		
		public int getEmailNotification() {
			return emailNotification;
		}
		public void setEmailNotification(int emailNotification) {
			this.emailNotification = emailNotification;
		}
		
		public String getIlliness() {
			return illiness;
		}
		public void setIlliness(String illiness) {
			this.illiness = illiness;
		}
		public String getDoctorDetails() {
			return doctorDetails;
		}
		public void setDoctorDetails(String doctorDetails) {
			this.doctorDetails = doctorDetails;
		}
		public String getMedicine() {
			return medicine;
		}
		public void setMedicine(String medicine) {
			this.medicine = medicine;
		}
		public Date getMedicineStartDate() {
			return medicineStartDate;
		}
		public void setMedicineStartDate(Date medicineStartDate) {
			this.medicineStartDate = medicineStartDate;
		}
		public Date getMedicineEndDate() {
			return medicineEndDate;
		}
		public void setMedicineEndDate(Date medicineEndDate) {
			this.medicineEndDate = medicineEndDate;
		}
		public int getDosageAmount() {
			return dosageAmount;
		}
		public void setDosageAmount(int dosageAmount) {
			this.dosageAmount = dosageAmount;
		}
		public String getDosageFrequency() {
			return dosageFrequency;
		}
		public void setDosageFrequency(String dosageFrequency) {
			this.dosageFrequency = dosageFrequency;
		}
		public Time getDoageBreakfastTime() {
			return doageBreakfastTime;
		}
		public void setDoageBreakfastTime(Time doageBreakfastTime) {
			this.doageBreakfastTime = doageBreakfastTime;
		}
		public Time getDoageLunchTime() {
			return doageLunchTime;
		}
		public void setDoageLunchTime(Time doageLunchTime) {
			this.doageLunchTime = doageLunchTime;
		}
		public Time getDoageDinnerTime() {
			return doageDinnerTime;
		}
		public void setDoageDinnerTime(Time doageDinnerTime) {
			this.doageDinnerTime = doageDinnerTime;
		}
		
		
	
}
