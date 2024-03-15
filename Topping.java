package billsBurgerApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static billsBurgerApplication.InputValidation.isValidToppingName;

public class Topping  {
    private double toppingPrice;
    public enum ToppingType {
        ONION("Onion", 0.50),
        TOMATOES("Tomatoes", 0.50),
        LETTUCE("Lettuce", 0.50),
        CHEESE("Cheese", 0.50),
        MAYONNAISE("Mayonnaise", 0.50);

        private final String name;
        private final double price;

        ToppingType(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }
    public double calculateAddOnPrice(String burgerType) {

        if (burgerType.equals("R")) {
            throw new IllegalArgumentException("Add-ons are not applicable for a Regular Economy Burger");
        }

        Map<ToppingType, Integer> selectedToppings = new HashMap<>(); // Store selected toppings and their count
        Scanner scanner = new Scanner(System.in);
        int maxAddOns = 5;

        System.out.println("You can select up to " + maxAddOns +  " items listed below: ");
        for (ToppingType topping : ToppingType.values()) {
            System.out.println(topping.name() + " - $" + topping.getPrice());
        }

        System.out.println("Do you want to add extra toppings? (Y/N)");
        String addMore = scanner.nextLine();

        while (addMore.equalsIgnoreCase("Y") && selectedToppings.size() < maxAddOns) {
            System.out.println("Enter topping code: ");
            String code = scanner.nextLine().toUpperCase();

            try {
                ToppingType topping = ToppingType.valueOf(code);
                selectedToppings.put(topping, selectedToppings.getOrDefault(topping, 0) + 1);
                toppingPrice += topping.getPrice();
                System.out.println(topping.getName() + " added!");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid topping code. Please try again.");
            }
                  System.out.println("Add another topping? (Y/N)");
                  addMore = scanner.nextLine();

        }
        return toppingPrice;
    }


}
