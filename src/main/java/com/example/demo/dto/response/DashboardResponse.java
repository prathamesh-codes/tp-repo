package com.example.demo.dto.response;

import java.util.List;

public class DashboardResponse {

	private List<GoalResponseDTO> myGoals;
	private List<GoalResponseDTO> supportedGoals;
	private int totalContributed;
	private int totalRecived;
	private int activeGoalsCount;
	private int completedGoalsCount;
	private int expiredGoalsCount;
	public DashboardResponse() {
		super();
	}
	public DashboardResponse(List<GoalResponseDTO> myGoals, List<GoalResponseDTO> supportedGoals, int totalContributed,
			int totalRecived, int activeGoalsCount, int completedGoalsCount, int expiredGoalsCount) {
		super();
		this.myGoals = myGoals;
		this.supportedGoals = supportedGoals;
		this.totalContributed = totalContributed;
		this.totalRecived = totalRecived;
		this.activeGoalsCount = activeGoalsCount;
		this.completedGoalsCount = completedGoalsCount;
		this.expiredGoalsCount = expiredGoalsCount;
	}
	public List<GoalResponseDTO> getMyGoals() {
		return myGoals;
	}
	public void setMyGoals(List<GoalResponseDTO> myGoals) {
		this.myGoals = myGoals;
	}
	public List<GoalResponseDTO> getSupportedGoals() {
		return supportedGoals;
	}
	public void setSupportedGoals(List<GoalResponseDTO> supportedGoals) {
		this.supportedGoals = supportedGoals;
	}
	public int getTotalContributed() {
		return totalContributed;
	}
	public void setTotalContributed(int totalContributed) {
		this.totalContributed = totalContributed;
	}
	public int getTotalRecived() {
		return totalRecived;
	}
	public void setTotalRecived(int totalRecived) {
		this.totalRecived = totalRecived;
	}
	public int getActiveGoalsCount() {
		return activeGoalsCount;
	}
	public void setActiveGoalsCount(int activeGoalsCount) {
		this.activeGoalsCount = activeGoalsCount;
	}
	public int getCompletedGoalsCount() {
		return completedGoalsCount;
	}
	public void setCompletedGoalsCount(int completedGoalsCount) {
		this.completedGoalsCount = completedGoalsCount;
	}
	public int getExpiredGoalsCount() {
		return expiredGoalsCount;
	}
	public void setExpiredGoalsCount(int expiredGoalsCount) {
		this.expiredGoalsCount = expiredGoalsCount;
	}
	@Override
	public String toString() {
		return "DashboardResponse [myGoals=" + myGoals + ", supportedGoals=" + supportedGoals + ", totalContributed="
				+ totalContributed + ", totalRecived=" + totalRecived + ", activeGoalsCount=" + activeGoalsCount
				+ ", completedGoalsCount=" + completedGoalsCount + ", expiredGoalsCount=" + expiredGoalsCount + "]";
	}
	
	
}
