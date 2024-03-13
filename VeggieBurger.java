package billsBurgerApplication;

public class VeggieBurger extends HamBurger{
    public VeggieBurger(String burgerType, String size) {
        super(burgerType, size);
    }

    @Override
    public void calculatePrice() {

        try {
            if (size.toUpperCase().equals("SMALL")) {
                basePrice += 9;
            } else if (size.toUpperCase().equals("MEDIUM")) {
                basePrice += 11;
            } else if (size.toUpperCase().equals("LARGE")) {
                basePrice += 13;
            } else {
                throw new IllegalArgumentException("Invalid size entered.");
            }
            setPrice(basePrice);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
