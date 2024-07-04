package cy.markelova.coffee.service;

import cy.markelova.coffee.entity.Coffee;
import cy.markelova.coffee.entity.CoffeeType;
import cy.markelova.coffee.entity.CoffeeVan;

import java.util.Scanner;

public class MenuActions {

    String instructionsMenu = """
             Select an option:
             0 - show the instruction
             1 - load a coffee
             2 - get info about van
             3 - get a list of loaded coffee sorted by price
             4 - get a list of loaded coffee by volume
             5 - get a number of loaded items
             6 - get a sum of loaded items
             7 - get an amount of available space in a van
             8 - get a list of coffee filtered by min and max price
             exit - exit
            """;
    String instructionsLoadingCoffee = String.format("""
                    Enter 4 parameters of coffee separated by spaces (or exit):
                    name volume type* price
                    * one of %s %s %s %s""",
            CoffeeType.COFFEE_BEANS, CoffeeType.GROUND_COFFEE, CoffeeType.INSTANT_COFFEE_JAR,
            CoffeeType.INSTANT_COFFEE_PACKET);

    public void runMenu(CoffeeVan van) {
        boolean isLoadingCoffee = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println(instructionsMenu);

        while (isLoadingCoffee) {
            String userOption = scanner.nextLine();
            switch (userOption) {
                case "0": {
                    System.out.println(instructionsMenu);
                    break;
                }
                case "1": {
                    System.out.println(instructionsLoadingCoffee);
                    String[] parameters = scanner.nextLine().split(" ");
                    if (parameters[0].equals("exit")) {
                        System.out.println("You are in the main menu.");
                        break;
                    } else loadCoffee(parameters, van);
                    break;
                }
                case "2": {
                    System.out.println(van);
                    break;
                }
                case "3": {
                    van.printListOfCoffee(van.sortByPrice());
                    break;
                }
                case "4": {
                    van.printListOfCoffee(van.sortByWeight());
                    break;
                }
                case "5": {
                    System.out.println("If you want write a type of coffee*. If you want to get a number of all coffees write 0.\n"
                            + String.format("* one of %s %s %s %s",
                            CoffeeType.COFFEE_BEANS, CoffeeType.GROUND_COFFEE, CoffeeType.INSTANT_COFFEE_JAR,
                            CoffeeType.INSTANT_COFFEE_PACKET));
                    userOption = scanner.nextLine();
                    if (userOption.equals("0")) {
                        van.printNumberItems(van.countItems());
                    } else
                        van.printNumberItems(van.countItems(CoffeeType.valueOf(userOption)), CoffeeType.valueOf(userOption));
                    break;
                }
                case "6": {
                    System.out.println("If you want write a type of coffee*. If you want to get a number of all coffees write 0.");
                    userOption = scanner.nextLine();
                    if (userOption.equals("0")) {
                        van.printPrice(van.sumPrice());
                    } else van.printPrice(van.sumPrice(CoffeeType.valueOf(userOption)), CoffeeType.valueOf(userOption));
                    break;
                }
                case "7": {
                    System.out.println("Available space in this van is " + van.getAvailableVolume());
                    break;
                }
                case "8": {
                    System.out.println("Enter min price and max price to get a list of filtered items.");
                    double minFilterPrice = Double.parseDouble(scanner.nextLine());
                    double maxFilterPrice = Double.parseDouble(scanner.nextLine());
                    van.printListOfCoffee(van.findItem(minFilterPrice, maxFilterPrice));
                    break;
                }
                case "exit": {
                    isLoadingCoffee = false;
                    break;
                }
                default: {
                    System.out.println("There is no such option.");
                }
            }
        }
    }

    public void loadCoffee(String[] parameters, CoffeeVan van) {
        String name = parameters[0];
        String volume = parameters[1];
        String type = parameters[2];
        String price = parameters[3];

        Coffee coffee = new Coffee(name,
                Integer.parseInt(volume),
                CoffeeType.valueOf(type),
                Double.parseDouble(price),
                van);
        System.out.println("Coffee added successfully: " + coffee);
    }
}
