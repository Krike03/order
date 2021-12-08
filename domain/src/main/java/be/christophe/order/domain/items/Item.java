package be.christophe.order.domain.items;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class Item {
    private final String id;
    private String name;
    private String description;
    private List<Price> prices;
    private int amountStock;

    public Item(String name, String description, Price price, int amountStock) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        prices = new ArrayList<>();
        prices.add(price);
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
        return prices.stream()
                .max(Comparator.comparing(Price::getLocalDate))
                .orElse(null);
    }

    public Price getPrice(LocalDateTime date) {
        return prices.stream()
                .filter(price -> price.getLocalDate().isBefore(date))
                .max(Comparator.comparing(Price::getLocalDate))
                .orElse(null);
    }

    public int getAmountStock() {
        return amountStock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Price price) {
        prices.add(price);
    }

    public void setAmountStock(int amountStock) {
        this.amountStock = amountStock;
    }
}
