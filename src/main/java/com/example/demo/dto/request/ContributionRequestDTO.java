package com.example.demo.dto.request;

public class ContributionRequestDTO {

	private int amount;
	private int goal_id;

	public ContributionRequestDTO() {
		super();
	}

	public ContributionRequestDTO(int amount,int goal_id) {
		super();
		this.amount = amount;
		this.goal_id = goal_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getGoal_id() {
		return goal_id;
	}

	public void setGoal_id(int goal_id) {
		this.goal_id = goal_id;
	}

	@Override
	public String toString() {
		return "ContributionRequestDTO [amount=" + amount + ", goal_id=" + goal_id + "]";
	}

		
}