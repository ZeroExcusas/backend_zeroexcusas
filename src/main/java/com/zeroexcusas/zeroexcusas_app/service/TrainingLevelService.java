package com.zeroexcusas.zeroexcusas_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeroexcusas.zeroexcusas_app.model.TrainingLevel;
import com.zeroexcusas.zeroexcusas_app.repository.TrainingLevelRepository;

@Service
@Transactional
public class TrainingLevelService {
	
	 @Autowired
	    private TrainingLevelRepository trainingLevelRepository;

	    public List<TrainingLevel> listAllTrainingLevel() {
	        return trainingLevelRepository.findAll();
	    }

	    public TrainingLevel saveTrainingLevel(TrainingLevel trainingLevel) {
	        return trainingLevelRepository.save( trainingLevel );
	    }

	    public TrainingLevel getTrainingLevel(Integer id) {
	        return trainingLevelRepository.findById( id).get();
	    }

	    public void deleteTrainingLevel(Integer id) {
	        trainingLevelRepository.deleteById( id);
	    }
	
}
