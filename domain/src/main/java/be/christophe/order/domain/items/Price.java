package be.christophe.order.domain.items;

import java.time.LocalDateTime;

public class Price {
    private final double price;
    private final String currency;
    private final LocalDateTime localDate;

    public Price(double price, String currency) {
        this.price = price;
        this.currency = currency;
        localDate = LocalDateTime.now();

    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public LocalDateTime getLocalDate() {
        return localDate;
    }
}
