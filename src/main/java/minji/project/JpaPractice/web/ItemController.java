package minji.project.JpaPractice.web;

import lombok.RequiredArgsConstructor;
import minji.project.JpaPractice.service.ItemService;
import minji.project.JpaPractice.web.dto.ItemDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items/new")
    public String createItemForm(Model model) {
        return "/items/createItemForm";
    }

    @PostMapping("/items/new")
    public String registerItem(ItemDTO itemDTO) {
        itemService.registerItem(itemDTO);
        return "/items/createItemForm";
    }

    @GetMapping("/items")
    public String itemList(Model model) {
        List<ItemDTO> items = itemService.findItems();
        model.addAttribute("items", items);
        return "/items/itemList";
    }

}
