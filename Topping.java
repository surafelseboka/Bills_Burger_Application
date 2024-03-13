package billsBurgerApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Topping  {
    private double toppingPrice;
//    public double calculateAddOn(String burgerType){
//
//
//        if (burgerType.equals("R")) {
//            System.out.println("Add on items are not applicable for a Regular Economy Burger");
//        } else{
//            System.out.println("You can select up to 5 items listed below: " + "\n" +
//                    "O -> Onion = 0.50 ¢ " + "\n" +
//                    "T -> Tomatoes = 0.50 ¢ " + "\n" +
//                     "L -> Lettuce = 0.50 ¢ " + "\n" +
//                    "C -> Cheese = 0.50 ¢ " + "\n" +
//                    "M -> Mayonnaise = 0.50 ¢ " + "\n" );
//
//            String addOn = "";
//            String addOnConvert= "";
//            boolean first_iteration = true;
//
//            System.out.println("Do you want add extra topping - Y or N ?");
//            Scanner scanner = new Scanner(System.in);
//            String input  = scanner.nextLine();
//            if (input.equals("Y")){
//
//                System.out.println("Enter the extra topping: ");
//                switch (input){
//                    case "O" -> addOnConvert = "Onion";
//                    case "T" -> addOnConvert = "Tomatoes";
//                    case "L" -> addOnConvert = "Lettuce";
//                    case "C" -> addOnConvert = "Cheese";
//                    case "M" -> addOnConvert = "Mayonnaise";
//                    default -> System.out.println("Please enter the valid topping");
//                 }
//                 if (first_iteration){
//                    addOn = addOnConvert;
//                    first_iteration = false;
//                 }else {
//                     addOn = addOn + ", "+ addOnConvert;
//                 }
//
//                 switch (input){
//                     case "O", "C","T","L","M" -> toppingPrice += 0.50;
//                     default -> System.out.println("You have added " + addOn);
//                 }
//                System.out.println("You have added " + addOn);
//            }
//        }
//        return toppingPrice;
//    }

    // ... (Previous code with Topping enum)

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
