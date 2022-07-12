package com.zeroexcusas.zeroexcusas_app.controller;

import com.zeroexcusas.zeroexcusas_app.model.Unit;
import com.zeroexcusas.zeroexcusas_app.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/unit")
public class UnitController {

    @Autowired
    UnitService unitService;

    @GetMapping("/list")
    public ResponseEntity<List<Unit>> getAll() {
        List<Unit> response = unitService.getAll();
        return unitService.getAll().isEmpty() ? new ResponseEntity<>( HttpStatus.NOT_FOUND ) : new ResponseEntity<List<Unit>>(response, HttpStatus.OK);
    }

}
