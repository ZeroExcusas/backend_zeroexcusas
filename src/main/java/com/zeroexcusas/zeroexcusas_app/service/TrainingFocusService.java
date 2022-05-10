package com.zeroexcusas.zeroexcusas_app.service;

import com.zeroexcusas.zeroexcusas_app.model.TrainingFocus;
import com.zeroexcusas.zeroexcusas_app.repository.TrainingFocusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TrainingFocusService
{
    @Autowired
    private TrainingFocusRepository trainingFocusRepository;

    public List<TrainingFocus> listAllTrainingFocus() {
        return trainingFocusRepository.findAll();
    }

    public TrainingFocus saveTrainingFocus(TrainingFocus trainingFocus) {
        return trainingFocusRepository.save( trainingFocus );
    }

    public TrainingFocus getTrainingFocus(Integer id) {
        return trainingFocusRepository.findById(id).get();
    }

    public void deleteTrainingFocus(Integer id) {
        trainingFocusRepository.deleteById( id);
    }

}
