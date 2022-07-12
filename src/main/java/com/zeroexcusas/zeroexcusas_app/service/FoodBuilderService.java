package com.zeroexcusas.zeroexcusas_app.service;

import com.zeroexcusas.zeroexcusas_app.repository.GoalRepository;
import com.zeroexcusas.zeroexcusas_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FoodBuilderService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    GoalRepository goalRepository;


}
