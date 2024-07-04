package cy.markelova.coffee.entity;

public class Coffee {

    private String name;
    private int weight;
    private CoffeeType type;
    private double price;
    private CoffeeVan coffeeVan;

    public Coffee(String name, int weight, CoffeeType type, double price, CoffeeVan van) {
        this.name = name;
        this.weight = weight;
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
        if (van.reduceAvailableSpace(weight)) {
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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
        return String.format("Coffee {name: %-10s, wight: %-4d gr, type: %-21s, price: %-6.2f, coffee van: %3d}",
                name, weight, type, price, coffeeVan.getNumber());
    }
}