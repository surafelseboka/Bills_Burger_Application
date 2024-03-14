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

    public static Drink drink(String drink_type, String drink_size){
        return  switch(drink_type.toUpperCase().charAt(0)){
            case 'C' -> new Coke(drink_type,drink_size);
            case 'P' -> new Pepsi(drink_type, drink_type);
            case 's' -> new SevenUp(drink_type, drink_size);
            default -> new Drink(drink_type, drink_size);
        };
    }



}
