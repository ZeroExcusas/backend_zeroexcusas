package com.zeroexcusas.zeroexcusas_app.web;

import com.zeroexcusas.zeroexcusas_app.model.Goal;
import com.zeroexcusas.zeroexcusas_app.service.GoalService;
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
@RequestMapping("/goal")
public class GoalController
{
    @Autowired
    GoalService goalService;

    @GetMapping( "/goals" )
    public List<Goal> list()
    {
        return goalService.listAllGoal();
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Goal> get( @PathVariable Integer id )
    {
        try
        {
            Goal goal = goalService.getGoal( id );
            return new ResponseEntity<Goal>( goal, HttpStatus.OK );
        }
        catch ( NoSuchElementException e )
        {
            return new ResponseEntity<Goal>( HttpStatus.NOT_FOUND );
        }
    }

    @RequestMapping( value = "/register", method = RequestMethod.POST )
    public ResponseEntity<?> add(@RequestBody Goal goal) throws Exception{
        return ResponseEntity.ok( goalService.saveGoal( goal ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Goal goal, @PathVariable Integer id) {
        try {
            Goal existGoal = goalService.getGoal( id );
            if ( existGoal != null ) //  en el caso de que si exista
            {
                existGoal.setName( goal.getName() );
                existGoal.setDescription( goal.getDescription() );
                goalService.saveGoal( existGoal );
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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Goal existGoal = goalService.getGoal( id );
            if ( existGoal != null )
            {
                goalService.deleteGoal( id );
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
