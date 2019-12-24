package by.webparsing.vadim.entity;

public class NotStuffedChocolateCandy extends Candy {

    public NotStuffedChocolateCandy(){
        setType("шоколадная без начинки");
    }

    public NotStuffedChocolateCandy(String name, int energy, String type,
                                    double proteins, double fats, double carbohydrates,
                                    double waterAmount, double sugarAmount, double fructoseAmount,
                                    double vanillinAmount, String production, String chocolateType){
        super(name, energy, type, proteins,
                fats, carbohydrates, waterAmount,
                sugarAmount, fructoseAmount, vanillinAmount,
                production, chocolateType);
    }
}
