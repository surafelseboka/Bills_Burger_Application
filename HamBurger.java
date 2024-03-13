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
    public void addExtra(){

    }

  public void calculatePrice(){
        basePrice = size.equals("Small") ? basePrice += 10 :
                size.equals("Medium") ? basePrice += 12 :
                        size.equals("Large") ? basePrice += 14 : -1;
        setPrice(basePrice);
  }

  public double toppingPrice(String burgerType){
        return topping.calculateToppingPrice(burgerType);
  }

  public static HamBurger hamBurger(String burgerType, String size){
        return  switch (burgerType.toUpperCase().charAt(0)){
            case 'R' -> new RegularBurger(burgerType,size);
            case 'C' -> new CheeseBurger(burgerType, size);
            case 'V' -> new VeggieBurger(burgerType, size);
            default -> new HamBurger(burgerType, size);
        };
  }

}