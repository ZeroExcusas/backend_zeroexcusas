package com.zeroexcusas.zeroexcusas_app.repository;

import com.zeroexcusas.zeroexcusas_app.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Integer>
{}
