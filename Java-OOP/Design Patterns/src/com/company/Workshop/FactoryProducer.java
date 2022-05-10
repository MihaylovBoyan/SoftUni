package com.company.Workshop;


import com.company.AbstractFactory.ColorFactory;
import com.company.AbstractFactory.ShapeFactory;

public class FactoryProducer {

    public static AbstractFactory getFactory(String factoryName) {

        if (factoryName.equals("dwarf")) {
            return new DwarfFactory();
        } else {
            System.out.println("unknown factory");
            return null;
        }
    }
}
