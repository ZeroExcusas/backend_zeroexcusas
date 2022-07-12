package com.zeroexcusas.zeroexcusas_app.controller;

import com.zeroexcusas.zeroexcusas_app.algorithm.AlexaAlgorithm;
import com.zeroexcusas.zeroexcusas_app.algorithm.dto.SuggestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alg")
public class AlgorithmController {

    @PostMapping("/get-suggest")
    public ResponseEntity<SuggestResponse> getFoodSuggest() {
        SuggestResponse response = new SuggestResponse();

        AlexaAlgorithm alexaAlgorithm = new AlexaAlgorithm();

        alexaAlgorithm.loadFoodsFromMocks(); // Data de prueba




        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
