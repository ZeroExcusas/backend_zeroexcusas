package com.zeroexcusas.zeroexcusas_app.controller;

import com.zeroexcusas.zeroexcusas_app.common.ZEStrings;
import com.zeroexcusas.zeroexcusas_app.model.Goal;
import com.zeroexcusas.zeroexcusas_app.model.TrainingFocus;
import com.zeroexcusas.zeroexcusas_app.model.TrainingLevel;
import com.zeroexcusas.zeroexcusas_app.service.TrainingLevelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/traininglevel/")
@Tag(name = "Training Level / Nivel de Entrenamiento", description = "Descripcion del nivel de entrenamiento del usuario")
public class TrainingLevelController {

    @Autowired
    TrainingLevelService trainingLevelService;

    @GetMapping
    @Operation(summary = ZEStrings.MESSAGE_GET_ALL)
    public List<TrainingLevel> list()
    {
        return trainingLevelService.listAllTrainingLevel();
    }

    @GetMapping( "/{id}" )
    @Operation(summary = ZEStrings.MESSAGE_GET_SIMPLE)
    public ResponseEntity<TrainingLevel> get(@PathVariable Integer id ) {
        try  {
            TrainingLevel trainingLevel = trainingLevelService.getTrainingLevel( id );
            return new ResponseEntity<TrainingLevel>( trainingLevel, HttpStatus.OK );
        }
        catch ( NoSuchElementException e ) {
            return new ResponseEntity<TrainingLevel>( HttpStatus.NOT_FOUND );
        }
    }

    @PostMapping
    @Operation(summary = ZEStrings.MESSAGE_POST)
    public ResponseEntity<?> add(@RequestBody TrainingLevel trainingLevel) throws Exception{
        return ResponseEntity.ok( trainingLevelService.saveTrainingLevel( trainingLevel ));
    }

    @PutMapping("/{id}")
    @Operation(summary = ZEStrings.MESSAGE_PUT)
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
    @Operation(summary = ZEStrings.MESSAGE_DELETE)
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