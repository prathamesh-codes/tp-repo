package com.example.demo.repository.projections;

import com.example.demo.models.GoalCatagory;

public interface CategoryCountProjection {
    GoalCatagory getCategory();
    int getGoalCount();
}