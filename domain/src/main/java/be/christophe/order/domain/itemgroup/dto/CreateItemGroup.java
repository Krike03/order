package be.christophe.order.domain.itemgroup.dto;

public class CreateItemGroup {
    private final String itemId;
    private final int amount;

    public CreateItemGroup(String itemId, int amount) {
        this.itemId = itemId;
        this.amount = amount;
    }

    public String getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }
}
