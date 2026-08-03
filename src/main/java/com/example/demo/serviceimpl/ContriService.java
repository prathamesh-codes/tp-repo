package com.example.demo.serviceimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.ContributionRequestDTO;
import com.example.demo.dto.response.ContributionResponseDTO;
import com.example.demo.mappings.ContributionMapper;
import com.example.demo.models.Contribution;
import com.example.demo.models.Goal;
import com.example.demo.models.GoalStatus;
import com.example.demo.models.User;
import com.example.demo.repository.ContributionRepo;
import com.example.demo.repository.GoalRepo;

@Service
public class ContriService {

	@Autowired
	private ContributionRepo cr;
	
	@Autowired
	private UserService us;
	
	@Autowired
	private GoalRepo gr;
	
	public ContributionResponseDTO contribute(int id, ContributionRequestDTO contriReq) {
		Goal goal = this.gr.findById(contriReq.getGoal_id()).get();
		
		User user = this.us.getUserById(id);
		
		Contribution contri = new Contribution();
		
		contri.setAmount(contriReq.getAmount());
		contri.setContributedAt(LocalDate.now());
		contri.setContributer(user);
		contri.setGoal(goal);
		
		this.cr.save(contri);
		
		if(contriReq.getAmount() >= goal.getTargetAmount()-goal.getCurrentAmount()) {
			goal.setCurrentAmount(goal.getTargetAmount());
			goal.setGoalStatus(GoalStatus.COMPLETED);
		}
		else {
			goal.setCurrentAmount(goal.getCurrentAmount() + contriReq.getAmount());
		}
		
		this.gr.save(goal);
		
		return ContributionMapper.toContirbutionResponseDTO(contri);
	}
	
	public List<ContributionResponseDTO> myGoalContribution(int userId){
		List<Contribution> myContris = this.cr.findByContributorId(userId);
		
		List<ContributionResponseDTO> myContrisResponse = new ArrayList<>();
		
		for(Contribution mycontri:myContris) {
			myContrisResponse.add(ContributionMapper.toContirbutionResponseDTO(mycontri));
		}
		
		return myContrisResponse;
	}
	
	public List<ContributionResponseDTO> goalContributors(int goalId){
		List<Contribution> contrisToGoal = this.cr.findByGoalId(goalId);
		
		List<ContributionResponseDTO> goalContrisRes = new ArrayList<>();
		
		for(Contribution contriToGoal:contrisToGoal) {
			goalContrisRes.add(ContributionMapper.toContirbutionResponseDTO(contriToGoal));
		}
		
		return goalContrisRes;
	}
	
	
}
