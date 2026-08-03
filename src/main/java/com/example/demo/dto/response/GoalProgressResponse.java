package com.example.demo.dto.response;

public class GoalProgressResponse {

	private int goalId;
	private String title;
	private int targetAmount;
	private int currentAmount;
	private double completionPercentage;
	private long contributorsCount;
	private double averageContribution;
	private int largestContribution;
	public GoalProgressResponse() {
		super();
	}
	public GoalProgressResponse(int goalId, String title, int targetAmount, int currentAmount,
			double completionPercentage, long contributorsCount, double averageContribution, int largestContribution) {
		super();
		this.goalId = goalId;
		this.title = title;
		this.targetAmount = targetAmount;
		this.currentAmount = currentAmount;
		this.completionPercentage = completionPercentage;
		this.contributorsCount = contributorsCount;
		this.averageContribution = averageContribution;
		this.largestContribution = largestContribution;
	}
	public int getGoalId() {
		return goalId;
	}
	public void setGoalId(int goalId) {
		this.goalId = goalId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTargetAmount() {
		return targetAmount;
	}
	public void setTargetAmount(int targetAmount) {
		this.targetAmount = targetAmount;
	}
	public int getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(int currentAmount) {
		this.currentAmount = currentAmount;
	}
	public double getCompletionPercentage() {
		return completionPercentage;
	}
	public void setCompletionPercentage(double completionPercentage) {
		this.completionPercentage = completionPercentage;
	}
	public long getContributorsCount() {
		return contributorsCount;
	}
	public void setContributorsCount(long contributorsCount) {
		this.contributorsCount = contributorsCount;
	}
	public double getAverageContribution() {
		return averageContribution;
	}
	public void setAverageContribution(double averageContribution) {
		this.averageContribution = averageContribution;
	}
	public int getLargestContribution() {
		return largestContribution;
	}
	public void setLargestContribution(int largestContribution) {
		this.largestContribution = largestContribution;
	}
	@Override
	public String toString() {
		return "GoalProgressResponse [goalId=" + goalId + ", title=" + title + ", targetAmount=" + targetAmount
				+ ", currentAmount=" + currentAmount + ", completionPercentage=" + completionPercentage
				+ ", contributorsCount=" + contributorsCount + ", averageContribution=" + averageContribution
				+ ", largestContribution=" + largestContribution + "]";
	}
	
	
}