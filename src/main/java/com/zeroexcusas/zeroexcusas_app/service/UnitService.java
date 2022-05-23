package com.zeroexcusas.zeroexcusas_app.service;

import com.zeroexcusas.zeroexcusas_app.model.Unit;
import com.zeroexcusas.zeroexcusas_app.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@Transactional
public class UnitService {

    @Autowired
    UnitRepository unitRepository;

    public List<Unit> getAll() {
        return unitRepository.findAll();
    }




}
