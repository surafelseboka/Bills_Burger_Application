package billsBurgerApplication;

public class CheeseBurger extends HamBurger{

    public CheeseBurger(String burgerType, String size) {
        super(burgerType,size);
    }

    @Override
    public void calculatePrice() {
        try {
            if (size.toUpperCase().equals("SMALL")) {
                basePrice += 12;
            } else if (size.toUpperCase().equals("MEDIUM")) {
                basePrice += 14;
            } else if (size.toUpperCase().equals("LARGE")) {
                basePrice += 16;
            } else {
                throw new IllegalArgumentException("Invalid size entered.");
            }
            setPrice(basePrice);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
