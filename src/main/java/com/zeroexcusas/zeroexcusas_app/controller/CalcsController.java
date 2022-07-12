package com.zeroexcusas.zeroexcusas_app.controller;

import com.zeroexcusas.zeroexcusas_app.common.Equations;
import com.zeroexcusas.zeroexcusas_app.common.ZEStrings;
import com.zeroexcusas.zeroexcusas_app.dto.BMIDTO;
import com.zeroexcusas.zeroexcusas_app.dto.CaloriesInfoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/calcs")
@Tag(name = "Calcs / Calculos", description = "Operaciones de calculos asociados a un peso en particular")
public class CalcsController {

    @Operation(summary = ZEStrings.DESC_CALORIES)
    @GetMapping("calories/{weight}")
    public ResponseEntity<CaloriesInfoDTO> getLoss(@PathVariable double weight)  {
        return new ResponseEntity<>(Equations.getCaloriesForGoal(weight), HttpStatus.OK);
    }

    @Operation(summary = ZEStrings.DESC_BMI)
    @GetMapping("bmr/{weight}/{height}/{age}")
    public ResponseEntity<BMIDTO> getBMI(@PathVariable(name = "weight") double weight,
                                          @PathVariable(name = "height") double height,
                                          @PathVariable(name = "age") int age )  {
        BMIDTO bmiData = new BMIDTO();
        bmiData.setBmi(Equations.getBMICalc(weight, height));
        return new ResponseEntity<>(bmiData, HttpStatus.OK);
    }

    @Operation(summary = "Prueba de calculo de perdida de calorias")
    @GetMapping("prueba/{peso}")
    public ResponseEntity<?> calcularCaloria(@PathVariable("peso") double peso) {
        return new ResponseEntity<>(Equations.getFastCaloriesCalcForFatLoss(peso), HttpStatus.OK);

    }

}