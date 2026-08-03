package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.response.CategoryStatsResponse;
import com.example.demo.dto.response.GoalProgressResponse;
import com.example.demo.dto.response.GoalResponseDTO;
import com.example.demo.dto.response.TopContributorResponse;
import com.example.demo.serviceimpl.AnalyticsService;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {
	
	@Autowired
	private AnalyticsService as;

	@GetMapping("/getProgress/{goalId}")
	public GoalProgressResponse goalProgress(@PathVariable int goalId) {
		return this.as.getGoalProgress(goalId);
	}
	
	@GetMapping("/getTopFunded")
	public List<GoalResponseDTO> topFunded() {
		return this.as.getTopFundedGoals();
	}
	
	@GetMapping("/getTopContributors")
	public List<TopContributorResponse> topContributors() {
		return this.as.getTopContributors();
	}
	
	@GetMapping("/getGoalsByCatagory")
	public List<CategoryStatsResponse> goalsByCatagory() {
		return this.as.getGoalsByCategory();
	}
}
