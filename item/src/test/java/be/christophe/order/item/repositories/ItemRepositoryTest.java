package be.christophe.order.item.repositories;

import be.christophe.order.domain.items.Item;
import be.christophe.order.domain.items.Price;
import be.christophe.order.domain.items.dto.UpdateItemDto;
import be.christophe.order.domain.localdatetime.ILocalDate;
import be.christophe.order.item.localdatetime.TestDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class ItemRepositoryTest {

    ILocalDate mockLocalDate;
    ItemRepository itemRepository;
    @BeforeEach
    void setUp() {
        mockLocalDate = new TestDateTime();
        itemRepository = new ItemRepository(mockLocalDate);
    }

    @Test
    void insertItem() {
        Item item = new Item("name", "description", new Price(5.99, "EUR", mockLocalDate), 5);

        assertThat(itemRepository.insertItem(item)).isInstanceOf(Item.class);
        assertThat(itemRepository.getAllItems()).contains(item);
    }

    @Nested
    class getAllItems{}

    @Nested
    class getItemStockAmountById{

    }

    @Nested
    class getItemPrice{

        Item item;

        @BeforeEach
        void setUp() {
            //update an item with 2 more prices
            mockLocalDate.minusDays(7);
            Price price = new Price(5.99, "EUR", mockLocalDate);
            item = new Item("name", "description", price , 5);
            itemRepository.insertItem(item);

            mockLocalDate.plusDays(4);
            UpdateItemDto updateItemDto = new UpdateItemDto("name","description", 7.99, "EUR",  5);
            itemRepository.updateItem(item.getId(), updateItemDto);

            mockLocalDate.plusDays(3);
            updateItemDto = new UpdateItemDto("name","description", 8.99, "EUR",  5);
            itemRepository.updateItem(item.getId(), updateItemDto);
        }


        @Test
        void getLatestPrice() {
            Price price = itemRepository.getItemPrice(item.getId(), LocalDateTime.now());
            assertThat(price.getPrice()).isEqualTo(8.99);
            assertThat(price.getCurrency()).isEqualTo("EUR");
        }

        @Test
        void getPrice2DaysAgo() {
            Price price = itemRepository.getItemPrice(item.getId(), LocalDateTime.now().minusDays(2));
            assertThat(price.getPrice()).isEqualTo(7.99);
            assertThat(price.getCurrency()).isEqualTo("EUR");
        }

        @Test
        void getPrice5DaysAgo() {
            Price price = itemRepository.getItemPrice(item.getId(), LocalDateTime.now().minusDays(5));
            assertThat(price.getPrice()).isEqualTo(5.99);
            assertThat(price.getCurrency()).isEqualTo("EUR");
        }

    }

    @Nested
    class  UpdateItem{

    }
}