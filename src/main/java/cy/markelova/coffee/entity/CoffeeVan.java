package cy.markelova.coffee.entity;

import cy.markelova.coffee.service.Analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CoffeeVan implements Analytics {

    int count = 0;
    private int volume;
    private int availableVolume;
    private final long NUMBER;
    private List<Coffee> coffees = new ArrayList<>();

    public CoffeeVan(int volume) {
        this.NUMBER = ++count;
        this.volume = volume;
        this.availableVolume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public long getNumber() {
        return NUMBER;
    }

    public int getAvailableVolume() {
        return availableVolume;
    }

    public void setAvailableVolume(int availableVolume) {
        this.availableVolume = availableVolume;
    }

    public List<Coffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(Coffee coffee) {
        this.coffees.add(coffee);
    }

    @Override
    public String toString() {
        return "Coffee Van: {"
                + " volume = " + volume
                + ", availableVolume = " + getAvailableVolume() + "}";
    }

    @Override
    public long countLoadedItems() {
        return this.getCoffees().size();
    }

    public long countLoadedItems(CoffeeType type) {
        return this.getCoffees().stream().filter(coffee -> coffee.getType() == type).count();
    }

    @Override
    public double sumPriceLoadedItems() {
        double priceDouble = 0;
        Optional<Double> price = this.getCoffees().stream()
                .map(coffee -> coffee.getPrice()).reduce((prev, next) -> prev + next);
        if (price.isPresent()) {
            priceDouble = price.get();
        }
        return priceDouble;
    }

    public double sumPriceLoadedItems(CoffeeType type) {
        double priceDouble = 0;
        Optional<Double> price = this.getCoffees().stream()
                .filter(coffee -> coffee.getType() == type)
                .map(coffee -> coffee.getPrice()).reduce((prev, next) -> prev + next);
        if (price.isPresent()) {
            priceDouble = price.get();
        }
        return priceDouble;
    }

    @Override
    public List<Coffee> sortByPrice() {
        return coffees.stream().
                sorted((coffee1, coffee2) -> Double.compare(coffee1.getPrice(), coffee2.getPrice())).
                toList();
    }

    @Override
    public List<Coffee> sortByWeight() {
        return coffees.stream().
                sorted((coffee1, coffee2) -> Double.compare(coffee1.getWeight(), coffee2.getWeight())).
                toList();
    }

    public void printListOfCoffee(List<Coffee> coffees) {
        coffees.stream().forEach(coffee -> System.out.println(coffee));
    }

    public boolean reduceAvailableSpace(int value) {
        boolean operationFinishedSuccessfully = false;
        if (value <= this.availableVolume) {
            this.availableVolume = this.availableVolume - value;
            operationFinishedSuccessfully = true;
        } else System.out.println("It is not enough space in this van.");
        return operationFinishedSuccessfully;
    }

    public void printNumberItems(long count, CoffeeType type) {
        if (count == 0) {
            System.out.printf("There is no items of type %s in this van yet.\n", type);
        } else if (count == 1) {
            System.out.printf("There is 1 item of type %s in this van.\n", type);
        } else {
            System.out.printf("There are %d items of type %s in this van.\n", count, type);
        }
    }

    public void printNumberItems(long count) {
        if (count == 0) {
            System.out.println("There is no items of all types in this van yet.\n");
        } else if (count == 1) {
            System.out.printf("There is %d item of all types in this van.\n", count);
        } else {
            System.out.printf("There are %d items of all types in this van.\n", count);
        }
    }

    public void printPrice(double count, CoffeeType type) {
        System.out.printf("The price for items of type %s in this van is %.2f.\n", type, count);
    }

    public void printPrice(double count) {
        System.out.printf("The price for items of all types in this van is %.2f.\n", count);
    }

    public List<Coffee> findItem(double minPrice, double maxPrice) {
        return coffees.stream().filter(coffee -> coffee.getPrice() >= minPrice && coffee.getPrice() <= maxPrice).collect(Collectors.toList());
    }
}