package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.response.DashboardResponse;
import com.example.demo.serviceimpl.DashboardService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	private DashboardService ds;
	
	@GetMapping("/get")
	public DashboardResponse response(HttpServletRequest req) {
		Integer id = (Integer) req.getAttribute("id");
		
		return this.ds.analytics(id);
	}
}
