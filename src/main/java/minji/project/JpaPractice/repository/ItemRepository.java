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


    public Long saveItem(Item item) {
        if(item.getId() == null)
            em.persist(item);
        else
            em.merge(item);

        return item.getId();
    }

    public List<Item> findAll() {
        return em.createQuery("select m from Item m", Item.class).getResultList();
    }

    public Item findItemById(Long id) {
        return em.find(Item.class, id);
    }

    public void deleteItem(Item item) {
        em.remove(item);
    }
}
