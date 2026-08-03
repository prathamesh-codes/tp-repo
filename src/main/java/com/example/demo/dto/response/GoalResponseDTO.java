package com.example.demo.dto.response;

import java.time.LocalDate;

import com.example.demo.models.GoalCatagory;
import com.example.demo.models.GoalStatus;

public class GoalResponseDTO {

	private int id;
	private String title;
	private String description;
	private GoalCatagory catagory;
	private int targetAmount;
	private int currentAmount;
	private LocalDate targetDate;
	private GoalStatus goalStatus;
	private LocalDate createdDate;
	private String name;
	private String email;
	public GoalResponseDTO() {
		super();
	}
	public GoalResponseDTO(int id, String title, String description, GoalCatagory catagory, int targetAmount,
			int currentAmount, LocalDate targetDate, GoalStatus goalStatus, LocalDate createdDate, String name,
			String email) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.catagory = catagory;
		this.targetAmount = targetAmount;
		this.currentAmount = currentAmount;
		this.targetDate = targetDate;
		this.goalStatus = goalStatus;
		this.createdDate = createdDate;
		this.name = name;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "GoalResponseDTO [id=" + id + ", title=" + title + ", description=" + description + ", catagory="
				+ catagory + ", targetAmount=" + targetAmount + ", currentAmount=" + currentAmount + ", targetDate="
				+ targetDate + ", goalStatus=" + goalStatus + ", createdDate=" + createdDate + ", name=" + name
				+ ", email=" + email + "]";
	}
	
	
}
