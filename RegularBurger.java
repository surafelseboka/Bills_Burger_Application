package billsBurgerApplication;

public class RegularBurger extends HamBurger{
    public RegularBurger(String burgerType, String size) {
        super(burgerType,size);
    }

    @Override
    public void calculatePrice() {
        basePrice = 12;
    }
}

