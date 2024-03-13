package billsBurgerApplication;

public class InputValidation {
    public static boolean isValidSize(String size) {
        return size.equalsIgnoreCase("Small") ||
                size.equalsIgnoreCase("Medium") ||
                size.equalsIgnoreCase("Large");
    }
}
