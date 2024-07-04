package cy.markelova.coffee.service;

import cy.markelova.coffee.entity.CoffeeType;

public class MenuMessages {

    public final static String INSTRUCTIONS_MENU = """
             Select an option:
             0 - show the instruction
             1 - load a coffee
             2 - get info about van
             3 - get a list of loaded coffee sorted by price
             4 - get a list of loaded coffee by weight
             5 - get a number of loaded items
             6 - get a sum of loaded items
             7 - get an amount of available space in a van
             8 - get a list of coffee filtered by min and max price
             exit - exit
            """;
    public final static String INSTRUCTIONS_LOADING_COFFEE = String.format("""
                    Enter 4 parameters of coffee separated by spaces (or exit):
                    name volume type* price
                    *one of %s %s %s %s""",
            CoffeeType.COFFEE_BEANS, CoffeeType.GROUND_COFFEE, CoffeeType.INSTANT_COFFEE_JAR,
            CoffeeType.INSTANT_COFFEE_PACKET);
    public final static String CHOOSING_COFFEE_MESSAGE = String.format("""
                    If you want then write a type of coffee*.
                    If you want to get a number of all coffees write 0.
                    String.format("*one of %s %s %s %s""",
            CoffeeType.COFFEE_BEANS, CoffeeType.GROUND_COFFEE, CoffeeType.INSTANT_COFFEE_JAR,
            CoffeeType.INSTANT_COFFEE_PACKET);
    public final static String PRICE_FILTER_MESSAGE = "Enter min price and max price to get a list of filtered items.";
    public final static String MAIN_MENU = "You are in the main menu.";
}