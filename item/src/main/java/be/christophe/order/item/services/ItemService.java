package be.christophe.order.item.services;

import be.christophe.order.domain.items.Price;
import be.christophe.order.domain.items.dto.ItemDto;
import be.christophe.order.domain.items.dto.UpdateItemDto;
import be.christophe.order.domain.service.Mapper;
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

    public ItemDto insertItem(ItemDto itemDto) {
        return Mapper.mapper(itemRepository.insertItem(Mapper.mapper(itemDto)));
    }

    public int getItemStockAmountById(String itemId) {
        return itemRepository.getItemStockAmountById(itemId);
    }

    public Price getPriceOfItemAtDate(String itemId, LocalDateTime localDate) {
        return itemRepository.getItemPrice(itemId, localDate);
    }

    public ItemDto updateItem(String id, UpdateItemDto updateItemDto, String authorization) {
        userController.login(authorization);
        return Mapper.mapper(itemRepository.updateItem(id, updateItemDto));
    }
}
