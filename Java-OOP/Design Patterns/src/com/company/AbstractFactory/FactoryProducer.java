package com.company.AbstractFactory;

public class FactoryProducer {

    public static AbstractFac getFactory(String factoryName) {

        if (factoryName.equals("shape")) {
            return new ShapeFactory();
        }
        if (factoryName.equals("color")) {
            return new ColorFactory();
        }
        System.out.println("unknown factory");
        return null;
    }

}
