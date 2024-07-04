package cy.markelova.coffee._main;

import cy.markelova.coffee.entity.CoffeeVan;
import cy.markelova.coffee.service.MenuActions;

public class _Main {

    public static void main(String[] args) {
        CoffeeVan coffeeVan = new CoffeeVan(1000);
        MenuActions menu = new MenuActions();
        menu.runMenu(coffeeVan);
    }
}
