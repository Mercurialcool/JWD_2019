package by.webparsing.vadim.entity;

public class CaramelCandy extends Candy {
    public CaramelCandy(){
        setType("карамельная");
        setChocolateType("-");
    }

    public CaramelCandy(String name, int energy, String type,
                        double proteins, double fats, double carbohydrates,
                        double waterAmount, double sugarAmount, double fructoseAmount,
                        double vanillinAmount, String production, String chocolateType){
        super(name, energy, type, proteins, fats, carbohydrates,
                waterAmount, sugarAmount, fructoseAmount,
                vanillinAmount, production, chocolateType);
    }
}
