package be.christophe.order.item.services;

import be.christophe.order.domain.items.Item;
import be.christophe.order.domain.items.Price;
import be.christophe.order.domain.items.dto.CreateItemDto;
import be.christophe.order.domain.items.dto.ItemDto;
import be.christophe.order.domain.items.dto.UpdateItemDto;
import be.christophe.order.domain.service.ItemMapper;
import be.christophe.order.item.api.UserController;
import be.christophe.order.item.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ItemService {
    ItemRepository itemRepository;
    UserController userController;

    public ItemService(ItemRepository repository, UserController userController) {
        this.itemRepository = repository;
        this.userController = userController;
    }

    public ItemDto insertItem(CreateItemDto createItemDto) {
        if(createItemDto==null){ throw new NullPointerException("No item is added, a null object is given.");}
        Item item = ItemMapper.mapperToItem(createItemDto);
        Item returnedItem = itemRepository.insertItem(item);
        ItemDto itemDto = ItemMapper.mapperToItemDto(returnedItem);
        return itemDto;
    }

    public int getItemStockAmountById(String itemId) {
        if(itemId == null){ throw new NullPointerException("Id is null");}
        return itemRepository.getItemStockAmountById(itemId);
    }

    public Price getPriceOfItemAtDate(String itemId, LocalDateTime localDate) {
        return itemRepository.getItemPrice(itemId, localDate);
    }

    public ItemDto updateItem(String id, UpdateItemDto updateItemDto, String authorization) {
        userController.login(authorization);
        return ItemMapper.mapperToItemDto(itemRepository.updateItem(id, updateItemDto));
    }
}
