package minji.project.JpaPractice.web;

import lombok.RequiredArgsConstructor;
import minji.project.JpaPractice.service.MemberService;
import minji.project.JpaPractice.web.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController //@RestController: JSON을 반환하는 컨트롤러로 만들어준다.
public class MemberAPIController {

    private final MemberService memberService;

    @PutMapping("/api/member/{id}")
    public Long update(@PathVariable Long id, @RequestBody MemberDTO requestDto){
        return memberService.update(id, requestDto);
    }

    @DeleteMapping("/api/member/{id}")
    public Long delete(@PathVariable Long id){
        memberService.delete(id);
        return id;
    }

}
