package SOLID;

public class DIP_01 {

    /*
     * FIXED:
     * The Switch now depends on an interface (Device), not the concrete LightBulb.
     * This follows the Dependency Inversion Principle.
     */

    // Abstraction
    public interface Device {
        void turnOn();
        void turnOff();
    }

    // Low-level module
    public static class LightBulb implements Device {
        public void turnOn() {
            System.out.println("Light is ON!");
        }
        public void turnOff() {
            System.out.println("Light is OFF!");
        }
    }

    // High-level module
    public static class Switch {
        private Device device;

        // Dependency Injection via abstraction
        public Switch(Device device) {
            this.device = device;
        }

        public void operate() {
            device.turnOn(); // could also be logic to toggle
        }
    }

    public static void main(String[] args) {
        Device lightBulb = new LightBulb(); // code to interface
        Switch lightSwitch = new Switch(lightBulb);
        lightSwitch.operate(); // prints "Light is ON!"
    }
}
