package minji.project.JpaPractice.service;

import lombok.RequiredArgsConstructor;
import minji.project.JpaPractice.domain.Address;
import minji.project.JpaPractice.domain.member.Member;
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
        validateDuplicateMember(memberSaveRequestDTO);
        Member member = memberRepository.save(memberSaveRequestDTO.toEntity());
       return member.getId();
    }

    private void validateDuplicateMember(MemberDTO memberDTO) {
        List<Member> findMembers = memberRepository.findByName(memberDTO.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
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

    public MemberDTO findMemberById(Long id) throws Exception {
        Member member = memberRepository.findById(id).orElseThrow(()-> new Exception("회원 정보가 없습니다."));
        return new MemberDTO(member);
    }

    public Long update(Long id, MemberDTO requestDto) throws Exception {
        //JPA 컨텍스트에 있는 member를 조회해온다.
        Member member = memberRepository.findById(id).orElseThrow(()-> new Exception("회원 정보가 없습니다."));

        //수정된 내용을 세팅한다.
        //JPA 컨텍스트 내 Entity 내용을 수정하면, flush할 때 변경사항을 감지해서 Update SQL Query를 만들어서 DB에 보낸다.
        Address address = Address.builder()
                .city(requestDto.getCity())
                .street(requestDto.getStreet())
                .zipcode(requestDto.getZipcode())
                .build();

        member.updateAddress(address);

        return member.getId();
    }

    public void delete(Long id) throws Exception {
        //JPA 컨텍스트에 있는 member를 조회해온다.
        Member member = memberRepository.findById(id).orElseThrow(()-> new Exception("회원 정보가 없습니다."));
        //엔티티 삭제
        memberRepository.delete(member);
    }
}
