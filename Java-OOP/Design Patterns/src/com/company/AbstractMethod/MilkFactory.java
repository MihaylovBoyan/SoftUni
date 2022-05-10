package com.company.AbstractMethod;

public class MilkFactory extends FarmFactory {
    @Override
    public FarmProduct createProduct(String productName) {

        if (productName.equals("cow milk")) {
            return new CowMilk();
        }

        if (productName.equals("goat milk")) {
            return new GoatMilk();
        }

        return null;
    }
}
