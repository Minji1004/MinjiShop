package minji.project.JpaPractice.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/members/new")
    public String createMemberForm(Model model) {
        return "members/createMemberForm";
    }
}
