package be.christophe.order.item.services;

import be.christophe.order.domain.localdatetime.ILocalDate;
import be.christophe.order.item.api.UserController;
import be.christophe.order.item.domain.items.Item;
import be.christophe.order.item.domain.items.Price;
import be.christophe.order.item.domain.items.dto.CreateItemDto;
import be.christophe.order.item.domain.items.dto.ItemDto;
import be.christophe.order.item.domain.items.dto.UpdateItemDto;
import be.christophe.order.item.repositories.ItemRepository;
import be.christophe.order.item.repositories.PriceRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final PriceRepository priceRepository;
    private final UserController userController;
    private final ILocalDate localDate;
    private final ItemMapper itemMapper;

    public ItemService(ItemRepository repository, PriceRepository priceRepository, UserController userController, ILocalDate localDate) {
        this.itemRepository = repository;
        this.priceRepository = priceRepository;
        this.userController = userController;
        this.localDate = localDate;
        itemMapper = new ItemMapper(localDate);
    }

    @Transactional
    public int insertItem(CreateItemDto createItemDto) {
        if(createItemDto==null){ throw new NullPointerException("No item is added, a null object is given.");}
        Price price = priceRepository.addPrice(new Price(createItemDto.getPrice(), createItemDto.getCurrency(), localDate));
        if(price ==null){throw new NullPointerException("No price is given");}
        Item item = itemMapper.mapper(createItemDto, price);
        item = itemRepository.insertItem(item);
        ItemDto itemDto = itemMapper.mapper(item);
        return itemDto.getId();
    }

    public int getItemStockAmountById(Integer itemId) {
        if(itemId == null){ throw new NullPointerException("Id is null");}
        return itemRepository.getItemStockAmountById(itemId);
    }

    public Price getPriceOfItemAtDate(int itemId, LocalDateTime localDate) {
        return itemRepository.getItemPrice(itemId, localDate);
    }

    @Transactional
    public ItemDto updateItem(int itemId, UpdateItemDto updateItemDto, String authorization) {
        //userController.login(authorization);

        Price newPrice = new Price(updateItemDto.getPrice(), updateItemDto.getCurrency(), localDate);
        newPrice = priceRepository.addPrice(newPrice);
        if(newPrice == null){
            throw new NullPointerException("no price is given");
        }

        Item item = itemRepository.getItemById(itemId);
        item.setName(updateItemDto.getName());
        item.setDescription(updateItemDto.getDescription());
        item.setPrice(newPrice);
        item.setAmountStock(updateItemDto.getAmountStock());

        return itemMapper.mapper(item);
    }

    public List<ItemDto> getAll() {
        return itemRepository.getAllItems().stream()
                .map(item -> itemMapper.mapper(item))
                .collect(Collectors.toList());
    }

    public List<ItemDto> searchItem(String searchTerm) {
        return itemRepository.getItemByName(searchTerm).stream()
                .map(item -> itemMapper.mapper(item))
                .collect(Collectors.toList());
    }

    public ItemDto getItemById(int id) {
        return itemMapper.mapper(itemRepository.getItemById(id));
    }
}
