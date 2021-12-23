package minji.project.JpaPractice.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import minji.project.JpaPractice.domain.order.Order;
import minji.project.JpaPractice.domain.order.OrderItem;
import minji.project.JpaPractice.domain.order.OrderStatus;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {

    private Long orderId;

    private String memberName;

    private String itemName;
    private int orderPrice;
    private int count;
    private int totalPrice;
    private String orderStatus;
    private String orderDate;
    private String isOrder;

    public OrderDTO(Order order) {
        this.orderId = order.getId();
        this.memberName = order.getMember().getName();

        OrderItem orderItem = order.getOrderItems().get(0);
        this.itemName = orderItem.getItem().getName();
        this.orderPrice = orderItem.getOrderPrice();
        this.count = orderItem.getCount();
        this.totalPrice = orderItem.getTotalPrice();

        this.orderStatus = order.getStatus().name();
        orderDate = order.getOrderDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        if(order.getStatus() == OrderStatus.ORDER)
            this.isOrder = "Y";

    }

}
