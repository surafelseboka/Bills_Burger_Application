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
}
