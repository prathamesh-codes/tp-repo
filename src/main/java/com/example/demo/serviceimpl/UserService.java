package com.example.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.UpdateUser;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo ur;
	
	public User updateUser(int id,UpdateUser updateUser) {
		User user = this.ur.findById(id).get();
		
		user.setEmail(updateUser.getEmail());
		user.setName(updateUser.getName());
		
		return this.ur.save(user);
	}
	
	public User getUserById(int id) {
		return this.ur.findById(id).get();
	}
	
}
