package SOLID;

public class LSP_02 {

    public static abstract class Bird {
        public abstract void move(); // general movement, not just flying
    }

    public static class FlyingBird extends Bird {
        @Override
        public void move() {
            fly();
        }

        public void fly() {
            System.out.println("The bird is flying...");
        }
    }

    public static class Sparrow extends FlyingBird {
        @Override
        public void fly() {
            System.out.println("The sparrow is flying...");
        }
    }

    public static class Penguin extends Bird {
        @Override
        public void move() {
            System.out.println("The penguin is waddling...");
        }
    }

    public static void move(Bird bird) {
        bird.move();
    }

    public static void main(String[] args) {
        move(new Sparrow());   // Output: The sparrow is flying...
        move(new Penguin());   // Output: The penguin is waddling...
    }
}
