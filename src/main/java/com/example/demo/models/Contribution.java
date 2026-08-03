package com.example.demo.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contributions")
public class Contribution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int amount;
	private LocalDate contributedAt;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contributor_id", nullable = false)
	private User contributor;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goal_id", nullable = false)
	private Goal goal;

	public Contribution() {
		super();
	}

	public Contribution(int id, int amount, LocalDate contributedAt, User contributor, Goal goal) {
		super();
		this.id = id;
		this.amount = amount;
		this.contributedAt = contributedAt;
		this.contributor = contributor;
		this.goal = goal;
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

	public User getContributer() {
		return contributor;
	}

	public void setContributer(User contributor) {
		this.contributor = contributor;
	}

	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	@Override
	public String toString() {
		return "Contribution [id=" + id + ", amount=" + amount + ", contributedAt=" + contributedAt + ", Contributer="
				+ contributor + ", goal=" + goal + "]";
	}
    
    
}
