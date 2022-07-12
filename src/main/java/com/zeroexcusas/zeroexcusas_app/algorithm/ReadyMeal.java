package com.zeroexcusas.zeroexcusas_app.algorithm;

import java.util.List;

public class ReadyMeal {

    // list of items to put in the bag to have the maximal value
    public List<FoodItem> foods;
    // maximal value possible
    public int value;

    public ReadyMeal(List<FoodItem> foods, int value) {
        this.foods = foods;
        this.value = value;
    }

    public void display() {
        if (foods != null  &&  !foods.isEmpty()){
            System.out.println("\nMealFinder solution");
            System.out.println("Value = " + value);
            System.out.println("Food to pick :");

            for (FoodItem food : foods) {
                System.out.println("- " + food.toString());
            }
        }
    }
}
