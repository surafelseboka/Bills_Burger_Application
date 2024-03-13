package billsBurgerApplication;

import java.util.Scanner;

public class RunMainApp {
    public static void main(String[] args) {

        double hamBurgerPrice;
        double additionalToppingPrice;
        double totalPrice;

        System.out.println("*** Welcome to Bill's Burger ***");
        System.out.println("You have the  below burger options with size of small, Medium and large: " + "\n" +
                "1. Regular Burger " + "\n" +
                "2. Cheese Burger " + "\n" +
                "3. Veggie Burger " + "\n" );

        Scanner scanner = new Scanner(System.in);
        String burger_type, burger_size;

        InputValidation inputValidation = new InputValidation();

        do {
            System.out.print("Enter Type (Regular, Cheese, Veggie): ");
            burger_type = scanner.nextLine();
        } while (!inputValidation.isValidType(burger_type));
        System.out.println("Valid type received: " + burger_type);


        do {
            System.out.print("Enter size (Small, Medium, Large): ");
            burger_size = scanner.nextLine();
        } while (!inputValidation.isValidSize(burger_size));
        System.out.println("Valid size received: " + burger_size);
        System.out.println();

        HamBurger hamBurger = HamBurger.hamBurger(burger_type, burger_size);
        hamBurger.calculatePrice();
        hamBurgerPrice = hamBurger.getBasePrice();

       Topping topping = new Topping();
       HamBurger hamBurger_topping = new HamBurger(topping);

         additionalToppingPrice = hamBurger_topping.toppingPrice(burger_type);
         totalPrice = hamBurgerPrice + additionalToppingPrice;


        System.out.println("*** Bill summary ***" + "\n");
        System.out.println("HumBurger Price: " + hamBurgerPrice);
        System.out.println("add on item price is: " + additionalToppingPrice);
        System.out.println("Total cost: " + totalPrice);

        System.out.println("*** Thank you visit again ***");

    }


}
