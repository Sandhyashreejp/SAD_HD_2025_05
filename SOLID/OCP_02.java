package SOLID;

public class OCP_02 {

    // Abstract Shape class with an abstract area method
    public static abstract class Shape {
        public abstract double getArea();
    }

    // Concrete Square class
    public static class Square extends Shape {
        private double side;

        public Square(double side) {
            this.side = side;
        }

        @Override
        public double getArea() {
            return side * side;
        }
    }

    // Concrete Circle class
    public static class Circle extends Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }
    }

    // AreaCalculator doesn't need to know about specific shapes
    public static class AreaCalculator {
        public double getArea(Shape shape) {
            return shape.getArea();
        }
    }

    // Testing the implementation
    public static void main(String[] args) {
        Shape square = new Square(4);
        Shape circle = new Circle(3);

        AreaCalculator calculator = new AreaCalculator();
        System.out.println("Square Area: " + calculator.getArea(square));
        System.out.println("Circle Area: " + calculator.getArea(circle));
    }
}
