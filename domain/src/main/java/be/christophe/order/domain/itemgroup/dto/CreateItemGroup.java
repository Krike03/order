package be.christophe.order.domain.itemgroup.dto;

public class CreateItemGroup {
    private final int itemId;
    private final int amount;

    public CreateItemGroup(int itemId, int amount) {
        this.itemId = itemId;
        this.amount = amount;
    }

    public int getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }
}
