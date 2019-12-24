package by.webparsing.vadim.entity;

public class Candy {
    private String name;
    private int energy;
    private String type;
    private double proteins;
    private double fats;
    private double carbohydrates;
    private double waterAmount;
    private double sugarAmount;
    private double fructoseAmount;
    private double vanillinAmount;
    private String production;
    private String chocolateType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public double getWaterAmount() {
        return waterAmount;
    }

    public void setWaterAmount(double waterAmount) {
        this.waterAmount = waterAmount;
    }

    public double getSugarAmount() {
        return sugarAmount;
    }

    public void setSugarAmount(double sugarAmount) {
        this.sugarAmount = sugarAmount;
    }

    public double getFructoseAmount() {
        return fructoseAmount;
    }

    public void setFructoseAmount(double fructoseAmount) {
        this.fructoseAmount = fructoseAmount;
    }

    public double getVanillinAmount() {
        return vanillinAmount;
    }

    public void setVanillinAmount(double vanilinAmount) {
        this.vanillinAmount = vanilinAmount;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getChocolateType() {
        return chocolateType;
    }

    public void setChocolateType(String chocolateType) {
        this.chocolateType = chocolateType;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Candy(String name, int energy, String type, double proteins,
                 double fats, double carbohydrates, double waterAmount,
                 double sugarAmount, double fructoseAmount, double vanillinAmount,
                 String production, String chocolateType) {
        this.name = name;
        this.energy = energy;
        this.type = type;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
        this.waterAmount = waterAmount;
        this.sugarAmount = sugarAmount;
        this.fructoseAmount = fructoseAmount;
        this.vanillinAmount = vanillinAmount;
        this.production = production;
        this.chocolateType = chocolateType;
    }

    public Candy(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candy candy = (Candy) o;
        return this.name.equals(candy.getName());

    }

    @Override
    public int hashCode() {
        return  energy * (int)waterAmount;
    }
}
