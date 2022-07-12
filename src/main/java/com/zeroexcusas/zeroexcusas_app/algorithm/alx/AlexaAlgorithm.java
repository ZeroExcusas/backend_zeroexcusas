package com.zeroexcusas.zeroexcusas_app.algorithm.alx;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AlexaAlgorithm {
    private boolean _showTrace = false;

    private List<SimpleFood> fats = new ArrayList<>();
    private List<SimpleFood> proteins = new ArrayList<>();
    private List<SimpleFood> carbs = new ArrayList<>();

    public void loadFood(List<SimpleFood> proteins, List<SimpleFood> carbs, List<SimpleFood> fats) {
    }

    private void loadFoodsFromMocks() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type listOfFoods = new TypeToken<ArrayList<SimpleFood>>(){}.getType();
        List<SimpleFood>foodList = gson.fromJson(MockData.dataNew, listOfFoods);
    }

    private FoodCombinationDTO combineMoreThanOneFood(double foodRation, int nutriens, List<SimpleFood> foodList, FoodType foodType, int selectedFoodIndex, int units ) {
        int req = 1;
        int i2 = 0;
        int[] listIndex = new int[2];

        if ( ( foodRation > 200 ) && ( foodRation <= 300 ) ) {
            req = 2;

            // Se busca un alimento adicinoal alieatorio
            List<Integer> otherFood = getRandomFood(
                    selectedFoodIndex,
                    foodList.size(),
                    1);

            double amount1 = __getFoodAmount(nutriens, req, foodList.get(selectedFoodIndex), foodType);

            double amount2 = __getFoodAmount(nutriens, req, foodList.get(otherFood.get(0)), foodType);

            double[] amounts = new double[]{ amount1, amount2};

            int[] indexList = new int[]{selectedFoodIndex, otherFood.get(0)};

            return new FoodCombinationDTO(
                    req,
                    indexList,
                    amounts
            );

        } else if ( ( foodRation > 300 ) && ( foodRation <= 400 ) ) {
            req = 3;

            // dos indices aleatorios de alimentos
            List<Integer> otherFood = getRandomFood(selectedFoodIndex, foodList.size(), 2);

            double amount1 = __getFoodAmount(nutriens, req, foodList.get(selectedFoodIndex), foodType);
            double amount2 = __getFoodAmount(nutriens, req, foodList.get(otherFood.get(0)), foodType);
            double amount3 = __getFoodAmount(nutriens, req, foodList.get(otherFood.get(1)), foodType);

            double[] amounts = new double[]{amount1, amount2, amount3};

            int[] indexList = new int[]{selectedFoodIndex, otherFood.get(0), otherFood.get(1)};

            return new FoodCombinationDTO(
                    req,
                    indexList,
                    amounts
            );
        } else if (foodRation > 400) {

            List<Integer> otherFood = getRandomFood(selectedFoodIndex, foodList.size(), 3);

            req = 4;

            double amount1 = __getFoodAmount(nutriens, req, foodList.get(selectedFoodIndex), foodType);

            double amount2 = __getFoodAmount(nutriens, req, foodList.get(otherFood.get(0)), foodType);

            double amount3 = __getFoodAmount(nutriens, req, foodList.get(otherFood.get(1)), foodType);

            double amount4 = __getFoodAmount(nutriens, req, foodList.get(otherFood.get(2)), foodType);

            return new FoodCombinationDTO(
                    req,
                    new int[]{
                            selectedFoodIndex,
                            otherFood.get(0),
                            otherFood.get(1),
                            otherFood.get(2)
                    },
                    new double[]{
                            amount1,
                            amount2,
                            amount3,
                            amount4
                    }
            );

        }

        // No hay respuesta valida
        return new FoodCombinationDTO(
                1,
                new int[-1],
                new double[]{-1}
        );

    }

    /**
     * Get the right food amount for a given meal
     * @param nutriens
     * @param nFood
     * @param food
     * @param foodType
     * @return
     */
    private double __getFoodAmount(int nutriens, int nFood, SimpleFood food, FoodType foodType) {
        int units = unidadFood(food);
        double amount = nutriens / (nFood * units)/food.getNutrient(foodType);
        return amount;
    }

    public void suggestedFoods(double nutProt, double nutCarb, double nutFat, double numIterations, int epsilon, int porcProtMin, int porcCarbMin, int porcFatMin) {

        double KProt = 0;
        double KCarb = 0;
        double KFat = 0;
        double uProt = 1;
        double uCarb = 1;
        double uFat = 1;

        double KProtPlato = nutProt;
        double KCarbPlato = nutCarb;
        double KFatPlato = nutFat;
        double reqProt = 0;
        double reqCarb = 0;
        double reqFat = 0;


        int max_err = 100;
        int numiter = 0;

        FoodCombinationDTO proteinCombination = null;
        FoodCombinationDTO carbsCombination = null;

        while ( (max_err > epsilon) && (numiter < numIterations )) {

            show("[-- Interacion ("+numiter+") --]"); // label que indica el numero de iteraciones

            SelectedFoodDTO selectedCarb = generaIndiceAlimentoCantidadRazonable(this.carbs, KCarbPlato, FoodType.CARB, 500, 3);
            SelectedFoodDTO selectedProt = generaIndiceAlimentoCantidadRazonable(this.proteins, KCarbPlato, FoodType.PROTEIN, 500, 3);

            int fatIndex = getRandomIndexFromFoodList(this.fats); // Se obtiene una grasa aleatoria
            SimpleFood currentFat = this.fats.get(fatIndex);
            uFat = unidadFood(currentFat);

            KFat = KFatPlato * uFat / currentFat.getFatPerUnit();

            SelectedFoodDTO selectedFat = new SelectedFoodDTO(fatIndex, (int)uFat, KFat, currentFat);

            show("Cantidad de proteina Inicial: ");

            showInitialFood(selectedCarb);
            showInitialFood(selectedProt);
            showInitialFood(selectedFat);

           proteinCombination = combineMoreThanOneFood(
                    KProt,
                    (int)nutProt,
                    this.proteins,
                    FoodType.PROTEIN,
                    selectedProt.getIndex(),
                    selectedProt.getUnits()
            );

           carbsCombination = combineMoreThanOneFood(
                    KProt,
                    (int)nutCarb,
                    this.carbs,
                    FoodType.CARB,
                    selectedCarb.getIndex(),
                    selectedCarb.getUnits()
            );

            /*
            nutProt = 0
            nutCarb = 0
            nutProtT = 0
            nutCarbT = 0
            nutFatT = 0
            i = 0
            */

           // double nutProt = 0;
           // double nutCarb = 0;
            double nutProtT = 0;
            double nutCarbT = 0;
            double nutFatT = 0;

            int i = 0;
            double nutProt_i = 0;
            double porcentajeCarbxProt = 0;
            double porcentajeFatxProt = 0;

            while (i < proteinCombination.req) { // Evaluando los requisiotos para la protieina # jacs-10
                if (proteinCombination.req == 1) {

                    int protIndex = selectedProt.getIndex(); // Este indice seleccionado viene de la cobinancion aleatoria

                    SimpleFood currentProtein = this.proteins.get(protIndex);

                    nutProt = selectedProt.getAmount() * currentProtein.getProteinPerUnit() / currentProtein.getReferenceUnit(); // p01

                    nutProt_i = nutProt; // p03

                    porcentajeCarbxProt = currentProtein.getCarbsPerUnit() / currentProtein.getProteinPerUnit();
                    porcentajeFatxProt = currentProtein.getFatPerUnit() / currentProtein.getProteinPerUnit();
                }
                else {
                    int protIndex = proteinCombination.getFoodsIndex()[i];

                    double currentAmount = proteinCombination.getAmounts()[i];

                    SimpleFood currentProtein = this.proteins.get(protIndex); // cantidad

                    nutProt_i = currentAmount * currentProtein.getProteinPerUnit()/currentProtein.getReferenceUnit();

                    nutProt = nutProt + nutProt_i;

                    porcentajeCarbxProt = currentProtein.getCarbsPerUnit() / currentProtein.getProteinPerUnit();

                    porcentajeFatxProt = currentProtein.getFatPerUnit() / currentProtein.getProteinPerUnit();
                }

                nutProtT += nutProt_i;
                nutCarbT += nutProt_i * porcentajeCarbxProt;
                nutFatT += nutProt_i*porcentajeFatxProt;
                i++;
            }

            i = 0;
            double nutCarb_i = 0;
            double porcentajeProtxCarb = 0;
            double porcentajeFatxCarb = 0;
            // Ahora con los carbohidratos
            while ( i < carbsCombination.req ) {

                if (carbsCombination.req == 1) {
                    int carbIndex = selectedCarb.getIndex();

                    SimpleFood currentCarb = this.carbs.get(carbIndex);

                    nutCarb = selectedCarb.getAmount() * currentCarb.getProteinPerUnit() / currentCarb.getReferenceUnit(); // b01

                    nutCarb_i = nutCarb; // b02

                    porcentajeProtxCarb = currentCarb.getCarbsPerUnit() / currentCarb.getProteinPerUnit(); // b03

                    porcentajeFatxCarb = currentCarb.getFatPerUnit() / currentCarb.getProteinPerUnit(); // b04
                }
                else {

                    int carbIndex = carbsCombination.getFoodsIndex()[i];

                    double currentAmount = carbsCombination.getAmounts()[i];

                    SimpleFood currentCarb = this.carbs.get(carbIndex); // cantidad

                    nutCarb_i = currentAmount * currentCarb.getCarbsPerUnit() / currentCarb.getReferenceUnit(); // c01
                    nutCarb += nutCarb_i; //c02
                    porcentajeProtxCarb = currentCarb.getProteinPerUnit() / currentCarb.getCarbsPerUnit(); // c03
                    porcentajeFatxCarb = currentCarb.getFatPerUnit() / currentCarb.getCarbsPerUnit();
                }
                nutProtT += nutCarb_i * porcentajeProtxCarb;
                nutCarbT += nutCarb_i;
                nutFatT += nutCarb_i * porcentajeFatxCarb;
                i++;
            }

            // % de contribucion de Prot y Carb en la Fat

            double porcentajeProtxFat = selectedFat.getSimpleFood().getProteinPerUnit() / selectedFat.getSimpleFood().getFatPerUnit(); // h01
            double porcentajeCarbxFat = selectedFat.getSimpleFood().getCarbsPerUnit() / selectedFat.getSimpleFood().getFatPerUnit();

            nutProtT += nutFat*porcentajeProtxFat;
            nutCarbT += nutFat*porcentajeCarbxFat;
            nutFatT += nutFat; // h02 //  nutFatT = nutFat + nutFatT

            nutFat = selectedFat.getAmount() * currentFat.getFatPerUnit() / currentFat.getReferenceUnit();
            double errorProt = Math.abs(nutProtT - KProtPlato);
            double errorCarb = Math.abs(nutCarbT - KCarbPlato);
            double errorFat = Math.abs(nutFatT - KFatPlato);

            double max_errors = errorProt + errorCarb + errorFat;
            numiter++;
            show("errorProt: "+errorProt+" |  errorCarb: "+errorCarb+" | errorFat: "+errorFat);
            show("max err: "+max_err);
        }

        int i = 0;
        /*
        while ( i < proteinCombination.getReq()) {
            if (proteinCombination.getReq() == 1) {
                // combinacionAlimentosRow(tableProtein.iloc[pi], "PROTEINA ("+str(int(KProt))+" "+unidad(uProt)+")")  #h20
                


            }
            else {

            }
        }
         */

        // jacs-final






    }


    private SelectedFoodDTO generaIndiceAlimentoCantidadRazonable(List<SimpleFood> tableFood, double nutrients, FoodType foodType, int limitMaxGrams, int limitMaxUnit) {
        SimpleFood simpleFood = null;
        int unidades = 0;
        double cantidad= 0;
        String locName = foodType == FoodType.PROTEIN ? "Protein per unit" : "Carbs per unit";
        int limitMax = 0;

        int foodIndex;
        while (true) {
            foodIndex = getRandomIndexFromFoodList(tableFood);
            simpleFood = tableFood.get(foodIndex);
            unidades = unidadFood(simpleFood);

            if (unidades == 100) {
                limitMax = limitMaxGrams;
            } else {
                limitMax = limitMaxUnit;
            }
            cantidad = (double) (nutrients * (double) unidades / simpleFood.getNutrient(foodType));
            if (cantidad <= limitMax) {
                break;
            }
        }

        return new SelectedFoodDTO(foodIndex, unidades, cantidad, simpleFood);
    }

    private SelectedFoodDTO generaIndiceAlimentoCantidadRazonable(List<SimpleFood> tableFood, int nutrients, FoodType foodType) {
        return this.generaIndiceAlimentoCantidadRazonable(tableFood, nutrients, foodType, 500, 3);
    }

    private int unidadFood(SimpleFood simpleFood) {
        return simpleFood.getUnit() == 0 ? 100 : 1;
    }


    private String labelUnit(int unit) {
        return unit == 100 ? "gr" : "Unidades";
    }

    private void show(String message) {
        if (_showTrace) {
            System.out.println(message);
        }
    }

    private void showInitialFood(SelectedFoodDTO selectedFood) {
        if(_showTrace) {
            int KFoot = (int)selectedFood.getAmount();
            System.out.println("Cantidad de "+getFoodTypeToString(selectedFood.getSimpleFood().getType())+" inicial: "+KFoot+""+labelUnit(selectedFood.getUnits())+" de ("+selectedFood.getIndex()+") "+selectedFood.getSimpleFood().getName());
        }
    }

    private String getFoodTypeToString(FoodType foodType) {
        String label = "";
        switch (foodType) {
            case PROTEIN:
                label = "Protenia";
                break;
            case CARB:
                label = "Carb";
                break;
            case FAT:
                label = "Grasa";
                break;
        }
        return label;
    }

    private int getRandomIndexFromFoodList(List<SimpleFood> foodList) {
        return new Random().nextInt(foodList.size() - 1);
    }

    public static void main(String[] args) {
        int nutProt = 35;
        int nutCarb = 35;
        int nutFat = 12;
        int numInterationsMax =  1000;
        int errorUmbral = 9;
        int porcProtMin = 5;
        int porcCarbMin = 5;
        int porcFatMin = 5;


        AlexaAlgorithm alg = new AlexaAlgorithm();
        int previousIndex = 5;
        List<Integer> selected = alg.getRandomFood(
                previousIndex,
                10,
                2);
//        for(int a : selected) {
//            System.out.println("--> "+a);
//        }

        // we load default data just for testing  purposes
        alg.loadFoodsFromMocks();


        // we set all data for m
        alg.suggestedFoods(nutProt, nutCarb,
                nutFat, numInterationsMax, errorUmbral,
                porcProtMin, porcCarbMin, porcFatMin);



    }

    private List<Integer> getRandomFood(int previousIndex, int topIndex, int howMany) {
        List<Integer> selectedIndexes = new ArrayList<>();
        selectedIndexes.add(previousIndex);

        Random random = new Random();
        int counter = 0;
        while(counter < howMany) {
            int currentIndex = random.nextInt(topIndex);
            if (!selectedIndexes.contains(currentIndex)) {
                selectedIndexes.add(currentIndex);
                counter++;
            }
        }
        return selectedIndexes;
    }


}


