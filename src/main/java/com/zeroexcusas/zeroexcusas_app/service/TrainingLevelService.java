package com.zeroexcusas.zeroexcusas_app.service;

import com.zeroexcusas.zeroexcusas_app.model.TrainingFocus;
import com.zeroexcusas.zeroexcusas_app.model.TrainingLevel;
import com.zeroexcusas.zeroexcusas_app.repository.TrainingLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TrainingLevelService {

    @Autowired
    TrainingLevelRepository trainingLevelRepository;

    public void deleteTrainingLevel(Integer id) {
        trainingLevelRepository.deleteById(id);
    }

    public TrainingLevel getTrainingLevel(Integer id) {
        TrainingLevel trainingLevel = trainingLevelRepository.findById(id).orElse(null);
        return trainingLevel;
    }

    public TrainingLevel saveTrainingLevel(TrainingLevel trainingLevel) {
        return trainingLevelRepository.save(trainingLevel);
    }


    public List<TrainingLevel> listAllTrainingLevel() {
        return (List<TrainingLevel>) trainingLevelRepository.findAll();
    }
}
