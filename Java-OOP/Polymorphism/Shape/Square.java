package InterfacesAndAbstraction.Shape;

public class Square implements Shape{
    private double side;

    public Square(double radius) {
        this.side = radius;
    }

    @Override
    public double calculateArea() {
        return side * 4;
    }

    @Override
    public double calculatePerimeter() {
        return side * side;
    }


}
