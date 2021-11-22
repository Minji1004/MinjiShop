package minji.project.JpaPractice.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import minji.project.JpaPractice.domain.Address;
import minji.project.JpaPractice.domain.Member;

@Getter
@Setter
@NoArgsConstructor
//Entity는 DB용, DTO는 View 용. 절대 Entity를 DTO로 사용하면 안됨.
public class MemberDTO {

    private Long id;

    private String name;

    private String city;
    private String street;
    private String zipcode;

    @Builder
    public MemberDTO(String name, String city, String street, String zipcode) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public MemberDTO(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.city = member.getAddress().getCity();
        this.street = member.getAddress().getStreet();
        this.zipcode = member.getAddress().getZipcode();
    }

    public Member toEntity() {

        Address address = Address.builder()
                .city(city)
                .street(street)
                .zipcode(zipcode)
                .build();

        return Member.builder()
                .name(name)
                .address(address)
                .build();
    }

}
