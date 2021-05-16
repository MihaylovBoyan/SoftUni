package InterfacesAndAbstraction.Shape;

public class Main {
    public static void main(String[] args) {

        Shape shape = new Circle(13);
        Square square = new Square(10);

        printShapeInfo(shape);
        printShapeInfo(square);

    }

    public static void printShapeInfo(Shape shape){

        System.out.println(shape.calculateArea());
        System.out.println(shape.calculatePerimeter());

    }
}
