package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Contribution;
import com.example.demo.models.Goal;
import com.example.demo.repository.projections.TopContributorProjection;

@Repository
public interface ContributionRepo extends JpaRepository<Contribution, Integer>{

	List<Contribution> findByContributorId(int id);
	
	List<Contribution> findByGoalId(int id);
	
	@Query("SELECT COALESCE(SUM(c.amount), 0) FROM Contribution c WHERE c.contributor.id = :contributorId")
	int sumTotalContributedByUser(@Param("contributorId") int contributorId);

	@Query("SELECT DISTINCT c.goal FROM Contribution c WHERE c.contributor.id = :contributorId")
	List<Goal> findDistinctGoalsSupportedByUser(@Param("contributorId") int contributorId);
	
	@Query("SELECT COUNT(DISTINCT c.contributor.id) FROM Contribution c WHERE c.goal.id = :goalId")
	int countDistinctContributorsByGoalId(@Param("goalId") int goalId);

	@Query("SELECT COALESCE(AVG(c.amount), 0) FROM Contribution c WHERE c.goal.id = :goalId")
	double averageContributionByGoalId(@Param("goalId") int goalId);

	@Query("SELECT COALESCE(MAX(c.amount), 0) FROM Contribution c WHERE c.goal.id = :goalId")
	int largestContributionByGoalId(@Param("goalId") int goalId);

	@Query("""
	    SELECT c.contributor.id AS userId, c.contributor.name AS name, SUM(c.amount) AS totalContributed
	    FROM Contribution c
	    GROUP BY c.contributor.id, c.contributor.name
	    ORDER BY SUM(c.amount) DESC
	    """)
	List<TopContributorProjection> findTopContributors();
}
