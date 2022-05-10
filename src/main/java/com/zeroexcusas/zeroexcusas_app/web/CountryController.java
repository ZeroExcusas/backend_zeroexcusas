package com.zeroexcusas.zeroexcusas_app.web;

import com.zeroexcusas.zeroexcusas_app.exceptions.ApiRequestException;
import com.zeroexcusas.zeroexcusas_app.model.Country;
import com.zeroexcusas.zeroexcusas_app.model.Goal;
import com.zeroexcusas.zeroexcusas_app.service.CountryService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

@Data @NoArgsConstructor
@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping( "/country" )
    public List<Country> list()
    {
        return countryService.listAllCountries();
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Country> get( @PathVariable Integer id ) {
        try {
            Country country = countryService.getCountry( id );
            return new ResponseEntity<Country>( country, HttpStatus.OK );
        }
        catch ( NoSuchElementException e ) {
            return new ResponseEntity<Country>( HttpStatus.NOT_FOUND );
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Country> add(@RequestBody Country country) {
        //Country c = new Country();
        //return new ResponseEntity<>(c, HttpStatus.OK);
        throw new ApiRequestException("message.exception");
       // return ResponseEntity.ok( countryService.saveCountry( country ));
    }


}
