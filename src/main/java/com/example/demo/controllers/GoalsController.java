package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.CreateGoalRequestDTO;
import com.example.demo.dto.request.UpdateGoalRequestDTO;
import com.example.demo.dto.response.GoalResponseDTO;
import com.example.demo.models.Goal;
import com.example.demo.security.JwtUtils;
import com.example.demo.serviceimpl.GoalService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/goals")
public class GoalsController {
	
	@Autowired
	private GoalService gs;
	
	@PostMapping("/create")
	public GoalResponseDTO createGoal(@ModelAttribute CreateGoalRequestDTO goalReq, HttpServletRequest req) {
		Integer id = (Integer) req.getAttribute("id");
		return this.gs.createGoal(id,goalReq);
	}
	
	@PutMapping("/update/{goalId}")
	public GoalResponseDTO updateGoal(@PathVariable int goalId, @ModelAttribute UpdateGoalRequestDTO updateReq) {
		return this.gs.updateGoal(goalId, updateReq);
	}
	
	@DeleteMapping("/delete/{goalId}")
	public ResponseEntity<?> deleteGoal(@PathVariable int goalId){
		this.gs.deleteGoal(goalId);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/get/{goalId}")
	public ResponseEntity<?> getGoalById(@PathVariable int goalId){
		Optional<GoalResponseDTO> goal = this.gs.getGoalById(goalId);
		
		if(!goal.isEmpty()) {
			return ResponseEntity.ok(goal.get());
		}
		
		HashMap<String, String> map=new HashMap<>();
		
		map.put("Error", "Goal with goal id: " + goalId + " not found");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
	
	@GetMapping("/getMyGoals")
	public List<GoalResponseDTO> getMyGoals(HttpServletRequest req) {
		Integer id = (Integer) req.getAttribute("id");
		
		return this.gs.getMyGoal(id);
	}
	
	@GetMapping("/get")
	public List<GoalResponseDTO> gatAllGoals(){
		return this.gs.getAllGoals();
	}

}
