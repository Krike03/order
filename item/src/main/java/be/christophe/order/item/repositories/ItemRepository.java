package be.christophe.order.item.repositories;

import be.christophe.order.domain.localdatetime.ILocalDate;
import be.christophe.order.item.domain.items.Item;
import be.christophe.order.item.domain.items.Price;
import be.christophe.order.item.domain.items.dto.UpdateItemDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ItemRepository {
    @PersistenceContext
    private EntityManager entityManager;

    ILocalDate localDate;

    public ItemRepository(ILocalDate localDate) {
        this.localDate = localDate;
    }

    public Item insertItem(Item item) {
        entityManager.persist(item);
        return item;
    }

    public List<Item> getAllItems() {
        return entityManager.createQuery("select i from Item i", Item.class)
                .getResultList();
    }

    public int getItemStockAmountById(int itemId) {
        Item foundItem = getItemById(itemId);
        if (foundItem == null){
            return 0;
        }
        return foundItem.getAmountStock();
    }

    public Price getItemPrice(int itemId, LocalDateTime localDate) {
        Item foundItem = getItemById(itemId);
        if (foundItem == null){
            throw new NullPointerException("item doesn't exist");
        }
        return foundItem.getPrice(localDate);
    }

    public Item updateItem(int id, UpdateItemDto updateItemDto) {
        Item item = getItemById(id);
        item.setName(updateItemDto.getName());
        item.setDescription(updateItemDto.getDescription());
        item.setPrice(new Price(updateItemDto.getPrice(), updateItemDto.getCurrency(), localDate));
        item.setAmountStock(updateItemDto.getAmountStock());

        return item;
    }

    public Item getItemById(int itemId) {

        TypedQuery<Item> query = entityManager.createQuery("select i from Item i where i.id = :itemId", Item.class);

        return query.setParameter("itemId", itemId)
                .getSingleResult();
    }

    public List<Item> getItemByName(String searchTerm) {
        return entityManager.createQuery("select i from Item  i where i.name = :searchTerm", Item.class)
                .setParameter("searchTerm", searchTerm)
                .getResultList();
    }
}
