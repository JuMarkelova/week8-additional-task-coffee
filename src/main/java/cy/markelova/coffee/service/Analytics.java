package cy.markelova.coffee.service;

import cy.markelova.coffee.entity.Coffee;
import cy.markelova.coffee.entity.CoffeeType;

import java.util.List;

public interface Analytics {

    long countItems(CoffeeType type);
    double sumPrice(CoffeeType type);
    List<Coffee> sortByPrice();
    List<Coffee> sortByWeight();
}
