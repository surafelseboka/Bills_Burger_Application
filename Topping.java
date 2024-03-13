package billsBurgerApplication;

import java.util.Scanner;

public class Topping  {
    private double toppingPrice;

    public Topping(){}

    public double calculateToppingPrice(String burgerType){
        Scanner scanner = new Scanner(System.in);

        if (burgerType.equals("R"))
            System.out.println("Add on items are not applicable for a Regular Economy Burger");
        else{
            System.out.println("You can select up to 5 items listed below: " + "\n" +
                    "O -> Onion = 0.50 ¢ " + "\n" +
                    "T -> Tomatoes = 0.50 ¢ " + "\n" +
                     "L -> Lettuce = 0.50 ¢ " + "\n" +
                    "C -> Cheese = 0.50 ¢ " + "\n" +
                    "M -> Mayonnaise = 0.50 ¢ " + "\n" );

            String addOn = "";
            String addOnConvert= "";
            boolean first_iteration = true;

            System.out.println("Do you want add extra topping - Y or N ?");
            String input  = scanner.nextLine();
            if (input.equals("Y")){

                System.out.println("Enter the extra topping: ");
                switch (input){
                    case "O" -> addOnConvert = "Onion";
                    case "T" -> addOnConvert = "Tomatoes";
                    case "L" -> addOnConvert = "Lettuce";
                    case "C" -> addOnConvert = "Cheese";
                    case "M" -> addOnConvert = "Mayonnaise";
                    default -> System.out.println("Please enter the valid topping");
                 }
                 if (first_iteration){
                    addOn = addOnConvert;
                    first_iteration = false;
                 }else {
                     addOn = addOn + ", "+ addOnConvert;
                 }

                 switch (input){
                     case "O", "C","T","L","M" -> toppingPrice += 0.50;
                     default -> System.out.println("You have added " + addOn);
                 }
                System.out.println("You have added " + addOn);
            }
        }
        return toppingPrice;
    }
}
