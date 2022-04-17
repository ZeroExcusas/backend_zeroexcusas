package com.zeroexcusas.zeroexcusas_app.repository;

import com.zeroexcusas.zeroexcusas_app.model.ActivityLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLevelRepository extends JpaRepository<ActivityLevel, Integer>
{}
