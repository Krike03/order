package be.christophe.order.item.domain.items;

import be.christophe.order.domain.localdatetime.ILocalDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "price")
public class Price {

    @Id
    @SequenceGenerator(name = "price_seq", sequenceName = "price_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "price_seq")
    @Column(name = "id")
    private int id;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "currency")
    private String currency;

    @Column(name = "date", columnDefinition= "DATETIME")
    private LocalDateTime localDate;


    public Price(double price, String currency, ILocalDate localDate) {
        this.price = price;
        this.currency = currency;
        this.localDate = localDate.now();
    }

    private Price() {
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
