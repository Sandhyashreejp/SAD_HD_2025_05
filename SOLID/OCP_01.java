package SOLID;

import java.util.HashMap;
import java.util.Map;

public class OCP_01 {

    public interface DiscountStrategy {
        double applyDiscount(double amount);
    }

    public static class RegularCustomerDiscount implements DiscountStrategy {
        @Override
        public double applyDiscount(double amount) {
            return amount * 0.1;
        }
    }

    public static class PremiumCustomerDiscount implements DiscountStrategy {
        @Override
        public double applyDiscount(double amount) {
            return amount * 0.2;
        }
    }

    public static class DiscountCalculator {
        private final Map<String, DiscountStrategy> strategies = new HashMap<>();

        public DiscountCalculator() {
            strategies.put("Regular", new RegularCustomerDiscount());
            strategies.put("Premium", new PremiumCustomerDiscount());
            // add new strategies here without changing logic
        }

        public double calculateDiscount(String customerType, double amount) {
            DiscountStrategy strategy = strategies.get(customerType);
            if (strategy != null) {
                return strategy.applyDiscount(amount);
            }
            return 0.0;
        }
    }

    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator();
        double regularDiscount = calculator.calculateDiscount("Regular", 100.0);
        double premiumDiscount = calculator.calculateDiscount("Premium", 100.0);

        System.out.println("Regular Discount: " + regularDiscount);
        System.out.println("Premium Discount: " + premiumDiscount);
    }
}
