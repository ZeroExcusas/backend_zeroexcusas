package com.zeroexcusas.zeroexcusas_app.algorithm.alx;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SelectedFoodDTO {
    int index;

    int units;

    double amount;

    SimpleFood simpleFood;
}
