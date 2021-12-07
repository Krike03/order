package be.christophe.order.domain.items;

public class Item {
    private final String name;
    private final String description;
    private Price price;
    private int amountStock;

    public Item(String name, String description, Price price, int amountStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountStock = amountStock;
    }
}
