package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.awt.image.RescaleOp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.CreateGoalRequestDTO;
import com.example.demo.dto.request.UpdateGoalRequestDTO;
import com.example.demo.dto.response.GoalResponseDTO;
import com.example.demo.mappings.GoalMapper;
import com.example.demo.models.Goal;
import com.example.demo.models.User;
import com.example.demo.repository.GoalRepo;

@Service
public class GoalService {

	@Autowired
	private GoalRepo gr;
	
	@Autowired
	private UserService us;
	
	public GoalResponseDTO createGoal(int id,CreateGoalRequestDTO goalReq) {
		User user=this.us.getUserById(id);
		
		Goal goal = new Goal();
		
		goal.setTitle(goalReq.getTitle());
		goal.setDescription(goalReq.getDescription());
		goal.setCatagory(goalReq.getCatagory());
		goal.setTargetAmount(goalReq.getTargetAmount());
		goal.setCurrentAmount(goalReq.getCurrentAmount());
		goal.setTargetDate(goalReq.getTargetDate());
		goal.setGoalStatus(goalReq.getGoalStatus());
		goal.setOwner(user);
		
		this.gr.save(goal);
		
		return GoalMapper.toGoalResponse(goal);
	}
	
	public GoalResponseDTO updateGoal(int goalId, UpdateGoalRequestDTO updateReq) {
		Goal goal = this.gr.findById(goalId).get();
		
		goal.setTitle(updateReq.getTitle());
		goal.setDescription(updateReq.getDescription());
		goal.setCatagory(updateReq.getCatagory());
		goal.setTargetAmount(updateReq.getTargetAmount());
		goal.setTargetDate(updateReq.getTargetDate());
		
		Goal goal1 = this.gr.save(goal);
		
		return GoalMapper.toGoalResponse(goal1);
	}
	
	public void deleteGoal(int goalId) {
		Goal goal = this.gr.findById(goalId).get();
		
		this.gr.delete(goal);
	}
	
	public Optional<GoalResponseDTO> getGoalById(int goalId){
		Optional<Goal> goal = this.gr.findById(goalId);
		
		System.out.println(goal.get());
		if(!goal.isEmpty()) {
			return Optional.of(GoalMapper.toGoalResponse(goal.get()));
		}
		
		return Optional.empty();
		
	}
	
	public List<GoalResponseDTO> getMyGoal(int id){
		List<Goal> goaList = this.gr.findByOwnerId(id);
		
//		System.out.println(goaList);
		
		List<GoalResponseDTO> resList = new ArrayList<>();
		
		for(Goal goal:goaList) {
			resList.add(GoalMapper.toGoalResponse(goal));
		}
		
		return resList;
	}
	
	public List<GoalResponseDTO> getAllGoals(){
		List<Goal> goaList = this.gr.findAll();
		
		List<GoalResponseDTO> resList = new ArrayList<>();
		
		for(Goal goal:goaList) {
			resList.add(GoalMapper.toGoalResponse(goal));
		}
		
		return resList;
	}
}
