package be.christophe.order.item.services;

import be.christophe.order.domain.itemgroup.ItemGroup;
import be.christophe.order.domain.itemgroup.dto.CreateItemGroup;
import be.christophe.order.domain.itemgroup.dto.ItemGroupDto;
import be.christophe.order.domain.localdatetime.ILocalDate;
import be.christophe.order.item.domain.items.Item;
import be.christophe.order.item.domain.items.Price;
import be.christophe.order.item.domain.items.dto.*;

import java.time.LocalDateTime;

public class ItemMapper {

    private ILocalDate localDate;

    public ItemMapper(ILocalDate localDate) {
        this.localDate = localDate;
    }

    public Item mapper(ItemDto itemDto) {
        return new Item(itemDto.getName(),
                itemDto.getDescription(),
                new Price(itemDto.getPrice(), itemDto.getCurrency(), localDate),
                itemDto.getAmountStock());
    }

    public  Item mapper(CreateItemDto createItemDto) {
        return new Item(
                createItemDto.getName(),
                createItemDto.getDescription(),
                new Price(createItemDto.getPrice(),
                        createItemDto.getCurrency(),
                        localDate),
                createItemDto.getAmountStock()
        );
    }

    public Item mapper(Item item, Price price){
        item.setPrice(price);
        return item;
    }

    public ItemDto mapper(Item item) {
        return new ItemDto(item.getId(),
                item.getName(),
                item.getDescription(),
                item.getPrice().getPrice(),
                item.getPrice().getCurrency(),
                item.getAmountStock());
    }

    public ItemGroup mapper(CreateItemGroup createItemGroup,
                                         String userId, LocalDateTime shippingDate) {
        return new ItemGroup(createItemGroup.getItemId(),
                userId,
                createItemGroup.getAmount(),
                shippingDate);
    }

    public ItemGroupDto mapper(ItemGroup newItemGroup, String totalPrice) {
        return new ItemGroupDto(newItemGroup.getId(),
                newItemGroup.getItemId(),
                newItemGroup.getUserId(),
                totalPrice, newItemGroup.getAmount(),
                newItemGroup.getLocalDate());
    }


    public Item mapper(CreateItemDto createItemDto, Price price) {
        return new Item(
                createItemDto.getName(),
                createItemDto.getDescription(),
                price,
                createItemDto.getAmountStock()
        );
    }
}
