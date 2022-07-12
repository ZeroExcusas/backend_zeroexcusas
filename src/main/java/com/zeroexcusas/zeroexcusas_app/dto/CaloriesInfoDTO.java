package com.zeroexcusas.zeroexcusas_app.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CaloriesInfoDTO {

    private double caloriesForMaintenance;

    private double caloriesForLoss;

    private double caloriesForGain;
}
