package com.zeroexcusas.zeroexcusas_app.web;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zeroexcusas.zeroexcusas_app.model.Goal;
import com.zeroexcusas.zeroexcusas_app.model.TrainingPlace;
import com.zeroexcusas.zeroexcusas_app.service.TrainingPlaceService;

@RestController
@RequestMapping("/trainingplace")
public class TrainingPlaceController {
	
	@Autowired
	TrainingPlaceService trainingPlaceService;
	
	@GetMapping("/gettrainingplace")
	public List<TrainingPlace> list()
    {
        return trainingPlaceService.listAllTrainingPlace();
    }
	
	@GetMapping( "/{id}" )
    public ResponseEntity<TrainingPlace> get( @PathVariable Integer id )
    {
        try
        {
            TrainingPlace trainingPlace = trainingPlaceService.getTrainingPlace( id );
            return new ResponseEntity<TrainingPlace>( trainingPlace, HttpStatus.OK );
        }
        catch ( NoSuchElementException e )
        {
            return new ResponseEntity<TrainingPlace>( HttpStatus.NOT_FOUND );
        }
    }
	
	@RequestMapping( value = "/register", method = RequestMethod.POST )
    public ResponseEntity<?> add(@RequestBody TrainingPlace trainingPlace) throws Exception{
        return ResponseEntity.ok( trainingPlaceService.saveTrainingPlace( trainingPlace ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody TrainingPlace trainingPlace, @PathVariable Integer id) {
        try {
            TrainingPlace existTrainingPlace = trainingPlaceService.getTrainingPlace( id );
            if ( existTrainingPlace != null )
            {
                existTrainingPlace.setName( trainingPlace.getName() );
                existTrainingPlace.setDescription( trainingPlace.getDescription() );
                trainingPlaceService.saveTrainingPlace( existTrainingPlace );
                return new ResponseEntity<>( HttpStatus.OK );
            }
            else
            {
                return new ResponseEntity<TrainingPlace>( HttpStatus.NOT_FOUND );
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            TrainingPlace existTrainingPlace = trainingPlaceService.getTrainingPlace( id );
            if ( existTrainingPlace != null )
            {
                trainingPlaceService.deleteTrainingPlace( id );
                return new ResponseEntity<>( HttpStatus.OK );
            }
            else
            {
                return new ResponseEntity<Goal>( HttpStatus.NOT_FOUND );
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
