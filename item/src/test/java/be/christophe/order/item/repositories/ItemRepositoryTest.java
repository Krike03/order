package be.christophe.order.item.repositories;

import be.christophe.order.item.domain.items.Item;
import be.christophe.order.item.domain.items.Price;
import be.christophe.order.item.domain.items.dto.UpdateItemDto;
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

    @Nested
    class insertItem{
        Item item;
        @BeforeEach
        void setUp() {
            mockLocalDate.reset();
            item = new Item("name", "description", new Price(5.99, "EUR", mockLocalDate), 5);
        }

        @Test
        void insertItem() {
            assertThat(itemRepository.insertItem(item)).isInstanceOf(Item.class);
            assertThat(itemRepository.getAllItems()).contains(item);
        }
    }

    @Nested
    class getAllItems{
        Item item;
        @BeforeEach
        void setUp() {
            mockLocalDate.reset();
            item = new Item("name", "description", new Price(5.99, "EUR", mockLocalDate), 5);
        }
        @Test
        void noItems() {
            assertThat(itemRepository.getAllItems()).isEmpty();
        }

        @Test
        void oneItem() {
            mockLocalDate.plusDays(1);
            itemRepository.insertItem(item);
            assertThat(itemRepository.getAllItems()).contains(item);
        }
    }

    @Nested
    class getItemStockAmountById{
        Item item;
        @BeforeEach
        void setUp() {
            mockLocalDate.reset();
            item = new Item("name", "description", new Price(5.99, "EUR", mockLocalDate), 5);
        }
        @Test
        void getValidItemId() {
            itemRepository.insertItem(item);
            assertThat(itemRepository.getItemStockAmountById(item.getId())).isEqualTo(5);
        }

//        @Test
//        void getInvalidItemId() {
//            assertThat(itemRepository.getItemStockAmountById("someId")).isEqualTo(0);
//        }
    }

    @Nested
    class  UpdateItem{
        @BeforeEach
        void setUp() {
            mockLocalDate.reset();
        }

        @Test
        void updateItem() {
            mockLocalDate.minusDays(1);
            Item item = new Item("name", "description", new Price(5.99, "EUR", mockLocalDate), 5);
            itemRepository.insertItem(item);
            mockLocalDate.plusDays(1);
            UpdateItemDto updateItemDto = new UpdateItemDto("name", "description", 12.99, "Eur", 5);
            Item returnedItem = itemRepository.updateItem(item.getId(), updateItemDto);
            assertThat(returnedItem.getPrice().getPrice()).isEqualTo(12.99);
            assertThat(returnedItem.getPrice().getCurrency()).isEqualTo("Eur");

        }
    }

    @Nested
    class getItemPrice{
        Item item;
        @BeforeEach
        void setUp() {
            mockLocalDate.reset();

            //update an item with 2 more prices
            mockLocalDate.minusDays(7);
            item = new Item("name", "description", new Price(5.99, "EUR", mockLocalDate), 5);

            itemRepository.insertItem(item);

            mockLocalDate.plusDays(4);
            UpdateItemDto updateItemDto = new UpdateItemDto("name","description", 7.99, "EUR",  5);
            itemRepository.updateItem(item.getId(), updateItemDto);

            mockLocalDate.plusDays(2);
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


}