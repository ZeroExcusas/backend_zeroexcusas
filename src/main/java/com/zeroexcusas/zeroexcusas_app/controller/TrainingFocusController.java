package com.zeroexcusas.zeroexcusas_app.controller;

import com.zeroexcusas.zeroexcusas_app.model.Goal;
import com.zeroexcusas.zeroexcusas_app.model.TrainingFocus;
import com.zeroexcusas.zeroexcusas_app.service.TrainingFocusService;
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

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/trainingfocus")
public class TrainingFocusController
{
    @Autowired
    TrainingFocusService trainingFocusService;

    @GetMapping( "/gettrainingfocus" )
    public List<TrainingFocus> list()
    {
        return trainingFocusService.listAllTrainingFocus();
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<TrainingFocus> get( @PathVariable Integer id )
    {
        try
        {
            TrainingFocus trainingFocus = trainingFocusService.getTrainingFocus( id );
            return new ResponseEntity<TrainingFocus>( trainingFocus, HttpStatus.OK );
        }
        catch ( NoSuchElementException e )
        {
            return new ResponseEntity<TrainingFocus>( HttpStatus.NOT_FOUND );
        }
    }

    @RequestMapping( value = "/register", method = RequestMethod.POST )
    public ResponseEntity<?> add(@RequestBody TrainingFocus trainingFocus) throws Exception{
        return ResponseEntity.ok( trainingFocusService.saveTrainingFocus( trainingFocus ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody TrainingFocus trainingFocus, @PathVariable Integer id) {
        try {
            TrainingFocus existTrainingFocus = trainingFocusService.getTrainingFocus( id );
            if ( existTrainingFocus != null )
            {
                existTrainingFocus.setName( trainingFocus.getName() );
                existTrainingFocus.setDescription( trainingFocus.getDescription() );
                trainingFocusService.saveTrainingFocus( existTrainingFocus );
                return new ResponseEntity<>( HttpStatus.OK );
            }
            else
            {
                return new ResponseEntity<TrainingFocus>( HttpStatus.NOT_FOUND );
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            TrainingFocus existTrainingFocus = trainingFocusService.getTrainingFocus( id );
            if ( existTrainingFocus != null )
            {
                trainingFocusService.deleteTrainingFocus( id );
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
