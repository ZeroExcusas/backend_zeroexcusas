package com.zeroexcusas.zeroexcusas_app.algorithm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class FoodCombinationDTO {

    /**
     * Cantidad de alimentos requeridos
     */
    int req;

    /**
     * Indices se alimentos seleccionados
     */
    int[] foodsIndex;

    /**
     * Porciones de Alimentos seleccionados
     */
    double[] amounts;
}
