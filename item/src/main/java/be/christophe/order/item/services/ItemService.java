package be.christophe.order.item.services;

import be.christophe.order.domain.items.dto.ItemDto;
import be.christophe.order.domain.service.Mapper;
import be.christophe.order.item.repositories.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public ItemDto insertItem(ItemDto itemDto) {
        return Mapper.mapper(repository.insertItem(Mapper.mapper(itemDto)));
    }
}
