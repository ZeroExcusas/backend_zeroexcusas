package com.zeroexcusas.zeroexcusas_app.algorithm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleFood {

    String name;

    int unit;

    double carbsPerUnit;

    double fatPerUnit;

    double proteinPerUnit;

    String category;

    public double getNutrient(FoodType foodType) {

        double result = 0;
        switch (foodType) {
            case CARB:
                result = carbsPerUnit;
                break;
            case PROTEIN:
                result = proteinPerUnit;
                break;
            case FAT:
                result = fatPerUnit;
                break;
        }
        return result;
    }

    public FoodType getMainType() {
        FoodType type = null;
        if (proteinPerUnit > carbsPerUnit) {
            if (proteinPerUnit > fatPerUnit) {
                type = FoodType.PROTEIN;
            }
            else {
                type = FoodType.FAT;
            }
        }
        else {
            if (carbsPerUnit > fatPerUnit) {
                type = FoodType.CARB;
            }
            else {
                type = FoodType.FAT;
            }
        }
        return type;
    }

    public int getReferenceUnit() {
        return unit == 0 ? 100 : 1;
    }

    FoodType type;

    @Override
    public String toString() {
        return "SimpleFood{" +
                "unit='" + unit + '\'' +
                ", carbsPerUnit=" + carbsPerUnit +
                ", fatPerUnit=" + fatPerUnit +
                ", proteinPerUnit=" + proteinPerUnit +
                ", type=" + type +
                '}';
    }
}
