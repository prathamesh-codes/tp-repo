package com.example.demo.dto.response;

public class TopContributorResponse {

	private int userId;
	private String name;
	private int totalContributed;
	public TopContributorResponse() {
		super();
	}
	public TopContributorResponse(int userId, String name, int totalContributed) {
		super();
		this.userId = userId;
		this.name = name;
		this.totalContributed = totalContributed;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalContributed() {
		return totalContributed;
	}
	public void setTotalContributed(int totalContributed) {
		this.totalContributed = totalContributed;
	}
	@Override
	public String toString() {
		return "TopContributorResponse [userId=" + userId + ", name=" + name + ", totalContributed=" + totalContributed
				+ "]";
	}
	
	
}
