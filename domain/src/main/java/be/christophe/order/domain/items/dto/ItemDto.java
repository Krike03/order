package be.christophe.order.domain.items.dto;

import java.util.Objects;

public class ItemDto {
    private final String id;
    private final String name;
    private final String description;
    private final double price;
    private final String currency;
    private final int amountStock;

    public ItemDto(String id, String name, String description, double price, String currency, int amountStock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.currency = currency;
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

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public int getAmountStock() {
        return amountStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDto itemDto = (ItemDto) o;
        return Double.compare(itemDto.price, price) == 0 && amountStock == itemDto.amountStock && Objects.equals(id, itemDto.id) && Objects.equals(name, itemDto.name) && Objects.equals(description, itemDto.description) && Objects.equals(currency, itemDto.currency);
    }
}
