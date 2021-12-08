package be.christophe.order.domain.itemgroup;

import java.time.LocalDateTime;
import java.util.UUID;

public class ItemGroup {
    private final String id;
    private final String itemId;
    private final String userId;
    private final int amount;
    private final LocalDateTime localDate;

    public ItemGroup(String itemId, String userId, int amount, LocalDateTime localDate) {
        this.userId = userId;
        id = UUID.randomUUID().toString();
        this.itemId = itemId;
        this.amount = amount;
        this.localDate = localDate;
    }

    public String getId() {
        return id;
    }

    public String getItemId() {
        return itemId;
    }

    public String getUserId() {
        return userId;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDateTime getLocalDate() {
        return localDate;
    }
}
