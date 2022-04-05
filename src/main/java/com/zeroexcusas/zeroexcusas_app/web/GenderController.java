package com.zeroexcusas.zeroexcusas_app.web;

import com.zeroexcusas.zeroexcusas_app.model.Gender;
import com.zeroexcusas.zeroexcusas_app.model.Goal;
import com.zeroexcusas.zeroexcusas_app.model.User;
import com.zeroexcusas.zeroexcusas_app.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/gender")
public class GenderController
{
    @Autowired
    GenderService genderService;

    @GetMapping( "" )
    public List<Gender> list()
    {
        return genderService.listAllGender();
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Gender> get( @PathVariable Integer id )
    {
        try
        {
            Gender gender = genderService.getGender( id );
            return new ResponseEntity<Gender>( gender, HttpStatus.OK );
        }
        catch ( NoSuchElementException e )
        {
            return new ResponseEntity<Gender>( HttpStatus.NOT_FOUND );
        }
    }

    @RequestMapping( value = "/register", method = RequestMethod.POST )
    public ResponseEntity<?> add(@RequestBody Gender gender) throws Exception{
        //genderService.saveGender(gender);
        return ResponseEntity.ok(genderService.saveGender(gender));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Gender gender, @PathVariable Integer id) {
        try {
            Gender existGender = genderService.getGender(id);
            if ( existGender != null )
            {
                existGender.setName( gender.getName() );
                genderService.saveGender( existGender );
                return new ResponseEntity<>( HttpStatus.OK );
            }
            else
            {
                return new ResponseEntity<Gender>( HttpStatus.NOT_FOUND );
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Gender existGender = genderService.getGender(id);
            if ( existGender != null )
            {
                genderService.deleteGender( id );
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
