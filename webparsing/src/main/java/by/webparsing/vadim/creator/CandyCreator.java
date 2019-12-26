package by.webparsing.vadim.creator;

import by.webparsing.vadim.entity.Candy;

public abstract class CandyCreator {
    protected Candy candy;

    protected Candy getCandy(){
        return candy;
    }

    public abstract void buildName();
    public abstract void buildEnergy();
    public abstract void buildWaterAmount();
    public abstract void buildSugarAmount();
    public abstract void buildFructoseAmount();
    public abstract void buildVanillinAmount();
    public abstract void buildProduction();
    public abstract void buildSweet();
    public abstract void buildChocolateType();
    public abstract void buildProteins();
    public abstract void buildFats();
    public abstract void buildCarbohydrates();
}
