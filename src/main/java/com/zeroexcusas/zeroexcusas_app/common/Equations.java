package com.zeroexcusas.zeroexcusas_app.common;

import com.zeroexcusas.zeroexcusas_app.dto.BMRCalcDTO;
import com.zeroexcusas.zeroexcusas_app.dto.CaloriesInfoDTO;


public class Equations {
    public static String locale = "ES";


    public static final double K_ft_m = 0.304;

    public static final double K_ft_cm = 30.48
            ;
    public static final double K_cm_m  = 0.01;

    public static final double K_m_cm = 100;

    public static  final double K_lbs_kg = 0.453;

    public static  final double K_fast_loss = 27.59;

    public static final double K_fast_maintenance = 34.22;

    public static final double K_fast_gain = 40.28;

    public static final double K_bmi_limit_underweight = 18.5;

    public static final double K_bmi_min_limit_healthy = 18.5;

    public static final double K_bmi_max_limit_healthy = 24.9;

    public static final double K_bmi_min_limit_overweight = 25;

    public static final double K_bmi_max_limit_overweight = 29.9;

    public static final double K_bmi_limit_obesity = 30;

    /**
     * Cantante para un nivel de actividad sendetaria
     */
    public static final double K_activity_sedentary = 1.2;

    public static final double K_activity_almost_active = 1.375;

    public static final double K_activity_active = 1.55;

    public static final double K_activity_very_active = 1.725;

    /**
     * Limite inferior de perdida de grada
     */
    public static final double K_fat_loss_min_limit = -100;

    /**
     * Limite superior de perdida de grasa
     */
    public static final double K_fat_loss_max_limit = -500;


    public static final int K_bmf_factor_men = 5;

    public static final int K_bmf_factor_women = -161;
















    /**
     * Caclulo de calorias rapidas para la perdida de grasa
     * @param weight
     * @return
     */
    public static double getFastCaloriesCalcForFatLoss(double weight) {
        return (double) K_fast_loss * weight;
    }

    /**
     * Calculo de calorias rapidas para el mantenimiento muscular
     * @param weight
     * @return
     */
   public static double getFastCaloriesCalcForMaintenance(double weight) {
        return K_fast_maintenance * weight;
   }


   public static double getFatsCaloriesCalcForGain(double weight) {
       return K_fast_gain * weight;
   }

   public static CaloriesInfoDTO getCaloriesForGoal(double userWeight) {


       CaloriesInfoDTO calories = new CaloriesInfoDTO();
       calories.setCaloriesForLoss(getFastCaloriesCalcForFatLoss(userWeight));
       //calories.setCaloriesForMaintenance(getFastCaloriesCalcForMaintenance(userWeight));
        //calories.setCaloriesForGain(getFatsCaloriesCalcForGain(userWeight));
       return calories;
   }

    /**
     * Calculo del BMI basado en la el peso y altura de una persona
     * @param weight
     * @param height
     * @return
     */
   public static double getBMICalc(double weight, double height) {
       return (weight / (Math.pow(height, 2)));
   }

    /**
     * Calculo del BMR para hombres
     * @param weight
     * @param height
     * @param age
     * @return
     */
   public static double getBMRCalcForMen(double weight, double height, int age) {
       return ((10 * weight) + (6.25 * height) - (5 * age) + K_bmf_factor_men);
   }

    /**
     * Calculo del BMR para mujeres
     * @param weight
     * @param height
     * @param age
     * @return
     */
    public static double getBMRCalcForWomen(double weight, double height, int age) {
        return ((10 * weight) + (6.25 * height) - (5 * age) - K_bmf_factor_women);
    }

    public static double getBMRCalc(BMRCalcDTO data) {
        return data.isMale() ? getBMRCalcForMen(data.getWeight(), data.getHeight(), data.getAge()) : getBMRCalcForWomen(data.getWeight(), data.getHeight(), data.getAge());
    }



















}
