package minji.project.JpaPractice.web;

import lombok.RequiredArgsConstructor;
import minji.project.JpaPractice.domain.order.OrderStatus;
import minji.project.JpaPractice.service.ItemService;
import minji.project.JpaPractice.service.MemberService;
import minji.project.JpaPractice.service.OrderService;
import minji.project.JpaPractice.util.OptionElement;
import minji.project.JpaPractice.web.dto.ItemDTO;
import minji.project.JpaPractice.web.dto.MemberDTO;
import minji.project.JpaPractice.web.dto.OrderDTO;
import minji.project.JpaPractice.web.dto.OrderSearchDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class OrderController {

    private final MemberService memberService;
    private final ItemService itemService;
    private final OrderService orderService;

    @GetMapping("/order")
    public String createOrderForm(Model model) {

        List<MemberDTO> members = memberService.findMembers();
        List<ItemDTO> items = itemService.findItems();

        model.addAttribute("members", members);
        model.addAttribute("items", items);

        return "/order/orderForm";
    }

    @PostMapping("/order")
    public String createOrder(OrderDTO orderDto) {

        orderService.createOrder(orderDto);

        return "redirect:/";
    }


    @GetMapping("/orders")
    public String orderList(Model model, OrderSearchDTO orderSearchDTO) {




        model.addAttribute("orderSearch", orderSearchDTO);
        List<OptionElement> orderStatusList = OrderStatus.createOptionLists(orderSearchDTO.getOrderStatus());
        model.addAttribute("orderStatusList", orderStatusList);


        return "/order/orderList";
    }


}
