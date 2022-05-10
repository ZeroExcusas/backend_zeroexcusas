package com.zeroexcusas.zeroexcusas_app.web;

import com.zeroexcusas.zeroexcusas_app.model.Goal;
import com.zeroexcusas.zeroexcusas_app.model.TrainingFocus;
import com.zeroexcusas.zeroexcusas_app.model.TrainingLevel;
import com.zeroexcusas.zeroexcusas_app.service.TrainingLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/traininglevel/")
public class TrainingLevelController {

    @Autowired
    TrainingLevelService trainingLevelService;

    @GetMapping( "/gettrainingfocus" )
    public List<TrainingLevel> list()
    {
        return trainingLevelService.listAllTrainingLevel();
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<TrainingLevel> get(@PathVariable Integer id )
    {
        try
        {
            TrainingLevel trainingLevel = trainingLevelService.getTrainingLevel( id );
            return new ResponseEntity<TrainingLevel>( trainingLevel, HttpStatus.OK );
        }
        catch ( NoSuchElementException e )
        {
            return new ResponseEntity<TrainingLevel>( HttpStatus.NOT_FOUND );
        }
    }

    @RequestMapping( value = "/register", method = RequestMethod.POST )
    public ResponseEntity<?> add(@RequestBody TrainingLevel trainingLevel) throws Exception{
        return ResponseEntity.ok( trainingLevelService.saveTrainingLevel( trainingLevel ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody TrainingLevel trainingLevel, @PathVariable Integer id) {
        try {
            TrainingLevel existTrainingLevel = trainingLevelService.getTrainingLevel( id );
            if ( existTrainingLevel != null )
            {
                existTrainingLevel.setName( trainingLevel.getName() );
                existTrainingLevel.setDescription( trainingLevel.getDescription() );
                trainingLevelService.saveTrainingLevel( existTrainingLevel );
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
            TrainingLevel existTrainingLevel= trainingLevelService.getTrainingLevel( id );
            if ( existTrainingLevel != null )
            {
                trainingLevelService.deleteTrainingLevel( id );
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
