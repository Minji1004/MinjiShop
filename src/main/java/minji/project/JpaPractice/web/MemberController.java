package minji.project.JpaPractice.web;

import lombok.RequiredArgsConstructor;
import minji.project.JpaPractice.service.MemberService;
import minji.project.JpaPractice.web.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/api/member/{id}")
    @ResponseBody
    public Long update(@PathVariable Long id, @RequestBody MemberDTO requestDto){
        Long response = null;
        try {
            response = memberService.update(id, requestDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @DeleteMapping("/api/member/{id}")
    @ResponseBody
    public Long delete(@PathVariable Long id){

        try {
            memberService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }


    @GetMapping("/members")
    public String memberList(Model model) {

        List<MemberDTO> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";
    }

    @GetMapping("/members/searchMember/{memberId}")
    public String searchMember(@PathVariable("memberId") Long id, Model model) {

        try {
            MemberDTO memberDTO = memberService.findMemberById(id);
            model.addAttribute("member", memberDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "members/memberForm";
    }
}
