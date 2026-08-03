package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.LoginRequest;
import com.example.demo.dto.response.TokenResponse;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.security.JwtUtils;
import com.example.demo.serviceimpl.AuthService;
import com.example.demo.serviceimpl.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService as;

	@PostMapping("/signup")
	public User addUser(@ModelAttribute User user) {
//		System.out.println(user);
		return this.as.signup(user);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> getUser(@ModelAttribute LoginRequest req) {
		Optional<String> tokenOptional = this.as.login(req);
		
		if(!tokenOptional.isEmpty()) {
			TokenResponse tokenResponse = new TokenResponse(tokenOptional.get());
			
			return ResponseEntity.ok(tokenResponse);
		}
		
		HashMap<String,String> map=new HashMap<>();
		
		map.put("error", "invalid credentials");
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
	}
	
//	@GetMapping("/get")
//	public List<User> getAll(){
//		return this.ur.findAll();
//	}
}
