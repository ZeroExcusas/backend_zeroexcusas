package com.zeroexcusas.zeroexcusas_app.common;

public class Global {
    public static String locale = "ES";


    public static  final double K_ft_m = 0.304;

    public static  final double K_ft_cm = 30.48
            ;
    public static  final double K_cm_m  = 0.01;

    public static  final double K_m_cm = 100;

    public static  final double K_lbs_kg = 0.453;

    public static  final double K_fast_loss = 27.59;

    public static final double K_fast_keeping = 34.22;

    public static final double K_fast_gain = 40.28;

    public static final double K_bmi_limit_underweight = 18.5;

    public static final double K_bmi_min_limit_healthy = 18.5;

    public static final double K_bmi_max_limit_healthy = 24.9;

    public static final double K_bmi_min_limit_overweight = 25;

    public static final double K_bmi_max_limit_overweight = 29.9;

    public static final double K_bmi_limit_obesity = 30;

    /**
     * Calcula las calorias rapidas
     * @param weight
     * @return
     */
    public static double fastCalories(double weight) {
        return (double) K_fast_loss * weight;
    }

   public static double fastCaloriesForMantaining() {
        return 0d;
   }














}
