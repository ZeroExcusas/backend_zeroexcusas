package com.zeroexcusas.zeroexcusas_app.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeroexcusas.zeroexcusas_app.model.TrainingPlace;
import com.zeroexcusas.zeroexcusas_app.repository.TrainingPlaceRepository;


@Service
@Transactional
public class TrainingPlaceService {
	
	@Autowired 
	private TrainingPlaceRepository trainingPlaceRepository;
	
	public List<TrainingPlace> listAllTrainingPlace(){
		return trainingPlaceRepository.findAll();
	}
	
	public TrainingPlace saveTrainingPlace(TrainingPlace trainingPlace) {
        return trainingPlaceRepository.save( trainingPlace );
    }

    public TrainingPlace getTrainingPlace(Integer id) {
        return trainingPlaceRepository.findById(id).get();
    }

    public void deleteTrainingPlace(Integer id) {
    	trainingPlaceRepository.deleteById( id);
    }
}
