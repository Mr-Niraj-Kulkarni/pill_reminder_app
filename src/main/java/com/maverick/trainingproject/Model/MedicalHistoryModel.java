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
		protected Time dosageBreakfastTime ;
		protected Time dosageLunchTime ;
		protected Time dosageDinnerTime ;
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
		public Time getDosageBreakfastTime() {
			return dosageBreakfastTime;
		}
		public void setDosageBreakfastTime(Time dosageBreakfastTime) {
			this.dosageBreakfastTime = dosageBreakfastTime;
		}
		public Time getDosageLunchTime() {
			return dosageLunchTime;
		}
		public void setDosageLunchTime(Time dosageLunchTime) {
			this.dosageLunchTime = dosageLunchTime;
		}
		public Time getDosageDinnerTime() {
			return dosageDinnerTime;
		}
		public void setDosageDinnerTime(Time dosageDinnerTime) {
			this.dosageDinnerTime = dosageDinnerTime;
		}
		
		
		
		
	
}
