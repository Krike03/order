package be.christophe.order.item.domain.items;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Entity
@Table(name="item")
public class Item {
    @Id
    @SequenceGenerator(name = "item_seq", sequenceName = "item_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany
    @JoinColumn(name = "fk_item")
    private List<Price> prices = new ArrayList<>();

    @Column(name = "amountstock")
    private int amountStock;

    private Item() {
    }

    public Item(String name, String description, Price price, int amountStock) {
        this.name = name;
        this.description = description;
        prices.add(price);
        this.amountStock = amountStock;
    }

    public int getId() {
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

    public List<Price> getPrices() {
        return prices;
    }
}
