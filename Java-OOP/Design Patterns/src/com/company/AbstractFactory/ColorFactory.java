package com.company.AbstractFactory;

import com.company.AbstractFactory.AbstractFac;
import com.company.AbstractFactory.Blue;
import com.company.AbstractFactory.Color;
import com.company.AbstractFactory.Shape;

public class ColorFactory extends AbstractFac {


    @Override
    public Color getColor(String colorName) {

        if (colorName.equals("blue")) {
            return new Blue();
        }
        if (colorName.equals("green")) {
            return new Green();
        }
        System.out.println("Unknown color");
        return null;
    }

    @Override
    public  Shape getShape(String shapeName) {
        return null;
    }
}
