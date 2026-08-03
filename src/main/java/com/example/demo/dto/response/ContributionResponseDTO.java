package com.example.demo.dto.response;

import java.time.LocalDate;

public class ContributionResponseDTO {

	private int id;
	private int amount;
	private LocalDate contributedAt;
	private int contributorId;
    private String contributorName;
    private int goalId;
    private String goalTitle;
	public ContributionResponseDTO() {
		super();
	}
	public ContributionResponseDTO(int id, int amount, LocalDate contributedAt, int contributorId,
			String contributorName, int goalId, String goalTitle) {
		super();
		this.id = id;
		this.amount = amount;
		this.contributedAt = contributedAt;
		this.contributorId = contributorId;
		this.contributorName = contributorName;
		this.goalId = goalId;
		this.goalTitle = goalTitle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public LocalDate getContributedAt() {
		return contributedAt;
	}
	public void setContributedAt(LocalDate contributedAt) {
		this.contributedAt = contributedAt;
	}
	public int getContributorId() {
		return contributorId;
	}
	public void setContributorId(int contributorId) {
		this.contributorId = contributorId;
	}
	public String getContributorName() {
		return contributorName;
	}
	public void setContributorName(String contributorName) {
		this.contributorName = contributorName;
	}
	public int getGoalId() {
		return goalId;
	}
	public void setGoalId(int goalId) {
		this.goalId = goalId;
	}
	public String getGoalTitle() {
		return goalTitle;
	}
	public void setGoalTitle(String goalTitle) {
		this.goalTitle = goalTitle;
	}
	@Override
	public String toString() {
		return "ContributionResponseDTO [id=" + id + ", amount=" + amount + ", contributedAt=" + contributedAt
				+ ", contributorId=" + contributorId + ", contributorName=" + contributorName + ", goalId=" + goalId
				+ ", goalTitle=" + goalTitle + "]";
	}
    
    
}
