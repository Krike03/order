package be.christophe.order.domain.items;

import be.christophe.order.domain.localdatetime.ILocalDate;

import java.time.LocalDateTime;

public class Price {
    private final double price;
    private final String currency;
    private final LocalDateTime localDate;

    public Price(double price, String currency, ILocalDate localDate) {
        this.price = price;
        this.currency = currency;
        this.localDate = localDate.now();
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
