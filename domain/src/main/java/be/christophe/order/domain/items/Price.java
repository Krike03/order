package be.christophe.order.domain.items;

public class Price {
    private double price;
    private String currency;

    public Price(double price, String currency) {
        this.price = price;
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}
