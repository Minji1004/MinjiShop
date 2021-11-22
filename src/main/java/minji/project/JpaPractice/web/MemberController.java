package minji.project.JpaPractice.web;

import lombok.RequiredArgsConstructor;
import minji.project.JpaPractice.service.MemberService;
import minji.project.JpaPractice.web.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createMemberForm(Model model) {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    //dto에 setter가 없으면 form의 파라미터를 세팅할 수 없다.
    public String registerMember(MemberDTO memberSaveRequestDTO) {
        memberService.join(memberSaveRequestDTO);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String memberList(Model model) {

        List<MemberDTO> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";
    }

    @GetMapping("/members/searchMember/{memberId}")
    public String memberList(@PathVariable("memberId") Long id, Model model) {

        MemberDTO memberDTO = memberService.findMemberById(id);
        model.addAttribute("member", memberDTO);

        return "members/updateMemberForm";
    }
}
