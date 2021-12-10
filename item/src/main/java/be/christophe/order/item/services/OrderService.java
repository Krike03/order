package be.christophe.order.item.services;

import be.christophe.order.domain.itemgroup.ItemGroup;
import be.christophe.order.domain.itemgroup.dto.CreateItemGroup;
import be.christophe.order.domain.itemgroup.dto.ItemGroupDto;
import be.christophe.order.domain.items.Price;
import be.christophe.order.domain.service.ItemMapper;
import be.christophe.order.item.api.UserController;
import be.christophe.order.item.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {
    OrderRepository orderRepository;
    ItemService itemService;
    UserController userController;

    public OrderService(OrderRepository orderRepository, ItemService itemService, UserController userController) {
        this.orderRepository = orderRepository;
        this.itemService = itemService;
        this.userController = userController;
    }

    public ItemGroupDto putItemGroup(CreateItemGroup createItemGroup, String authorization) {
        String userId = userController.login(authorization);
        int stock = itemService.getItemStockAmountById(createItemGroup.getItemId());
        ItemGroup newItemGroup = ItemMapper.mapper(createItemGroup,
                userId,
                calculateShippingTime(createItemGroup, stock));
        orderRepository.putNewItemGroup(newItemGroup);
        return ItemMapper.mapper(newItemGroup, calculatePrice(newItemGroup));
    }

    private String calculatePrice(ItemGroup newItemGroup) {
        Price price = itemService.getPriceOfItemAtDate(newItemGroup.getItemId(), newItemGroup.getLocalDate());
        Double totalPrice = newItemGroup.getAmount() * price.getPrice();
        return totalPrice + price.getCurrency();
    }

    private LocalDateTime calculateShippingTime(CreateItemGroup createItemGroup, int stock) {
        return stock > createItemGroup.getAmount() ?
                    LocalDateTime.now().plusDays(1): LocalDateTime.now().plusDays(7);
    }
}
