package be.christophe.order.item.repositories;

import be.christophe.order.item.domain.items.Price;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PriceRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Price addPrice(Price price){
        entityManager.persist(price);
        return price;
    }
}
