package com.company.AbstractFactory;

public class ShapeFactory extends AbstractFac{


    @Override
   public Color getColor(String colorName) {
        return null;
    }

    @Override
   public Shape getShape(String shapeName) {

       if(shapeName.equals("circle")){
           return new Circle();
       }
        if(shapeName.equals("rectangle")){
            return new Rectangle();
        }
        System.out.println("Unknown shape");
        return null;
    }
}
