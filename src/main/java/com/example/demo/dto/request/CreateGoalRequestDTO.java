package com.example.demo.dto.request;
//
//title:Laptop
//description:i need a laptop
//catagory:EDUCATION
//targetAmount:10000
//currentAmount:500
//targetDate:10-10-2026
//goalStatus:ACTIVE
//owner:2


import java.time.LocalDate;

import com.example.demo.models.GoalCatagory;
import com.example.demo.models.GoalStatus;

public class CreateGoalRequestDTO {

	private String title;
	private String description;
	private GoalCatagory catagory;
	private int targetAmount;
	private int currentAmount;
	private LocalDate targetDate;
	private GoalStatus goalStatus;
	public CreateGoalRequestDTO() {
		super();
	}
	public CreateGoalRequestDTO(String title, String description, GoalCatagory catagory, int targetAmount, int currentAmount,
			LocalDate targetDate, GoalStatus goalStatus) {
		super();
		this.title = title;
		this.description = description;
		this.catagory = catagory;
		this.targetAmount = targetAmount;
		this.currentAmount = currentAmount;
		this.targetDate = targetDate;
		this.goalStatus = goalStatus;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public GoalCatagory getCatagory() {
		return catagory;
	}
	public void setCatagory(GoalCatagory catagory) {
		this.catagory = catagory;
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
	public LocalDate getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}
	public GoalStatus getGoalStatus() {
		return goalStatus;
	}
	public void setGoalStatus(GoalStatus goalStatus) {
		this.goalStatus = goalStatus;
	}
	@Override
	public String toString() {
		return "GoalRequestDTO [title=" + title + ", description=" + description + ", catagory=" + catagory
				+ ", targetAmount=" + targetAmount + ", currentAmount=" + currentAmount + ", targetDate=" + targetDate
				+ ", goalStatus=" + goalStatus + "]";
	}
	
	
}
