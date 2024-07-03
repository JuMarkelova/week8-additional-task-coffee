package cy.markelova.coffee.entity;

import java.util.ArrayList;
import java.util.List;

public class CoffeeVan {

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

    public boolean reduceAvailableSpace(int value) {
        boolean operationFinishedSuccessfully = false;
        if (value < this.availableVolume) {
            this.availableVolume = this.availableVolume - value;
            operationFinishedSuccessfully = true;
        } else System.out.println("It is not enough space in this van.");
        return operationFinishedSuccessfully;
    }
}