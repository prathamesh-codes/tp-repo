package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.ContributionRequestDTO;
import com.example.demo.dto.response.ContributionResponseDTO;
import com.example.demo.serviceimpl.ContriService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/contribute")
public class ContriController {

	@Autowired
	private ContriService cs;
	
	@PostMapping
	public ContributionResponseDTO contribute(@ModelAttribute ContributionRequestDTO contriReq, HttpServletRequest req) {
		Integer id = (Integer) req.getAttribute("id"); 
		
		return this.cs.contribute(id,contriReq);
	}
	
	@GetMapping("/myContributions")
	public List<ContributionResponseDTO> myContributions(HttpServletRequest req){
		Integer id = (Integer) req.getAttribute("id");
		
		return this.cs.myGoalContribution(id);
	}
	
	@GetMapping("/contrisToGoal/{goalId}")
	public List<ContributionResponseDTO> contrisToGoal(@PathVariable int goalId){
		return this.cs.goalContributors(goalId);
	}
}
