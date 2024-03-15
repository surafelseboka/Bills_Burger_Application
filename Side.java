package billsBurgerApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Side {

    private double side_price;
    public enum SideType {

        FRIES("French Fries", 3.50),
        POPCORN("Popcorn", 4.50),
        NUGGETS("Chicken Nuggets", 5.50);

        private final String name;
        private final double price;

        SideType(String name, double price){
            this.name = name;
            this.price = price;
        }
        public String getName() {
            return name;
        }
        public double getPrice(){
            return price;
        }
    }
    public double calculateAddOnPrice(String sideType){
        Map<SideType, Integer> selectedSide = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int maxAddOns = 3;

        for (SideType sides : SideType.values()){
            System.out.println(sides.name() + " - $" + sides.getPrice());
                    }
        System.out.println("You can select additional items listed below");
        System.out.println("Do you want to add extra sides? (Y/N)");
        String addMore = scanner.nextLine();

        while (addMore.equalsIgnoreCase("Y") && selectedSide.size() < maxAddOns){
            System.out.println("Enter side: ");
            String side = scanner.nextLine().toUpperCase();

            try{
                SideType sideAddOn = SideType.valueOf(side);
                selectedSide.put(sideAddOn, selectedSide.getOrDefault(sideAddOn, 0)+1);
                side_price += sideAddOn.getPrice();
                System.out.println(sideAddOn.getName() + " Added!");
            } catch (IllegalArgumentException e){
                System.out.println("Invalid Side. Please try again.");
            }
            System.out.println("Add another side? (Y/N)");
            addMore = scanner.nextLine();
        }
        return side_price;
    }


}
