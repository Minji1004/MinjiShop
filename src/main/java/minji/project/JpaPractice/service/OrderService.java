package minji.project.JpaPractice.service;

import lombok.RequiredArgsConstructor;
import minji.project.JpaPractice.domain.delivery.Delivery;
import minji.project.JpaPractice.domain.delivery.DeliveryStatus;
import minji.project.JpaPractice.domain.item.Item;
import minji.project.JpaPractice.domain.member.Member;
import minji.project.JpaPractice.domain.order.Order;
import minji.project.JpaPractice.domain.order.OrderItem;
import minji.project.JpaPractice.repository.ItemRepository;
import minji.project.JpaPractice.repository.MemberRepository;
import minji.project.JpaPractice.repository.OrderRepository;
import minji.project.JpaPractice.web.dto.OrderDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class OrderService {

    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;

    public Long createOrder(OrderDTO orderDTO) {

        Member member = memberRepository.findOneById(orderDTO.getMemberId());
        Item item = itemRepository.findItemById(orderDTO.getItemId());

        //Delivery 생성
        Delivery delivery = new Delivery(member.getAddress());

        //Order Item 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, orderDTO.getCount());

        Order order = Order.createOrder(member, delivery, orderItem);

        orderRepository.saveOrder(order);

        return order.getId();
    }
}
