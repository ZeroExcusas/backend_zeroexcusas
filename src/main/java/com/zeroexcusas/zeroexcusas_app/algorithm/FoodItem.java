package com.zeroexcusas.zeroexcusas_app.algorithm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItem {

    public String name;
    public int value;
    public int weight;


    @Override
    public String toString() {
        return "FoodItem{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", weight=" + weight +
                '}';
    }
}