package billsBurgerApplication;

import java.util.Scanner;

public class RunMainApp {
    public static void main(String[] args) {

        double hamBurgerPrice;
        double drinkPrice;
        double additionalToppingPrice;
        double totalPrice;

        System.out.println("*** Welcome to Bill's Burger ***");
        System.out.println("You have the  below burger options with size of small, Medium and large: " + "\n" +
                "1. Regular Burger " + "\n" +
                "2. Cheese Burger " + "\n" +
                "3. Veggie Burger " + "\n" );

        Scanner scanner = new Scanner(System.in);
        String burger_type, burger_size, side_type, drink_type, drink_size;

        InputValidation inputValidation = new InputValidation();

        /* Burger */

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

        HamBurger hamBurger = HamBurger.hamBurger(HamBurger.BurgerType.valueOf(burger_type.toUpperCase()), burger_size);
        hamBurger.calculatePrice();
        hamBurgerPrice = hamBurger.getBasePrice();

       Topping topping = new Topping();
       HamBurger hamBurger_topping = new HamBurger(topping);

         additionalToppingPrice = hamBurger_topping.toppingPrice(burger_type);

         /* Side */

        do {
            System.out.print("Enter Type (Fries, Popcorn, Nuggets): ");
            side_type = scanner.nextLine();
        } while (!inputValidation.isValidSideName(side_type));
        System.out.println("Valid type received: " + side_type);

        Side side = new Side();
        double side_price = side.calculateAddOnPrice(side_type);

         /* Drinks */

        do {
            System.out.print("Enter Type (Coke, Pepsi, SevenUp): ");
            drink_type = scanner.nextLine();
        } while (!inputValidation.isValidDrinkName(drink_type));
        System.out.println("Valid type received: " + drink_type);

        do {
            System.out.print("Enter size (Small, Medium, Large): ");
            drink_size = scanner.nextLine();
        } while (!inputValidation.isValidSize(drink_size));
        System.out.println("Valid size received: " + drink_size);
        System.out.println();

        Drink drink = Drink.drink(Drink.DrinkType.valueOf(drink_type.toUpperCase()), drink_size);
        drink.calculateDrinkPrice();
        drinkPrice = drink.getDrink_price();

        System.out.println("drink price " + drinkPrice);

        totalPrice = hamBurgerPrice + additionalToppingPrice + side_price + drinkPrice;

        System.out.println("-".repeat(30));

        System.out.println("*** Bill summary ***" + "\n");
        System.out.println("HumBurger Price: " + hamBurgerPrice);
        System.out.println("add on item price is: " + additionalToppingPrice);
        System.out.println("Side add on price is: " + side_price);
        System.out.println("Drink price: " + drinkPrice);
        System.out.println("Total cost: " + totalPrice);

        System.out.println("*".repeat(10) + " Thank you visit again " + "*".repeat(10));

    }


}
