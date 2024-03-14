package billsBurgerApplication;

public class Pepsi extends Drink {
    public Pepsi(String drink_type, String drink_size) {
        super(drink_type,drink_size);
    }

    @Override
    public void calculateDrinkPrice() {
        try {
            if (drink_size.toUpperCase().equals("SMALL")){
                drink_price += 1;
            } else if (drink_size.toUpperCase().equals("MEDIUM")) {
                drink_price +=2.50;
            } else if (drink_size.toUpperCase().equals("LARGE")) {
                drink_price += 4.50;
            } else{
                throw new IllegalArgumentException("Invalid Size entered.");
            }
            setDrink_price(drink_price);
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
