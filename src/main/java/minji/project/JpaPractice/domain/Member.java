package minji.project.JpaPractice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//엔터티 클래스에는 Setter 메서드를 만들지 않고, 만들더라도 명확한 목적을 나타내야함.
@Getter  //롬복 기능. 필드의 Getter 메소드 생성
@NoArgsConstructor  //롬복 기능. 기본 생성자 생성
@Entity  //JPA. 엔티티 선언
public class Member extends BaseTimeEntity {

    @Id   //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //키 생성전략
    @Column(name = "MEMBER_ID") //Member 테이블과 매핑되는 컬럼명
    private Long id;

    private String name;

    //임베디드 타입. 엔터티가 아닌 값타입이다.
    @Embedded
    private Address address;

    //Builder 메서드를 만들어준다.
    @Builder
    public Member(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public void updateAddress(Address address) {
        this.address = address;
    }
}
