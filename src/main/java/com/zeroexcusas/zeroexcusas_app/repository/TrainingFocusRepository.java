package com.zeroexcusas.zeroexcusas_app.repository;

import com.zeroexcusas.zeroexcusas_app.model.TrainingFocus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingFocusRepository extends JpaRepository<TrainingFocus, Integer>
{}
