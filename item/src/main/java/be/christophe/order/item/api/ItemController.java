package be.christophe.order.item.api;

import be.christophe.order.domain.items.dto.ItemDto;
import be.christophe.order.item.services.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( path = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemController {
    ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto postItem(@RequestBody ItemDto itemDto){
        return itemService.insertItem(itemDto);
    }
}
