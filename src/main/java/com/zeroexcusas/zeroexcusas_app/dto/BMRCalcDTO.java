package com.zeroexcusas.zeroexcusas_app.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BMRCalcDTO extends BMICalcDTO {

    private int age;
    private boolean male;
}
