package cy.markelova.coffee.service;

import cy.markelova.coffee.entity.CoffeeType;

public interface Analytics {

    long countItems(CoffeeType type);
    double countPrice(CoffeeType type);
}
