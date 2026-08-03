package com.example.demo.mappings;

import java.io.ObjectInputStream.GetField;

import com.example.demo.dto.response.GoalResponseDTO;
import com.example.demo.models.Goal;

public class GoalMapper {
	
	public static GoalResponseDTO toGoalResponse(Goal goal) {
		return new GoalResponseDTO(
				goal.getId(),
				goal.getTitle(),
				goal.getDescription(),
				goal.getCatagory(),
				goal.getTargetAmount(), 
				goal.getCurrentAmount(),
				goal.getTargetDate(),
				goal.getGoalStatus(),
				goal.getCreatedDate(),
				goal.getOwner().getName(),
				goal.getOwner().getEmail());
		
	}

}
