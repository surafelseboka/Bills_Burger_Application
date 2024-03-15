package billsBurgerApplication;

public class HamBurger  {
    private Topping topping;
    private String burgerType;
    protected double basePrice;
    public String size;

    public HamBurger(String burgerType, String size){
        this.burgerType = burgerType;
        this.size = size;
    }

    public HamBurger(Topping topping){
        this.topping = topping;
    }

    public double getBasePrice(){
        return basePrice;
    }

    public void setPrice(double basePrice){
        this.basePrice = basePrice;
    }


  public void calculatePrice(){
        basePrice = size.equals("Small") ? basePrice += 10 :
                size.equals("Medium") ? basePrice += 12 :
                        size.equals("Large") ? basePrice += 14 : -1;
        setPrice(basePrice);
  }

  public double toppingPrice(String burgerType){
        return topping.calculateAddOnPrice(burgerType);
  }
    public enum BurgerType {
        REGULAR,
        CHEESE,
        VEGGIE
    }

    public static HamBurger hamBurger(BurgerType burgerType, String size) {
        switch (burgerType) {
            case REGULAR: return new RegularBurger(burgerType.name(), size);
            case CHEESE: return new CheeseBurger(burgerType.name(), size);
            case VEGGIE: return new VeggieBurger(burgerType.name(), size);
            default: return new HamBurger(burgerType.name(), size);
        }
    }

}