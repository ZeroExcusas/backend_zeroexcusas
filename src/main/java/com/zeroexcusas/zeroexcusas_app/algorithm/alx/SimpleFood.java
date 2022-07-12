package com.zeroexcusas.zeroexcusas_app.algorithm.alx;

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
