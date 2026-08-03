package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.response.DashboardResponse;
import com.example.demo.dto.response.GoalResponseDTO;
import com.example.demo.mappings.GoalMapper;
import com.example.demo.models.Contribution;
import com.example.demo.models.Goal;
import com.example.demo.models.GoalStatus;
import com.example.demo.repository.ContributionRepo;
import com.example.demo.repository.GoalRepo;

@Service
public class DashboardService {

	@Autowired
	private GoalRepo gr;
	
	@Autowired
	private ContributionRepo cr;
	
	public DashboardResponse analytics(int userId) {
		List<Goal> myGoals = this.gr.findByOwnerId(userId);
		
		List<Goal> goalsIContributed = this.cr.findDistinctGoalsSupportedByUser(userId);
		
		List<GoalResponseDTO> myGoalsRes = new ArrayList<>();
		
		List<GoalResponseDTO> goalsIContributedRes = new ArrayList<>();
		
		for(Goal myGoal:myGoals) {
			myGoalsRes.add(GoalMapper.toGoalResponse(myGoal));
		}
		
		for(Goal goalIContributed:goalsIContributed) {
			goalsIContributedRes.add(GoalMapper.toGoalResponse(goalIContributed));
		}
		
		int totalContributed = this.cr.sumTotalContributedByUser(userId);
		
		int totalRecived = this.gr.sumTotalReceivedByOwner(userId);
		
		int activeGoalsCount = this.gr.countByOwnerIdAndGoalStatus(userId, GoalStatus.ACTIVE);
		
		int completedGoalsCount = this.gr.countByOwnerIdAndGoalStatus(userId, GoalStatus.COMPLETED);
		
		int expiredGoalsCount = this.gr.countByOwnerIdAndGoalStatus(userId, GoalStatus.EXPIRED);
		
		return new DashboardResponse(
				myGoalsRes,
				goalsIContributedRes,
				totalContributed,
				totalRecived,
				activeGoalsCount,
				completedGoalsCount,
				expiredGoalsCount); 
	}
}
