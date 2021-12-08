package be.christophe.order.item.repositories;

import be.christophe.order.domain.itemgroup.ItemGroup;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class OrderRepository {
    private final ConcurrentHashMap<String, ItemGroup> itemGroups;

    public OrderRepository() {
        itemGroups = new ConcurrentHashMap<>();
    }

    public void putNewItemGroup(ItemGroup newItemGroup) {
        itemGroups.put(newItemGroup.getId(), newItemGroup);
    }
}
