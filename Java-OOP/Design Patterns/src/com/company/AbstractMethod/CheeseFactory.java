package com.company.AbstractMethod;

public class CheeseFactory extends FarmFactory{


    @Override
    public FarmProduct createProduct(String productName) {

        if(productName.equals("cow cheese")){
            return new CowCheese();
        }

        if(productName.equals("goat cheese")){
            return new GoatCheese();
        }

        return null;
    }
}
