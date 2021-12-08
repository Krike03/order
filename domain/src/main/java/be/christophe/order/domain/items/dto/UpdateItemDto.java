package be.christophe.order.domain.items.dto;

public class UpdateItemDto {
    private final String name;
    private final String description;
    private final double price;
    private final String currency;
    private final int amountStock;

    public UpdateItemDto(String name, String description, double price, String currency, int amountStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.currency = currency;
        this.amountStock = amountStock;
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
}
