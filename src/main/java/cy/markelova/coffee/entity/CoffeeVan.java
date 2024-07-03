package cy.markelova.coffee.entity;

import cy.markelova.coffee.service.Analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CoffeeVan implements Analytics {

    private int volume;
    private int availableVolume;
    private List<Coffee> coffees = new ArrayList<>();

    public CoffeeVan(int volume) {
        this.volume = volume;
        this.availableVolume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
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
        return "Coffee Van: {" + " volume = " + volume + ", availableVolume = " + getAvailableVolume() + "}";
    }

    @Override
    public long countItems(CoffeeType type) {
        return this.getCoffees().stream().filter(coffee -> coffee.getType() == type).count();
    }

    @Override
    public double countPrice(CoffeeType type) {
        double priceDouble = 0;
        Optional<Double> price = this.getCoffees().stream()
                .filter(coffee -> coffee.getType() == type)
                .map(coffee -> coffee.getPrice()).reduce((prev, next) -> prev + next);
        if (price.isPresent()) {
            priceDouble = price.get();
        }
        return priceDouble;
    }

    public boolean reduceAvailableSpace(int value) {
        boolean operationFinishedSuccessfully = false;
        if (value < this.availableVolume) {
            this.availableVolume = this.availableVolume - value;
            operationFinishedSuccessfully = true;
        } else System.out.println("It is not enough space in this van.");
        return operationFinishedSuccessfully;
    }

    public void printCountItems(CoffeeType type) {
        long count = countItems(type);
        if (count == 0) {
            System.out.printf("There is no items with type %s in this van yet.\n", type);
        } else if (count == 1) {
            System.out.printf("There is 1 item with type %s in this van.\n", type);
        } else {
            System.out.printf("There are %d items with type %s in this van.\n", count, type);
        }
    }

    public void printPrice(CoffeeType type) {
        double count = countPrice(type);
        System.out.printf("The price for items with type %s in this van is %.2f.\n", type, count);
    }
}