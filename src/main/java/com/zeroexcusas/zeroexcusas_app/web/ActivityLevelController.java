package com.zeroexcusas.zeroexcusas_app.web;

import com.zeroexcusas.zeroexcusas_app.model.ActivityLevel;
import com.zeroexcusas.zeroexcusas_app.model.Goal;
import com.zeroexcusas.zeroexcusas_app.model.TrainingFocus;
import com.zeroexcusas.zeroexcusas_app.service.ActivityLevelService;
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
@RequestMapping("/activitylevel")
public class ActivityLevelController
{
    @Autowired
    ActivityLevelService activityLevelService;

    @GetMapping( "/getactivitylevel" )
    public List<ActivityLevel> list()
    {
        return activityLevelService.listAllActivityLevel();
    }

    @GetMapping( "/{id}" )
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

    @RequestMapping( value = "/register", method = RequestMethod.POST )
    public ResponseEntity<?> add(@RequestBody ActivityLevel activityLevel) throws Exception{
        return ResponseEntity.ok( activityLevelService.saveActivityLevel( activityLevel ));
    }

    @PutMapping("/{id}")
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
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            ActivityLevel existActivityLevel = activityLevelService.getActivityLevel( id );
            if ( existActivityLevel != null )
            {
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
