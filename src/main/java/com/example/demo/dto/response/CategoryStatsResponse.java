package com.example.demo.dto.response;

import com.example.demo.models.GoalCatagory;

public class CategoryStatsResponse {

	private GoalCatagory catagory;
	private int goalCount;
	public CategoryStatsResponse() {
		super();
	}
	public CategoryStatsResponse(GoalCatagory catagory, int goalCount) {
		super();
		this.catagory = catagory;
		this.goalCount = goalCount;
	}
	public GoalCatagory getCatagory() {
		return catagory;
	}
	public void setCatagory(GoalCatagory catagory) {
		this.catagory = catagory;
	}
	public int getGoalCount() {
		return goalCount;
	}
	public void setGoalCount(int goalCount) {
		this.goalCount = goalCount;
	}
	@Override
	public String toString() {
		return "CategoryStatsResponse [catagory=" + catagory + ", goalCount=" + goalCount + "]";
	}
	
	
}
