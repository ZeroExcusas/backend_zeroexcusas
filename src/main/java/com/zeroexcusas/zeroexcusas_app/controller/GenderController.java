package com.zeroexcusas.zeroexcusas_app.controller;

import com.zeroexcusas.zeroexcusas_app.common.ZEStrings;
import com.zeroexcusas.zeroexcusas_app.model.Gender;
import com.zeroexcusas.zeroexcusas_app.model.Goal;
import com.zeroexcusas.zeroexcusas_app.performance.ZEControllerValidator;
import com.zeroexcusas.zeroexcusas_app.performance.ZElapsedTime;
import com.zeroexcusas.zeroexcusas_app.service.GenderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/gender")
@Tag(name="Gender / Genero",description = "Gestiona los registros de genero en la base de datos")
public class GenderController
{
    @Autowired
    GenderService genderService;

    @GetMapping( "/{id}" )
    @Operation(summary = ZEStrings.MESSAGE_GET_SIMPLE)
    @ZElapsedTime
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
       // return ZEControllerValidator.getInstance(genderService).getOneRecord(id).buildReponse();

    }

    @PostMapping
    @Operation(summary = ZEStrings.MESSAGE_POST) // Add / Register
    public ResponseEntity<Gender> add(@RequestBody @Valid Gender gender) throws Exception{
        //Gender stored = genderService.saveGender(gender);

        return ResponseEntity.ok(genderService.saveGender(gender));

        //return ZEControllerValidator.getInstance(genderService).register(gender).buildReponse();
    }

    @GetMapping
    @Operation(summary = ZEStrings.MESSAGE_GET_ALL)
    public ResponseEntity getAll()  {
        return ZEControllerValidator.getInstance(genderService).getAll().buildReponse();
    }


    @PutMapping("/{id}")
    @ZElapsedTime
    @Operation(summary = ZEStrings.MESSAGE_PUT)
    public ResponseEntity<Gender> update(@RequestBody Gender gender, @PathVariable Integer id) {
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
    @ZElapsedTime
    @Operation(summary = ZEStrings.MESSAGE_DELETE)
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