package be.christophe.order.item.repositories;

import be.christophe.order.domain.items.Item;
import be.christophe.order.domain.items.Price;
import be.christophe.order.domain.items.dto.UpdateItemDto;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepository {
    private final Map<String, Item> items;

    public ItemRepository() {
        items = new ConcurrentHashMap<>();
        Item item = new Item("name", "description", new Price(4.33, "EUR"), 5);
        items.put(item.getId(), item);
    }

    public Item insertItem(Item item) {
        items.put(item.getId(), item);
        return item;
    }

    public List<Item> getAllItems() {
        return items.values().stream().toList();
    }

    public int getItemStockAmountById(String itemId) {
        return items.get(itemId).getAmountStock();
    }

    public Price getItemPrice(String itemId, LocalDateTime localDate) {
        return items.get(itemId).getPrice(localDate);
    }

    public Item updateItem(String id, UpdateItemDto updateItemDto) {
        Item item = items.get(id);
        item.setName(updateItemDto.getName());
        item.setDescription(updateItemDto.getDescription());
        item.setPrice(new Price(updateItemDto.getPrice(), updateItemDto.getCurrency()));
        item.setAmountStock(updateItemDto.getAmountStock());

        return item;
    }
}
