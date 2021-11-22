package minji.project.JpaPractice.web;

import minji.project.JpaPractice.web.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ItemController {

    @GetMapping("/items/new")
    public String createItemForm(Model model) {
        return "/items/createItemForm";
    }

    @GetMapping("/items")
    public String itemList(Model model) {
        return "/items/itemList";
    }

}
