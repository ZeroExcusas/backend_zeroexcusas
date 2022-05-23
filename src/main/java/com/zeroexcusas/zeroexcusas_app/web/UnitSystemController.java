package com.zeroexcusas.zeroexcusas_app.web;

import com.zeroexcusas.zeroexcusas_app.model.UnitSystem;
import com.zeroexcusas.zeroexcusas_app.performance.ZEControllerValidator;
import com.zeroexcusas.zeroexcusas_app.service.UnitSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/unitsystem")
public class UnitSystemController {

    @Autowired
    UnitSystemService unitSystemService;



    @PostMapping("/register")
    public ResponseEntity<?> add(@RequestBody @Valid  UnitSystem unitSystem) {
        return ZEControllerValidator.getInstance(unitSystemService).register(unitSystem).buildReponse();
    }
}
