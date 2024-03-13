package billsBurgerApplication;

import java.util.Scanner;

public class RunMainApp {
    public static void main(String[] args) {

        double hamBurgerPrice;
        double additionalToppingPrice;
        double totalPrice;

        InputValidation inputValidation = new InputValidation();

        System.out.println("*** Welcome to Bill's Burger ***");
        System.out.println("You have the  below burger options with size of small, Medium and large: " + "\n" +
                "1. Regular Burger " + "\n" +
                "2. Cheese Burger " + "\n" +
                "3. Veggie Burger " + "\n" );
        System.out.print("Please Enter the burger type:" + "\n" +
                            "R for Regular burger " + "\n" +
                             "C for Cheese burger " + "\n" +
                                "V for Veggie burger : ");

        Scanner scanner = new Scanner(System.in);
        String burger_type = scanner.nextLine();
        String burger_size;
//        System.out.print("Enter the burger size: ");
//        String burger_size = scanner.nextLine();

        do {
            System.out.print("Enter size (Small, Medium, Large): ");
            burger_size = scanner.nextLine();
        } while (!inputValidation.isValidSize(burger_size));  // Loop until valid input

        // Now you have valid 'size' and can proceed...
        System.out.println("Valid size received: " + burger_size);

        HamBurger hamBurger = HamBurger.hamBurger(burger_type, burger_size);
        hamBurger.calculatePrice();
        hamBurgerPrice = hamBurger.getBasePrice();

//        Topping topping = new Topping();
//        HamBurger hamBurger_topping = new HamBurger(topping);
//
//        additionalToppingPrice = hamBurger_topping.toppingPrice(burger_type);
        totalPrice = hamBurgerPrice; //+ additionalToppingPrice;

        System.out.println("*** Bill summary ***" + "\n");
        System.out.println("HumBurger Price: " + hamBurgerPrice);
        //System.out.println("add on item price is: " + additionalToppingPrice);
        System.out.println("Total cost: " + totalPrice);

        System.out.println("*** Thank you visit again ***");

    }


}
