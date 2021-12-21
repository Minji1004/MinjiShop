package minji.project.JpaPractice.repository;

import minji.project.JpaPractice.domain.item.Item;
import minji.project.JpaPractice.domain.order.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class OrderRepository {

    @PersistenceContext
    EntityManager em;


    public Long saveOrder(Order order) {
        if(order.getId() == null)
            em.persist(order);
        else
            em.merge(order);

        return order.getId();
    }

}
