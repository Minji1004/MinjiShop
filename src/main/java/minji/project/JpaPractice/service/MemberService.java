package minji.project.JpaPractice.service;

import lombok.RequiredArgsConstructor;
import minji.project.JpaPractice.domain.Member;
import minji.project.JpaPractice.repository.MemberRepository;
import minji.project.JpaPractice.web.dto.MemberDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public Long join(MemberDTO memberSaveRequestDTO) {
       return memberRepository.save(memberSaveRequestDTO.toEntity());
    }

    public List<MemberDTO> findMembers() {
        List<Member> memberList = memberRepository.findAll();
        
        //DTO로 변환
        List<MemberDTO> members = new ArrayList<>();
        for (Member member : memberList) {
            members.add(new MemberDTO(member));
        }

        return members;
    }

    public MemberDTO findMemberById(Long id) {
        Member member = memberRepository.findOneById(id);

        return new MemberDTO(member);
    }
}
