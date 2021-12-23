package minji.project.JpaPractice.domain.order;

import lombok.Getter;
import lombok.Setter;
import minji.project.JpaPractice.domain.item.Item;

import javax.persistence.*;


@Getter
@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @Setter
    private int orderPrice;

    @Setter
    private int count;

    public static OrderItem createOrderItem(Item item, int count) {

        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(item.getPrice());
        orderItem.setCount(count);

        item.removeStock(count);

        return orderItem;
    }

    public int getTotalPrice(){
        return orderPrice * count;
    }

    public void cancel() {
        item.addStock(count);
    }
}
