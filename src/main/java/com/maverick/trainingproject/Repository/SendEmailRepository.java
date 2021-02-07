package com.maverick.trainingproject.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import com.maverick.trainingproject.Model.SendEmailModel;
import com.maverick.trainingproject.Model.UserProfileModel;
import com.maverick.trainingproject.Service.MedicalHistory.SendEmailService;

@Component
public class SendEmailRepository {

	@Autowired
	private SendEmailService emailService;
	
	private Statement statement = null;
    private ResultSet rs = null;
    
	
    @EventListener(ApplicationReadyEvent.class)
	public void getData() throws InterruptedException {
		
		
    	// Send Email to User
    	Thread UserSendEmailThread = new Thread() {
    	    public void run() {
    	    	DataBaseConnection dbObject= new DataBaseConnection() ;
    			Connection connect = dbObject.databaseConnection() ;
    			String query1 = "select userId, userName, userEmail from user_info";
    			while(true) {
					try {
//    						number of users
//    						System.out.println("while");
						statement = connect.createStatement();
						rs = statement.executeQuery(query1);
						ArrayList<SendEmailModel> arr = new ArrayList<SendEmailModel>();
						while (rs.next()) {
//    							System.out.println("user Take");
//							System.out.println(rs.getString(2));
							arr.add(new SendEmailModel(rs.getInt(1), rs.getString(2), rs.getString(3)));
						}
						for (SendEmailModel sendEmailModel : arr) {
							String query2 = "select h.emailNotification, h.userIlliness, h.userMedicine, h.userDoctorDetails, h.userMedicineStartDate, h.userMedicineEndDate "
									+ "from user_medical_history as h  "
									+ "where (h.userId_M = '"+sendEmailModel.getUserId()+"') and "
									+ "( curdate() >= h.userMedicineStartDate "
									+ "AND (h.userMedicineEndDate >= curdate() OR h.userMedicineEndDate is null) ) AND "
									+ "( date_format(h.userDosageBreakfastTime, '%H:%i') = date_format(current_time(), '%H:%i') or "
									+ "date_format(h.userDosageLunchTime, '%H:%i') = date_format(current_time(), '%H:%i') or "
									+ "date_format(h.userDosageDinnerTime, '%H:%i') = date_format(current_time(), '%H:%i') ) ";
							statement = connect.createStatement();
							rs = statement.executeQuery(query2);
							ArrayList<SendEmailModel> arr1 = new ArrayList<SendEmailModel>();
//    							for each particular user get the no of pills data
							if(rs.next()) {
//    								for first row values
//								System.out.println("data of particular user");
								int id = rs.getInt(1);
							System.out.println(id);
								if(id == 1) {
//									System.out.println(sendEmailModel.getUserEmail());
									arr1.add(new SendEmailModel(sendEmailModel.getUserId(), sendEmailModel.getUserName(), sendEmailModel.getUserEmail(), 
											rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6) ));			
								}
								while(rs.next()) {
	//								System.out.println("data of particular user");
									id = rs.getInt(1);
//									System.out.println(id);
									if(id == 1) {
										arr1.add(new SendEmailModel(sendEmailModel.getUserId(), sendEmailModel.getUserName(), sendEmailModel.getUserEmail(), 
												rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6) ));			
									}
								}
	//							send email for paricular user
								Thread thread1 = new Thread() {
								    public void run() {
								    	//int i=0 ;
								    	try {
											emailService.sendEmail(sendEmailModel.getUserName(), sendEmailModel.getUserEmail(), 
													arr1);
//										System.out.println("count");
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
								    }
								};
								thread1.start();
								thread1.join();
//								
							}
						}
						Thread.sleep(30000);
					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
    			}
    	    }
    	};

    	
    	
//    	Send Email to Dependent
    	Thread DependentSendEmailThread = new Thread() {
    	    public void run() {
    	    	DataBaseConnection dbObject= new DataBaseConnection() ;
    			Connection connect = dbObject.databaseConnection() ;
    			String query1 = "select dependentId, dependentName, dependentEmail from user_dependents";
    			while(true) {
					try {
//    						number of users
						statement = connect.createStatement();
						rs = statement.executeQuery(query1);
						ArrayList<SendEmailModel> dependentArray = new ArrayList<SendEmailModel>();
						while (rs.next()) {
							//System.out.println(rs.getString(2));
							dependentArray.add(new SendEmailModel(rs.getInt(1), rs.getString(2), rs.getString(3)));
						}
						for (SendEmailModel sendEmailModel : dependentArray) {
							String query2 = "select h.emailNotification, h.dependentIlliness, h.dependentMedicine, h.dependentDoctorDetails, h.dependentMedicineStartDate, h.dependentMedicineEndDate "
									+ "from dependent_medical_history h "
									+ "where (h.dependentId = '"+sendEmailModel.getUserId()+"') and "
									+ "(curdate() >= h.dependentMedicineStartDate AND (h.dependentMedicineEndDate >= curdate()"
									+ " OR h.dependentMedicineEndDate is null)) AND "
									+ "( date_format(h.dependentDosageBreakfastTime, '%H:%i') = date_format(current_time(), '%H:%i') or "
									+ "date_format(h.dependentDosageLunchTime, '%H:%i') = date_format(current_time(), '%H:%i') or "
									+ "date_format(h.dependentDosageDinnerTime, '%H:%i') = date_format(current_time(), '%H:%i') ) ";
							statement = connect.createStatement();
							rs = statement.executeQuery(query2);
							ArrayList<SendEmailModel> dependentData = new ArrayList<SendEmailModel>();
//    							for each particular dependent get the no of pills data
							if(rs.next()) {
//    								for first row values
//								System.out.println("data of particular dependent");
								int id = rs.getInt(1);
//								System.out.println(id);
								if(id == 1) {
//									System.out.println(sendEmailModel.getUserId());
									dependentData.add(new SendEmailModel(sendEmailModel.getUserId(), sendEmailModel.getUserName(), sendEmailModel.getUserEmail(), 
											rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6) ));			
								}
								while(rs.next()) {
	//								System.out.println("data of particular user");
									id = rs.getInt(1);
//									System.out.println(id);
									if(id == 1) {
										dependentData.add(new SendEmailModel(sendEmailModel.getUserId(), sendEmailModel.getUserName(), sendEmailModel.getUserEmail(), 
												rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6) ));			
									}
								}
	//							send email for particular dependent
								Thread thread2 = new Thread() {
								    public void run() {
								    	try {
											emailService.sendEmail(sendEmailModel.getUserName(), sendEmailModel.getUserEmail(), 
													dependentData);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
								    }
								};
								thread2.start();
								thread2.join();
//								System.out.println("send dan dependent");
							}
						}
						Thread.sleep(30000);
					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
    			}
    	    }
    	};

    	// Start the sending mail.
//    	UserSendEmailThread.start();
//    	DependentSendEmailThread.start();
    }

}
