package cy.markelova.coffee._main;

import cy.markelova.coffee.entity.Coffee;
import cy.markelova.coffee.entity.CoffeeType;
import cy.markelova.coffee.entity.CoffeeVan;

public class _Main {


    public static void main(String[] args) {
        CoffeeVan coffeeVan = new CoffeeVan(1000);
        Coffee coffee1 = new Coffee("arabic", 100, CoffeeType.COFFEE_BEANS, coffeeVan);
        Coffee coffee2 = new Coffee("arabic", 1000, CoffeeType.COFFEE_BEANS, coffeeVan);


        System.out.println(coffee1);
        System.out.println(coffee2);

        System.out.println(coffeeVan);

        System.out.println(coffeeVan.getAvailableVolume());
        System.out.println(coffeeVan);
    }

}
