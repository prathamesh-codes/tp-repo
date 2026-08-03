package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Goal;
import com.example.demo.models.GoalStatus;
import com.example.demo.repository.projections.CategoryCountProjection;

@Repository
public interface GoalRepo extends JpaRepository<Goal, Integer>{

	List<Goal> findByOwnerId(int ownerId);
	
	int countByOwnerIdAndGoalStatus(int ownerId, GoalStatus goalStatus);

	@Query("SELECT COALESCE(SUM(g.currentAmount), 0) FROM Goal g WHERE g.owner.id = :ownerId")
	int sumTotalReceivedByOwner(@Param("ownerId") int ownerId);
	
	List<Goal> findTop5ByOrderByCurrentAmountDesc();

	@Query("SELECT g.catagory AS category, COUNT(g) AS goalCount FROM Goal g GROUP BY g.catagory")
	List<CategoryCountProjection> countGoalsByCategory();

	int countByGoalStatus(GoalStatus goalStatus);
}
