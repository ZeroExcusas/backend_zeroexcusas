package com.zeroexcusas.zeroexcusas_app.algorithm.mckp;



public class MultipleChoiceKnapsackProblem {
    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack(new OneOrNoneFromGroupProblem());
        knapsack.solve();
    }
}
