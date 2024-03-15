package billsBurgerApplication;

public class InputValidation {
    public static boolean isValidType(String type){
        return type.equalsIgnoreCase("Regular") ||
                type.equalsIgnoreCase("Cheese") ||
                type.equalsIgnoreCase("Veggie");
    }
    public static boolean isValidSize(String size) {
        return size.equalsIgnoreCase("Small") ||
                size.equalsIgnoreCase("Medium") ||
                size.equalsIgnoreCase("Large");
    }

    public static boolean isValidSideName(String type){
        return type.equalsIgnoreCase("Fries") ||
                type.equalsIgnoreCase("popcorn")||
                type.equalsIgnoreCase("nuggets");
    }
    public static boolean isValidDrinkName(String type){
        return type.equalsIgnoreCase("pepsi") ||
                type.equalsIgnoreCase("sevenup")||
                type.equalsIgnoreCase("coke");
    }

    public static boolean isValidToppingName(String type){
        return type.equalsIgnoreCase("ONION") ||
                type.equalsIgnoreCase("TOMATOES")||
                type.equalsIgnoreCase("CHEESE")||
                type.equalsIgnoreCase("MAYONNAISE")||
                type.equalsIgnoreCase("LETTUCE");
    }
}
