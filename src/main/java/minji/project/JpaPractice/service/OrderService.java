package minji.project.JpaPractice.service;

import lombok.RequiredArgsConstructor;
import minji.project.JpaPractice.domain.delivery.Delivery;
import minji.project.JpaPractice.domain.item.Item;
import minji.project.JpaPractice.domain.member.Member;
import minji.project.JpaPractice.domain.order.Order;
import minji.project.JpaPractice.domain.order.OrderItem;
import minji.project.JpaPractice.repository.ItemRepository;
import minji.project.JpaPractice.repository.MemberRepository;
import minji.project.JpaPractice.repository.OrderRepository;
import minji.project.JpaPractice.web.dto.OrderDTO;
import minji.project.JpaPractice.web.dto.OrderSearchDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class OrderService {

    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;

    public Long createOrder(Long memberId, Long itemId, int count) throws Exception {

        Member member = memberRepository.findById(memberId).orElseThrow(()-> new Exception("회원 정보가 없습니다."));
        Item item = itemRepository.findById(itemId).orElseThrow(()->new Exception("해당 아이템이 없습니다."));;

        //Delivery 생성
        Delivery delivery = new Delivery(member.getAddress());

        //Order Item 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, count);

        Order order = Order.createOrder(member, delivery, orderItem);

        orderRepository.saveOrder(order);

        return order.getId();
    }

    public List<OrderDTO> findOrders(OrderSearchDTO orderSearch) {

        List<Order> orders = orderRepository.findOrders(orderSearch);

        List<OrderDTO> orderDTOs = orders.stream().map(OrderDTO::new).collect(Collectors.toList());

        return orderDTOs;
    }

    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findOne(orderId);

        order.cancelOrder();
    }
}
