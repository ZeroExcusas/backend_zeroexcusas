package com.zeroexcusas.zeroexcusas_app.algorithm.service;

import com.zeroexcusas.zeroexcusas_app.algorithm.AlexaAlgorithm;
import com.zeroexcusas.zeroexcusas_app.algorithm.dto.SuggestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlgorithmService {

    @Autowired
    AlexaAlgorithm alexaAlgorithm;

    public SuggestResponse getSuggest(int prviousFoodIndex) {

        // Se cargan datos de prueba
        alexaAlgorithm.loadFoodsFromMocks();

        int nutProt = 35;
        int nutCarb = 35;
        int nutFat = 12;
        int numInterationsMax =  1000;
        int errorUmbral = 9;
        int porcProtMin = 5;
        int porcCarbMin = 5;
        int porcFatMin = 5;

        return alexaAlgorithm.suggestedFoods(nutProt, nutCarb,
                nutFat, numInterationsMax, errorUmbral,
                porcProtMin, porcCarbMin, porcFatMin);

    }
}
