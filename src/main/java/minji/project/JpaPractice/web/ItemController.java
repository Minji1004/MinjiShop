package minji.project.JpaPractice.web;

import lombok.RequiredArgsConstructor;
import minji.project.JpaPractice.service.ItemService;
import minji.project.JpaPractice.web.dto.ItemDTO;
import minji.project.JpaPractice.web.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/items/{id}/edit")
    public String updateItemForm(@PathVariable Long id, Model model) {

        ItemDTO itemDTO = itemService.findItemById(id);
        model.addAttribute("item", itemDTO);

        return "/items/updateItemForm";
    }

    @PutMapping("/api/item/{id}")
    @ResponseBody
    public Long update(@PathVariable Long id, @RequestBody ItemDTO requestDto){
        return itemService.update(id, requestDto);
    }

    @DeleteMapping("/api/item/{id}")
    @ResponseBody
    public Long delete(@PathVariable Long id){
        itemService.delete(id);
        return id;
    }


}
