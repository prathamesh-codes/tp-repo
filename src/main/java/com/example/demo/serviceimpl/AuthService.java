package com.example.demo.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.LoginRequest;
import com.example.demo.dto.response.TokenResponse;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.security.JwtUtils;

@Service
public class AuthService {

	@Autowired
	private UserRepo ur;
	
	public User signup(User user) {
		return this.ur.save(user);
	}
	
	public Optional<String> login(LoginRequest req){
		User user= this.ur.findByEmail(req.getEmail());
		
		if(user!=null && user.getPassword().equals(req.getPassword())) {
			String token = JwtUtils.generateToken(user.getId(), user.getEmail());
			
			return Optional.of(token);
		}
		
		return Optional.empty();
	}
}
