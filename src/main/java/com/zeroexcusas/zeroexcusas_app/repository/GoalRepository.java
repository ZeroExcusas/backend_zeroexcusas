package com.zeroexcusas.zeroexcusas_app.repository;

import com.zeroexcusas.zeroexcusas_app.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Integer>
{}
