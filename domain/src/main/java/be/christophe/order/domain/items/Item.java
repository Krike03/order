package be.christophe.order.domain.items;

import java.util.UUID;

public class Item {
    private final String id;
    private final String name;
    private final String description;
    private Price price;
    private int amountStock;

    public Item(String name, String description, Price price, int amountStock) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountStock = amountStock;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Price getPrice() {
        return price;
    }

    public int getAmountStock() {
        return amountStock;
    }
}
