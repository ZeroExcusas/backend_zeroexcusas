package com.zeroexcusas.zeroexcusas_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zeroexcusas.zeroexcusas_app.model.TrainingPlace;

@Repository
public interface TrainingPlaceRepository extends JpaRepository<TrainingPlace, Integer>{

}
