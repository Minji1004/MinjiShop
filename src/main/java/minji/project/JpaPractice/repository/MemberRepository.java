package minji.project.JpaPractice.repository;

import minji.project.JpaPractice.domain.Member;
import minji.project.JpaPractice.web.dto.MemberDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext //스프링컨테이너에 등록된 EntityManger 스프링빈을 주입받음
    EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public Member findOneById(Long id) {
        return em.find(Member.class, id);
    }

    public void deleteMember(Member member) {
        em.remove(member);
    }
}
