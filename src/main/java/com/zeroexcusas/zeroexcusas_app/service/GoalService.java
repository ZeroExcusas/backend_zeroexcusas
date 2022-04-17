package com.zeroexcusas.zeroexcusas_app.service;

import com.zeroexcusas.zeroexcusas_app.model.Goal;
import com.zeroexcusas.zeroexcusas_app.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GoalService
{
    @Autowired
    private GoalRepository goalRepository;

    public List<Goal> listAllGoal() {
        return goalRepository.findAll();
    }

    public Goal saveGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    public Goal getGoal(Integer id) {
        return goalRepository.findById( id).get();
    }

    public void deleteGoal(Integer id) {
        goalRepository.deleteById( id);
    }

}
