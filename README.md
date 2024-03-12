How This Works

Building a Meal: Bill creates a Meal. He selects a Hamburger (with its base price), a Drink, and a Side. He'd also add Extras to the burger if the customer chooses them.

Pricing:

The Hamburger.calculatePrice() considers the base price and prices of added extras.
The Meal.calculatePrice() sums up the prices of the hamburger, drink, and side.


Core Classes

Meal:

Attributes: mealID, price
Methods: addItem(), calculatePrice(), getMealDescription()

Hamburger:

Attributes: type (e.g., cheeseburger, veggie burger), basePrice
Methods: addExtra(), calculatePrice()

Item:

Attributes: name, description, price
Methods: None (Abstract class)

Drink: (subclass of Item)

Side: (subclass of Item)

Extra:  (subclass of Item)


Relationships

Composition:
Meal "is composed of" one Hamburger, one Drink, and one Side
Hamburger "is composed of" multiple Extras (if allowed)
 
  UML Diagram

+-------------------+      +-------------------+ 
| Meal              |      | Hamburger         |
+-------------------+      +-------------------+ 
| - mealID          |      | - type            |
| - price           |1     | - basePrice       |
| + addItem()       | *    | + addExtra()      |
| + calculatePrice()|      | + calculatePrice()|  
| + getDescription()|      +-------------------+     
+-------------------+   
                      +---------------+     
                      |     Item      |
                      +---------------+
                      | - name        |
                      | - description |
                      | - price       |
                      +---------------+
                            ^         ^           ^
                            |         |           |
                +-----------+  +-----------+ +------------+
                |  Drink    |  |  Side     | |  Extra     | 
                +-----------+  +-----------+ +------------+  



