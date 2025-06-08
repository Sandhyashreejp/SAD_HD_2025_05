package SOLID;

public class DIP_01 {

    public interface Device {
        void turnOn();
        void turnOff();
    }

    public static class LightBulb implements Device {
        public void turnOn() {
            System.out.println("Light is ON!");
        }

        public void turnOff() {
            System.out.println("Light is OFF!");
        }
    }

    public static class Switch {
        private final Device connectedDevice;

        public Switch(Device device) {
            this.connectedDevice = device;
        }

        public void operate() {
            connectedDevice.turnOn();
        }
    }

    public static void main(String[] args) {
        Device bulb = new LightBulb();
        Switch powerSwitch = new Switch(bulb);
        powerSwitch.operate();
    }
}
