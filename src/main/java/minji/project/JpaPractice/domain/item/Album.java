package minji.project.JpaPractice.domain.item;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@NoArgsConstructor
@Getter
@DiscriminatorValue("A")
@Entity
public class Album extends Item{

    private String artist;
    private String etc;

    @Builder
    private Album(String name, int price, int stockQuantity, String artist, String etc){
        super(name, price, stockQuantity); //부모 클래스인 item 생성자 호출해서 초기화.
        this.artist = artist;
        this.etc = etc;
    }

}
