package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ContributionReq")
public class ContributionReq {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contribution_id", nullable = false)
	private Contribution contribution;
	
	private ContributionStatus status;

	public ContributionReq() {
		super();
	}

	public ContributionReq(int id, Contribution contribution, ContributionStatus status) {
		super();
		this.id = id;
		this.contribution = contribution;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Contribution getContribution() {
		return contribution;
	}

	public void setContribution(Contribution contribution) {
		this.contribution = contribution;
	}

	public ContributionStatus getStatus() {
		return status;
	}

	public void setStatus(ContributionStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ContributionReq [id=" + id + ", contribution=" + contribution + ", status=" + status + "]";
	}
	
	
}
