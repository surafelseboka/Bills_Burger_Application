package billsBurgerApplication;

public class Drink{
    public String drink_type;
    public String drink_size;
    protected double drink_price;

    public Drink(String drink_type, String drink_size){
        this.drink_type = drink_type;
        this.drink_size = drink_size;
    }

    public void setDrink_price(double drink_price){
        this.drink_price = drink_price;
    }

    public double getDrink_price(){
        return drink_price;
    }

    public void calculateDrinkPrice(){
        drink_price = drink_type.equals("Small") ? drink_price +=1 : drink_type.equals("medium") ? drink_price +=2.50 :
                drink_type.equals("Large") ? drink_price += 4.50: -1;
        setDrink_price(drink_price);
    }
    public enum DrinkType{
        COKE,
        PEPSI,
        SEVENUP
    }

    public static Drink drink(DrinkType drinkType, String drink_size){
        switch (drinkType){
            case COKE: return new Coke(drinkType.name(), drink_size);
            case PEPSI:return new Pepsi(drinkType.name(), drink_size);
            case SEVENUP:return new SevenUp(drinkType.name(), drink_size);
            default:return new Drink(drinkType.name(), drink_size);
        }
    }
}
