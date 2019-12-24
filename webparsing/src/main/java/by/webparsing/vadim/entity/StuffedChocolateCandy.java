package by.webparsing.vadim.entity;

public class StuffedChocolateCandy extends Candy {

    public StuffedChocolateCandy(){
        setType("шоколадная с начинкой");
    }

    public StuffedChocolateCandy(String name, int energy, String type, double proteins,
                                 double fats, double carbohydrates, double waterAmount,
                                 double sugarAmount, double fructoseAmount, double vanillinAmount,
                                 String production, String chocolateType){
        super(name, energy, type, proteins, fats,
                carbohydrates, waterAmount, sugarAmount,
                fructoseAmount, vanillinAmount,
                production, chocolateType);
    }
}
