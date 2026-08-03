package com.example.demo.dto.request;

import java.time.LocalDate;

import com.example.demo.models.GoalCatagory;
import com.example.demo.models.GoalStatus;

public class UpdateGoalRequestDTO {

	private String title;
	private String description;
	private GoalCatagory catagory;
	private int targetAmount;
	private LocalDate targetDate;
	public UpdateGoalRequestDTO() {
		super();
	}
	public UpdateGoalRequestDTO(String title, String description, GoalCatagory catagory, int targetAmount,
			LocalDate targetDate) {
		super();
		this.title = title;
		this.description = description;
		this.catagory = catagory;
		this.targetAmount = targetAmount;
		this.targetDate = targetDate;
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
	public LocalDate getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}
	@Override
	public String toString() {
		return "UpdateGoalRequestDTO [title=" + title + ", description=" + description + ", catagory=" + catagory
				+ ", targetAmount=" + targetAmount + ", targetDate=" + targetDate + "]";
	}
	
	
}
