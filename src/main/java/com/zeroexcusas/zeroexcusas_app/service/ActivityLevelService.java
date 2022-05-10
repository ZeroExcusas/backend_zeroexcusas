package com.zeroexcusas.zeroexcusas_app.service;

import com.zeroexcusas.zeroexcusas_app.model.ActivityLevel;
import com.zeroexcusas.zeroexcusas_app.repository.ActivityLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ActivityLevelService
{
    @Autowired
    private ActivityLevelRepository activityLevelRepository;

    public List<ActivityLevel> listAllActivityLevel() {
        return activityLevelRepository.findAll();
    }

    public ActivityLevel saveActivityLevel(ActivityLevel activityLevel) {
        return activityLevelRepository.save( activityLevel );
    }

    public ActivityLevel getActivityLevel(Integer id) {
        return activityLevelRepository.findById(id).orElse(null);
    }

    public void deleteActivityLevel(Integer id) {
        activityLevelRepository.deleteById( id);
    }

}
