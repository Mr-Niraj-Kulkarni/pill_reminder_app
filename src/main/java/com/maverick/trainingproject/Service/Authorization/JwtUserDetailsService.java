package com.maverick.trainingproject.Service.Authorization;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.maverick.trainingproject.Repository.LoginRepository;



@Service
public class JwtUserDetailsService implements UserDetailsService {
	LoginRepository tokenEmailCheck = new LoginRepository();

	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		
		if (tokenEmailCheck.checkTokenEmailValid(userEmail)) {
			return new User(userEmail, "userPassword",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + userEmail);
		}
	}
}