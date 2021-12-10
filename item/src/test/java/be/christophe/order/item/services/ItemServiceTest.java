package be.christophe.order.item.services;

import be.christophe.order.domain.items.Item;
import be.christophe.order.domain.items.Price;
import be.christophe.order.domain.items.dto.CreateItemDto;
import be.christophe.order.domain.items.dto.ItemDto;
import be.christophe.order.item.api.UserController;
import be.christophe.order.item.repositories.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

class ItemServiceTest {

    ItemService itemService;
    ItemRepository itemRepository;
    @BeforeEach
    void setUp() {
        itemRepository = Mockito.mock(ItemRepository.class);
        UserController userController = Mockito.mock(UserController.class);
        itemService = new ItemService(itemRepository, userController);
    }

    @Nested
    class insertItem {
        @Test
        void addItem_givenNull() {
            Assertions.assertThatThrownBy(()->itemService.insertItem(null))
                    .isInstanceOf(NullPointerException.class)
                    .hasMessage("No item is added, a null object is given.");
        }
        @Test
        void addItem_givenValidItemIs() {
            CreateItemDto createItemDto =
                    new CreateItemDto("name", "description",
                            8.55, "Eur", 5);
            Item returnItemMock = new Item(
                    createItemDto.getName(),
                    createItemDto.getDescription(),
                    new Price(createItemDto.getPrice(), createItemDto.getCurrency()),
                    createItemDto.getAmountStock());
            ItemDto expectedItem= new ItemDto(
                    returnItemMock.getId(),
                    returnItemMock.getName(),
                    returnItemMock.getDescription(),
                    returnItemMock.getPrice().getPrice(),
                    returnItemMock.getPrice().getCurrency(),
                    returnItemMock.getAmountStock());
            Mockito.when(itemRepository.insertItem(any(Item.class)))
                    .thenReturn(returnItemMock);

            ItemDto returnedItem = itemService.insertItem(createItemDto);

            Assertions.assertThat(returnedItem).isEqualTo(expectedItem);
        }
    }

    @Nested
    class getItemStockAmountById {
        @Test
        void getItemStockAmountById_whenIdIsNull() {
            Assertions.assertThatThrownBy(()->itemService.getItemStockAmountById(null))
                    .isInstanceOf(NullPointerException.class)
                    .hasMessage("Id is null");

        }

        @Test
        void getItemStockAmountById_whenIdIsNotExcising() {
            String id = "SomeId";
            Mockito.when(itemRepository.getItemStockAmountById(id))
                    .thenReturn(0);

            Assertions.assertThat(itemService.getItemStockAmountById(id)).isEqualTo(0);
        }

        @Test
        void getItemStockAmountById_whenIdIsExcising() {
            String id = "SomeId";
            Mockito.when(itemRepository.getItemStockAmountById(id))
                    .thenReturn(10);

            Assertions.assertThat(itemService.getItemStockAmountById(id)).isEqualTo(10);
        }
    }

    @Nested
    class getPriceOfItemAtDate {

    }

    @Nested
    class updateItem {

    }
}