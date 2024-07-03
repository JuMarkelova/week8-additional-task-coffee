package cy.markelova.coffee.entity;

public class Coffee {

    private String name;
    private int volume;
    private String type;
    private CoffeeVan coffeeVan;

    public Coffee(String name, int volume, CoffeeType type, CoffeeVan van) {
        this.name = name;
        this.volume = volume;
        switch (type) {
            case COFFEE_BEANS: {
                this.type = "coffee beans";
                break;
            }
            case GROUND_COFFEE: {
                this.type = "ground coffee";
                break;
            }
            case INSTANT_COFFEE_JAR: {
                this.type = "instant coffee jar";
                break;
            }
            case INSTANT_COFFEE_PACKET: {
                this.type = "instant coffee packet";
                break;
            }
        }
        if (van.reduceAvailableSpace(volume)) {
            this.coffeeVan = van;
            van.setCoffees(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CoffeeVan getCoffeeVan() {
        return coffeeVan;
    }

    public void setCoffeeVan(CoffeeVan coffeeVan) {
        this.coffeeVan = coffeeVan;
    }

    @Override
    public String toString() {
        return "Coffee: {" + "name = " + name + ", volume = " + volume + " gr, type = " + type + ", coffeeVan = " + coffeeVan + "}";
    }
}
