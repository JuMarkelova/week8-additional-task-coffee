package cy.markelova.coffee.service;

import cy.markelova.coffee.entity.Coffee;

import java.util.List;

public interface Analytics {

    long countLoadedItems();
    double sumPriceLoadedItems();
    List<Coffee> sortByPrice();
    List<Coffee> sortByWeight();
}
