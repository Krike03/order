package be.christophe.order.item.repositories;

import be.christophe.order.domain.items.Item;
import be.christophe.order.domain.items.Price;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ItemRepositoryTest {

    @Test
    void insertItem() {
        Item item = new Item("name", "description", new Price(5.99, "EUR"), 5);
        ItemRepository itemRepository = new ItemRepository();

        assertThat(itemRepository.insertItem(item)).isInstanceOf(Item.class);
        assertThat(itemRepository.getAllItems()).contains(item);
    }
}