package JavaPractice.TO_PRINT.DesignPatterns.designPatterns.Creational.factory;

class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

class Triangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Draw Triangle");
    }
}

class ShapeFactory{
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        switch (shapeType.toLowerCase()){
            case "circle":
                return new Circle();
            case "square":
                return new Square();
            case "triangle":
                return new Triangle();
            default:
                throw new IllegalArgumentException("Unknown shape type" + shapeType);
        }
    }
}

public class Main{
    public static void main(String[] args){

        ShapeFactory shapeFactory = new ShapeFactory();

        Circle circle = (Circle) shapeFactory.getShape("circle");
        circle.draw();

        Square square = (Square) shapeFactory.getShape("square");
        square.draw();

        Triangle triangle = (Triangle) shapeFactory.getShape("triangle");
        triangle.draw();
    }
}