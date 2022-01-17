package be.christophe.order.item.api;

import be.christophe.order.item.domain.items.dto.CreateItemDto;
import be.christophe.order.item.domain.items.dto.ItemDto;
import be.christophe.order.item.domain.items.dto.UpdateItemDto;
import be.christophe.order.item.services.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping( path = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemController {
    ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDto> getItems(@RequestParam(name = "search", required = false) String searchTerm){
        if(searchTerm != null){
            itemService.searchItem(searchTerm);
        }
        return itemService.getAll();
    }

    @GetMapping(path= "{id}")
    @ResponseStatus(HttpStatus.OK)
    public ItemDto getItembyId(@PathVariable("id") int id){
        return itemService.getItemById(id);
    }

    @PutMapping(path = "{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
//    @PreAuthorize("hasAuthority('GET_CUSTOMER_HELLO_WORLD')")
    @ResponseStatus(HttpStatus.OK)
    public ItemDto putItem(@RequestBody UpdateItemDto updateItemDto,
                           @PathVariable("id") int id,
                           @RequestHeader(name ="Authorization",  required = false ) String authorization){
        return itemService.updateItem(id, updateItemDto, authorization);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public int postItem(@RequestBody CreateItemDto createItemDto){
        return itemService.insertItem(createItemDto);
    }
}
