package minji.project.JpaPractice.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import minji.project.JpaPractice.domain.order.Order;
import minji.project.JpaPractice.domain.order.OrderStatus;
import minji.project.JpaPractice.domain.order.QOrder;
import minji.project.JpaPractice.web.dto.OrderSearchDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

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

    public List<Order> findOrders(OrderSearchDTO orderSearch) {

        QOrder order = QOrder.order; //QOrder = new QOrder("order1"); 과 같다. order1은 별칭.
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        BooleanBuilder builder = new BooleanBuilder();
        if(StringUtils.hasText(orderSearch.getMemberName()))
            builder.and(order.member.name.contains(orderSearch.getMemberName()));
        if(StringUtils.hasText(orderSearch.getOrderStatus()))
            builder.and(order.status.eq(OrderStatus.valueOf(orderSearch.getOrderStatus())));


        List<Order> orders = queryFactory
                .selectFrom(order)
                .where(builder)
                .orderBy(order.id.asc())
                .fetch();


        return orders;
    }

    public Order findOne(Long orderId) {
        return em.find(Order.class, orderId);
    }
}
