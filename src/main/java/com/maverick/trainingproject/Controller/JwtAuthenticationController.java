/*package com.maverick.trainingproject.Controller;

import java.util.ArrayList;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.maverick.trainingproject.Model.UserLoginModel;
import com.maverick.trainingproject.Service.JwtRequest;
import com.maverick.trainingproject.Service.JwtResponse;
import com.maverick.trainingproject.Service.JwtTokenUtil;
import com.maverick.trainingproject.Service.JwtUserDetailsService;



@Controller
@CrossOrigin
public class JwtAuthenticationController {
	
@Autowired
private AuthenticationManager authenticationManager;

@Autowired
private LoginController l1;


@Autowired
private JwtTokenUtil jwtTokenUtil;

@Autowired
private JwtUserDetailsService userDetailsService;

@CrossOrigin
@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
//System.out.println(authenticationRequest);
System.out.println(authenticationRequest.getUserEmail()+"  "+authenticationRequest.getUserPassword());
//authenticate(authenticationRequest.getUserEmail(), authenticationRequest.getUserPassword());
UserLoginModel ulm1 = new UserLoginModel(authenticationRequest.getUserEmail(), authenticationRequest.getUserPassword());
}
/*int userId = l1.login(ulm1);
if(userId !=0) {
	/*final UserDetails userDetails = userDetailsService
	.loadUserByUsername(authenticationRequest.getUserEmail());*/
	/*final UserDetails userDetails = new User(authenticationRequest.getUserEmail(), "$2y$12$XZee4fLFF6fwrnrqVAatEOHGp02xnr/Thc0TyMRix8rvpvajwiGOu",
			new ArrayList<>());
	final String token = jwtTokenUtil.generateToken(userDetails);
	return ResponseEntity.ok(new JwtResponse(token));
}

throw new Exception("INVALID Credentials");

}*/

/*
private void authenticate(String userEmail, String userPassword) throws Exception {

try {
authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userEmail, userPassword));
} 
catch (DisabledException e) {
throw new Exception("USER_DISABLED", e);

} 
catch (BadCredentialsException e) {
throw new Exception("INVALID_CREDENTIALS", e);

}

}

}*/