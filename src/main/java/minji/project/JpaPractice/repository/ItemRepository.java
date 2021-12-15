package minji.project.JpaPractice.repository;

import minji.project.JpaPractice.domain.item.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ItemRepository {

    @PersistenceContext
    EntityManager em;


    public Long registerItem(Item item) {
        em.persist(item);
        return item.getId();
    }

    public List<Item> findAll() {
        return em.createQuery("select m from Item m", Item.class).getResultList();
    }
}
