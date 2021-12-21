package minji.project.JpaPractice.domain.order;

import minji.project.JpaPractice.util.OptionElement;

import java.util.ArrayList;
import java.util.List;

public enum OrderStatus {
    ORDER("ORDER","주문"), CANCEL("CANCEL", "취소");

    private final String orderStatusCode;
    private final String orderStatusName;

    OrderStatus(String orderStatusCode, String orderStatusName) {
        this.orderStatusCode = orderStatusCode;
        this.orderStatusName = orderStatusName;
    }

    public static List<OptionElement> createOptionLists(String selectedOrderCode){
        List<OptionElement> elements = new ArrayList<OptionElement>();

        for (OrderStatus i : OrderStatus.values()) {
            OptionElement element = new OptionElement();
            element.setCode(i.orderStatusCode);
            element.setName(i.orderStatusName);

            if(selectedOrderCode != null && selectedOrderCode.equals(i.orderStatusCode))
                element.setSelected("Y");

            elements.add(element);
        }
        return  elements;
    }

}
