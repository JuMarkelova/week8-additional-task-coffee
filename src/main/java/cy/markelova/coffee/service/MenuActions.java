package cy.markelova.coffee.service;

import cy.markelova.coffee.entity.Coffee;
import cy.markelova.coffee.entity.CoffeeType;
import cy.markelova.coffee.entity.CoffeeVan;

import java.util.Scanner;

import static cy.markelova.coffee.service.MenuMessages.*;

public class MenuActions {

    public void runMenu(CoffeeVan van) {
        boolean isLoadingCoffee = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println(INSTRUCTIONS_MENU);

        while (isLoadingCoffee) {
            System.out.println(MAIN_MENU);
            String userOption = scanner.nextLine();
            switch (userOption) {
                case "0": {
                    System.out.println(INSTRUCTIONS_MENU);
                    break;
                }
                case "1": {
                    System.out.println(INSTRUCTIONS_LOADING_COFFEE);
                    String[] parameters = scanner.nextLine().split(" ");
                    if (parameters[0].equals("exit")) {
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
                    System.out.println(CHOOSING_COFFEE_MESSAGE);
                    userOption = scanner.nextLine();
                    if (userOption.equals("0")) {
                        van.printNumberItems(van.countLoadedItems());
                    } else
                        van.printNumberItems(van.countLoadedItems(CoffeeType.valueOf(userOption)), CoffeeType.valueOf(userOption));
                    break;
                }
                case "6": {
                    System.out.println(CHOOSING_COFFEE_MESSAGE);
                    userOption = scanner.nextLine();
                    if (userOption.equals("0")) {
                        van.printPrice(van.sumPriceLoadedItems());
                    } else
                        van.printPrice(van.sumPriceLoadedItems(CoffeeType.valueOf(userOption)), CoffeeType.valueOf(userOption));
                    break;
                }
                case "7": {
                    System.out.println("Available space in this van is " + van.getAvailableVolume());
                    break;
                }
                case "8": {
                    System.out.println(PRICE_FILTER_MESSAGE);
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