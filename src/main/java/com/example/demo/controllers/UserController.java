package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.UpdateUser;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.serviceimpl.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService us;
	
	@PostMapping("/update")
	public User updateUser(@ModelAttribute UpdateUser updateUser, HttpServletRequest request) {
		Integer id = (Integer) request.getAttribute("id");
		
		return this.us.updateUser(id, updateUser);
		
	}
	
	
}
