package com.zeroexcusas.zeroexcusas_app.algorithm;


import java.util.ArrayList;
import java.util.List;

public class MealFinder {

    // Foods of our problem
    private FoodItem[] foodItems;
    // capacity of the Meal
    private int mealCapacity;

    public MealFinder(FoodItem[] foodItems, int mealCapacity) {
        this.foodItems = foodItems;
        this.mealCapacity = mealCapacity;
    }

    public void display() {
        if (foodItems != null  &&  foodItems.length > 0) {
            System.out.println("MealFinder problem");
            System.out.println("Capacity : " + mealCapacity);
            System.out.println("Foods :");

            for (FoodItem item : foodItems) {
                System.out.println("- " + item.toString());
            }
        }
    }

    // we write the solve algorithm
    public ReadyMeal solve() {
        int NB_ITEMS = foodItems.length;
        // we use a matrix to store the max value at each n-th foodItem
        int[][] matrix = new int[NB_ITEMS + 1][mealCapacity + 1];

        // first line is initialized to 0
        for (int i = 0; i <= mealCapacity; i++)
            matrix[0][i] = 0;

        // we iterate on items
        for (int i = 1; i <= NB_ITEMS; i++) {
            // we iterate on each capacity
            for (int j = 0; j <= mealCapacity; j++) {
                if (foodItems[i - 1].weight > j)
                    matrix[i][j] = matrix[i-1][j];
                else
                    // we maximize value at this rank in the matrix
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i-1][j - foodItems[i-1].weight]
                            + foodItems[i-1].value);
            }
        }

        int res = matrix[NB_ITEMS][mealCapacity];
        int w = mealCapacity;
        List<FoodItem> itemsSolution = new ArrayList<>();

        for (int i = NB_ITEMS; i > 0  &&  res > 0; i--) {
            if (res != matrix[i-1][w]) {
                itemsSolution.add(foodItems[i-1]);
                // we remove items value and weight
                res -= foodItems[i-1].value;
                w -= foodItems[i-1].weight;
            }
        }

        return new ReadyMeal(itemsSolution, matrix[NB_ITEMS][mealCapacity]);
    }

    public static void main(String[] args) {
        // we take the same instance of the problem displayed in the image
        FoodItem[] items = {new FoodItem("Aguacate", 4, 12),
                new FoodItem("Pechuga", 2, 1),
                new FoodItem("Cerdo", 2, 2),
                new FoodItem("Lechuga", 1, 1),
                new FoodItem("Huevos", 10, 4)};

        MealFinder mealFinder = new MealFinder(items, 15);
        mealFinder.display();

        ReadyMeal readyMeal = mealFinder.solve();
        readyMeal.display();
    }
}