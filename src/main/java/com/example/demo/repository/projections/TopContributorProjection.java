package com.example.demo.repository.projections;

public interface TopContributorProjection {
    Integer getUserId();
    String getName();
    Integer getTotalContributed();
}