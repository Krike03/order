package be.christophe.order.item.api;

import be.christophe.order.domain.itemgroup.dto.CreateItemGroup;
import be.christophe.order.domain.itemgroup.dto.ItemGroupDto;
import be.christophe.order.item.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( path = "/orders")
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemGroupDto postItemGroup(@RequestBody CreateItemGroup createItemGroup,
                                      @RequestHeader("Authorization") String authorization){
       return orderService.putItemGroup(createItemGroup, authorization);
    }
}
