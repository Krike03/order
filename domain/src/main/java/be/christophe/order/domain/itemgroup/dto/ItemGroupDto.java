package be.christophe.order.domain.itemgroup.dto;

import java.time.LocalDateTime;

public class ItemGroupDto {
    private final String id;
    private final int itemId;
    private final String userId;
    private final String totalPrice;
    private final int amount;
    private final LocalDateTime localDate;

    public ItemGroupDto(String id, int itemId, String userId, String totalPrice, int amount, LocalDateTime localDate) {
        this.id = id;
        this.itemId = itemId;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.amount = amount;
        this.localDate = localDate;
    }

    public String getId() {
        return id;
    }

    public int getItemId() {
        return itemId;
    }

    public String getUserId() {
        return userId;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDateTime getLocalDate() {
        return localDate;
    }
}
