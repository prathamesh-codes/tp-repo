package com.example.demo.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "goals")
public class Goal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	private String description;
	
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
	private GoalCatagory catagory;
    
    private int targetAmount;
    private int currentAmount;
    
    private LocalDate targetDate;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GoalStatus goalStatus;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;
    
    private LocalDate createdDate = LocalDate.now();

	public Goal() {
		super();
	}

	public Goal(int id, String title, String description, GoalCatagory catagory, int targetAmount, int currentAmount,
			LocalDate targetDate, GoalStatus goalStatus, User owner, LocalDate createdDate) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.catagory = catagory;
		this.targetAmount = targetAmount;
		this.currentAmount = currentAmount;
		this.targetDate = targetDate;
		this.goalStatus = goalStatus;
		this.owner = owner;
		this.createdDate = createdDate;
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

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Goals [id=" + id + ", title=" + title + ", description=" + description + ", catagory=" + catagory
				+ ", targetAmount=" + targetAmount + ", currentAmount=" + currentAmount + ", targetDate=" + targetDate
				+ ", goalStatus=" + goalStatus + ", owner=" + owner + ", createdDate=" + createdDate + "]";
	}
    
    
    
}
    
    
    
