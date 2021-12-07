package be.christophe.order.item.repositories;

import be.christophe.order.domain.items.Item;
import be.christophe.order.domain.items.dto.ItemDto;
import be.christophe.order.domain.users.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepository {
    private final Map<String, Item> items;

    public ItemRepository() {
        items = new ConcurrentHashMap<>();
    }

    public Item insertItem(Item item) {
        items.put(item.getId(), item);
        return item;
    }

    public List<Item> getAllItems() {
        return items.values().stream().toList();
    }
}
