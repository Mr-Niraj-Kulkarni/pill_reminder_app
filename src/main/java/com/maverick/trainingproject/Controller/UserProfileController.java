package com.maverick.trainingproject.Controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
//import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.maverick.trainingproject.TrainingprojectApplication;
import com.maverick.trainingproject.Model.UserProfileModel;
import com.maverick.trainingproject.Model.userImageModel;
import com.maverick.trainingproject.Service.JwtRequest;
import com.maverick.trainingproject.Service.JwtTokenUtil;
//import com.maverick.trainingproject.Service.SendEmailService;
import com.maverick.trainingproject.Service.UserProfileService;

@Controller
public class UserProfileController {

	@Autowired
	private UserProfileService profileService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@CrossOrigin
	@RequestMapping(value = "/getProfileData", method = {RequestMethod.GET})
	@ResponseBody
	public UserProfileModel getProfileData(HttpServletRequest request) {
		//JwtRequest getEmailForRequest = new JwtRequest();
		//String email = ("akk@gmail.com").trim();
		String userEmail = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
		System.out.println(userEmail+"asasa");
		UserProfileModel model = new UserProfileModel();
		model = profileService.getUserProfileData(userEmail);
		
		return model;
	}
	
	
	
	@CrossOrigin
	@RequestMapping(value = "/setProfileData", method = {RequestMethod.POST})
	@ResponseBody
	public String setProfileData(HttpServletRequest request, @RequestBody UserProfileModel model) {
		String tokenEmail = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
		return profileService.setProfileData(model,tokenEmail);
	}
	
	
	
	@CrossOrigin
	@RequestMapping(value = "/getDependentProfileData", method = {RequestMethod.POST})
	@ResponseBody
	public UserProfileModel getDependentProfileData(HttpServletRequest request, @RequestBody Map<String,String> dependentObj) {
		String userEmail = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
		UserProfileModel dependentProfileModel;
		dependentProfileModel = profileService.getDependentProfileData(userEmail, dependentObj.get("dependentRelation"), dependentObj.get("dependentName"));
		return dependentProfileModel;
	}
	
	
	
	@CrossOrigin
	@RequestMapping(value = "/setDependentProfileData", method = {RequestMethod.POST})
	@ResponseBody
	public String setDependentProfileData(HttpServletRequest request, @RequestBody UserProfileModel model) {
		String tokenEmail = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
		return profileService.setDependentProfileData(model,tokenEmail);
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/uploadImage", method = {RequestMethod.POST})
	@ResponseBody
	public boolean uploadImage(HttpServletRequest request, @RequestParam Map<String,MultipartFile>Obj ) throws SerialException, SQLException, IOException {
		String tokenEmail = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
		userImageModel m1 = new userImageModel();
		m1.setImage(new javax.sql.rowset.serial.SerialBlob((Obj.get("image").getBytes())));
		System.out.println(Obj.get("image").getContentType());
		
		/*File image = new File("C:\\Users\\anup\\Desktop\\bbb.png");
	      FileOutputStream fos = new FileOutputStream(image);
	      //byte[] buffer = new byte[1];
	      byte byteArray[] = m1.getImage().getBytes(1,(int)m1.getImage().length());
	      FileOutputStream outPutStream = new FileOutputStream(image);
	      outPutStream.write(byteArray);
	      outPutStream.close();*/
		UserProfileService s1 = new UserProfileService();
		
		//System.out.println(Obj.get("image")
		
		return s1.setPic(m1,tokenEmail);
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getImage", method = {RequestMethod.GET}, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public byte[] getImage(HttpServletRequest request) throws SerialException, SQLException, IOException, InterruptedException {
		String tokenEmail = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
		System.out.println("############################################");
		//System.out.println(Obj.get("name"));
		//System.out.println(Obj.get("name"));
		System.out.println("############################################");
		/*if(profileService.getImage(Obj)!=null) {
			return true;
		}
		else {
			return false;
		}*/
		Blob blob = profileService.getImage(tokenEmail);
		File image = new File("D:\\PillReminderBranches\\pill_bak_projectdone_beforeblob\\pill_reminder_app\\target\\classes\\staticaaa.png");
	      FileOutputStream fos = new FileOutputStream(image);
	      //byte[] buffer = new byte[1];
	      byte byteArray[] = blob.getBytes(1,(int)blob.length());
	      FileOutputStream outPutStream = new FileOutputStream(image);
	      outPutStream.write(byteArray);
	      outPutStream.close();
	      Thread.sleep(100);
	      
		/*Blob blob = profileService.getImage(Obj);
		MultipartFile result = new MockMultipartFile("profile.png","aaa.png","image/png",blob.getBytes(1L, (int)blob.length()));*/
		return Files.readAllBytes(image.toPath());
		
	}
	
}
