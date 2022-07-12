package com.zeroexcusas.zeroexcusas_app.controller;

import com.zeroexcusas.zeroexcusas_app.common.ZEStrings;
import com.zeroexcusas.zeroexcusas_app.exceptions.ApiRequestException;
import com.zeroexcusas.zeroexcusas_app.model.Country;
import com.zeroexcusas.zeroexcusas_app.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Data @NoArgsConstructor
@RestController

@RequestMapping("/country")
@Tag(name = "Country / Pais", description = "Gestiona los registro relacinoados con la adicion de Paises a la base de datos")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping
    @Operation(summary = ZEStrings.MESSAGE_GET_ALL)
    public List<Country> list()
    {
        return countryService.listAllCountries();
    }

    @GetMapping( "/{id}" )
    @Operation(summary = ZEStrings.MESSAGE_GET_SIMPLE)
    public ResponseEntity<Country> get( @PathVariable Integer id ) {
        try {
            Country country = countryService.getCountry( id );
            return new ResponseEntity<Country>( country, HttpStatus.OK );
        }
        catch ( NoSuchElementException e ) {
            return new ResponseEntity<Country>( HttpStatus.NOT_FOUND );
        }
    }

    @PostMapping
    @Operation(summary = ZEStrings.MESSAGE_POST)
    public ResponseEntity<Country> add(@RequestBody Country country) {
        //Country c = new Country();
        //return new ResponseEntity<>(c, HttpStatus.OK);
        throw new ApiRequestException("message.exception");
       // return ResponseEntity.ok( countryService.saveCountry( country ));
    }


}
