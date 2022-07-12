package com.zeroexcusas.zeroexcusas_app.algorithm;

import com.zeroexcusas.zeroexcusas_app.model.User;
import com.zeroexcusas.zeroexcusas_app.service.FoodBuilderService;

import java.io.InputStream;

public class OldMealFinder {

    InputStream csvInputStream = getClass().getClassLoader().getResourceAsStream("food_nutrition.csv");

    int numIterations;
    int epsilon;

    double KProt;
    double KCarb;
    double KFat;
    int uProt = 1;
    int uCarb = 1;
    int uFat = 1;

    int maxErr = 100;
    int numIter = 10;

    FoodBuilderService foodBuilderService = new FoodBuilderService();

    private void initCSVFile() {
       // Reader reader = new FileReader(csvInputStream);
    }


    public void getCombination(User user) {

    }

    public void getSuggestedCombination(double nutPro, double nutCarb, double nutFat, int numIterations, int epsilon) {

        while((maxErr > epsilon) && (numIter <numIterations)) {
            
        }
    }
}