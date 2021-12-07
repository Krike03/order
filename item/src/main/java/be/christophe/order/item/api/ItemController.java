package be.christophe.order.item.api;

import be.christophe.order.domain.items.dto.ItemDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( path = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto createItem(@RequestBody ItemDto itemDto){
        return itemDto;
    }
}
