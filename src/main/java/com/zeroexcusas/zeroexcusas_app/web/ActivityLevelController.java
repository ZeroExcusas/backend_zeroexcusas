package com.zeroexcusas.zeroexcusas_app.web;

import com.zeroexcusas.zeroexcusas_app.common.ZEStrings;
import com.zeroexcusas.zeroexcusas_app.model.ActivityLevel;
import com.zeroexcusas.zeroexcusas_app.model.Goal;
import com.zeroexcusas.zeroexcusas_app.model.TrainingFocus;
import com.zeroexcusas.zeroexcusas_app.service.ActivityLevelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@Tag(name="ActivityLevel / Nivel de Actividad",description = "Nivel de Actividad")
@RequestMapping("/activitylevel")
public class ActivityLevelController  {
    @Autowired
    ActivityLevelService activityLevelService;

    @GetMapping
    @Operation(summary = ZEStrings.MESSAGE_GET_ALL)
    public List<ActivityLevel> list()
    {
        return activityLevelService.listAllActivityLevel();
    }

    @GetMapping( "/{id}" )
    @Operation(summary = ZEStrings.MESSAGE_GET_SIMPLE)
    public ResponseEntity<ActivityLevel> get( @PathVariable Integer id )
    {
        try
        {
            ActivityLevel activityLevel = activityLevelService.getActivityLevel( id );
            return new ResponseEntity<ActivityLevel>( activityLevel, HttpStatus.OK );
        }
        catch ( NoSuchElementException e )
        {
            return new ResponseEntity<ActivityLevel>( HttpStatus.NOT_FOUND );
        }
    }

    //@RequestMapping( value = "/register", method = RequestMethod.POST )

    @PostMapping
    @Operation(summary = ZEStrings.MESSAGE_POST)
    public ResponseEntity<?> add(@RequestBody ActivityLevel activityLevel) throws Exception{
        return ResponseEntity.ok( activityLevelService.saveActivityLevel( activityLevel ));
    }

    @PutMapping("/{id}")
    @Operation(summary = ZEStrings.MESSAGE_PUT)
    public ResponseEntity<?> update(@RequestBody ActivityLevel activityLevel, @PathVariable Integer id) {
        try {
            ActivityLevel existActivityLevel = activityLevelService.getActivityLevel( id );
            if ( existActivityLevel != null )
            {
                existActivityLevel.setName( activityLevel.getName() );
                existActivityLevel.setDescription( activityLevel.getDescription() );
                activityLevelService.saveActivityLevel( existActivityLevel );
                return new ResponseEntity<>( HttpStatus.OK );
            }
            else
            {
                return new ResponseEntity<ActivityLevel>( HttpStatus.NOT_FOUND );
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = ZEStrings.MESSAGE_DELETE)
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            ActivityLevel existActivityLevel = activityLevelService.getActivityLevel( id );
            if ( existActivityLevel != null ) {
                activityLevelService.deleteActivityLevel( id );
                return new ResponseEntity<>( HttpStatus.OK );
            }
            else
            {
                return new ResponseEntity<ActivityLevel>( HttpStatus.NOT_FOUND );
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}