package cy.markelova.coffee.entity;

public class Coffee {

    private String name;
    private int volume;
//    private String type;
    private CoffeeType type;

    private double price;
    private CoffeeVan coffeeVan;

    public Coffee(String name, int volume, CoffeeType type, double price, CoffeeVan van) {
        this.name = name;
        this.volume = volume;
        this.price = price;
        switch (type) {
            case COFFEE_BEANS: {
                this.type = CoffeeType.COFFEE_BEANS;
                break;
            }
            case GROUND_COFFEE: {
                this.type = CoffeeType.GROUND_COFFEE;
                break;
            }
            case INSTANT_COFFEE_JAR: {
                this.type = CoffeeType.INSTANT_COFFEE_JAR;
                break;
            }
            case INSTANT_COFFEE_PACKET: {
                this.type = CoffeeType.INSTANT_COFFEE_PACKET;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CoffeeType getType() {
        return type;
    }

    public void setType(CoffeeType type) {
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
