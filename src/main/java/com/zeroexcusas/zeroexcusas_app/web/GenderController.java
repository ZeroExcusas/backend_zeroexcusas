package com.zeroexcusas.zeroexcusas_app.web;

import com.zeroexcusas.zeroexcusas_app.model.Gender;
import com.zeroexcusas.zeroexcusas_app.model.Goal;
import com.zeroexcusas.zeroexcusas_app.model.User;
import com.zeroexcusas.zeroexcusas_app.performance.ZEControllerValidator;
import com.zeroexcusas.zeroexcusas_app.performance.ZElapsedTime;
import com.zeroexcusas.zeroexcusas_app.service.GenderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Return a simple gender record")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Return a simple gender record",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not found record",
                    content = @Content)
    })

    @GetMapping( "/{id}" )
    @ZElapsedTime
    public ResponseEntity<?> get( @PathVariable Integer id )
    { /*
        try
        {
            Gender gender = genderService.getGender( id );
            return new ResponseEntity<Gender>( gender, HttpStatus.OK );
        }
        catch ( NoSuchElementException e )
        {
            return new ResponseEntity<Gender>( HttpStatus.NOT_FOUND );
        }*/
        return ZEControllerValidator.getInstance(genderService).getOneRecord(id).buildReponse();

    }

    @RequestMapping( value = "/register", method = RequestMethod.POST )
    @ZElapsedTime
    public ResponseEntity<?> add(@RequestBody Gender gender) throws Exception{
        //genderService.saveGender(gender);
        //return ResponseEntity.ok(genderService.saveGender(gender));
        return ZEControllerValidator.getInstance(genderService).register(gender).buildReponse();
    }

    @GetMapping("/getall")
    public ResponseEntity getAll()  {
        return ZEControllerValidator.getInstance(genderService).getAll().buildReponse();
    }


    @PutMapping("/{id}")
    @ZElapsedTime
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
    @ZElapsedTime
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
