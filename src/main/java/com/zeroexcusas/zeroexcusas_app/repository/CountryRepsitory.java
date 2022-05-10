package com.zeroexcusas.zeroexcusas_app.repository;

import com.zeroexcusas.zeroexcusas_app.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepsitory extends JpaRepository<Country, Integer>
{}
