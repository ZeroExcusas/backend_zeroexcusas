package com.zeroexcusas.zeroexcusas_app.algorithm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodsMock {
    String name;
    NutritionPer100g nutrition_per_100g;

}
@Data
@NoArgsConstructor
class NutritionPer100g {
    double fat;
    double protein;
    double carbohydrate;
}