package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.response.CategoryStatsResponse;
import com.example.demo.dto.response.GoalProgressResponse;
import com.example.demo.dto.response.GoalResponseDTO;
import com.example.demo.dto.response.TopContributorResponse;
import com.example.demo.mappings.GoalMapper;
import com.example.demo.models.Goal;
import com.example.demo.repository.ContributionRepo;
import com.example.demo.repository.GoalRepo;
import com.example.demo.repository.projections.CategoryCountProjection;
import com.example.demo.repository.projections.TopContributorProjection;

@Service
public class AnalyticsService {

	@Autowired
	private GoalRepo gr;
	
	@Autowired
	private ContributionRepo cr;
	
	public GoalProgressResponse getGoalProgress(int goalId) {
		Goal goal = this.gr.findById(goalId).get();
		
		int contributorsCount = this.cr.countDistinctContributorsByGoalId(goalId);
        double average = this.cr.averageContributionByGoalId(goalId);
        int largest = this.cr.largestContributionByGoalId(goalId);

        double completionPercentage = 0.0;
        if (goal.getTargetAmount() > 0) {
            completionPercentage = ((double) goal.getCurrentAmount() / goal.getTargetAmount()) * 100;
        }

        return new GoalProgressResponse(
                goal.getId(),
                goal.getTitle(),
                goal.getTargetAmount(),
                goal.getCurrentAmount(),
                completionPercentage,
                contributorsCount,
                average,
                largest
        );
	}
	
	public List<GoalResponseDTO> getTopFundedGoals() {
		List<Goal> goals = this.gr.findTop5ByOrderByCurrentAmountDesc();
		
        List<GoalResponseDTO> goalsResponse = new ArrayList<>();
        
        for(Goal goal : goals) {
        	goalsResponse.add(GoalMapper.toGoalResponse(goal));
        }
        
        return goalsResponse;
    }
	
	public List<TopContributorResponse> getTopContributors() {
        List<TopContributorProjection> results =
                this.cr.findTopContributors();

        return results.stream()
                .map(p -> new TopContributorResponse(p.getUserId(), p.getName(), p.getTotalContributed()))
                .toList();
    }
	
	public List<CategoryStatsResponse> getGoalsByCategory() {
        List<CategoryCountProjection> results = this.gr.countGoalsByCategory();

        return results.stream()
                .map(p -> new CategoryStatsResponse(p.getCategory(), p.getGoalCount()))
                .toList();
    }
}
