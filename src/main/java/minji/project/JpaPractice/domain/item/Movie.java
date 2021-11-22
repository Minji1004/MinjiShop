package minji.project.JpaPractice.domain.item;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@NoArgsConstructor
@Getter
@DiscriminatorValue("M")
@Entity
public class Movie extends Item{

    private String director;
    private String actor;

    @Builder
    private Movie(String name, int price, int stockQuantity, String director, String actor){
        super(name, price, stockQuantity); //부모 클래스인 item 생성자 호출해서 초기화.
        this.director = director;
        this.actor = actor;
    }
}
