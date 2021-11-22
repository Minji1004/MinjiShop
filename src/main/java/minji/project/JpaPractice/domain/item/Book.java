package minji.project.JpaPractice.domain.item;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@NoArgsConstructor
@Getter
@DiscriminatorValue("B")
@Entity
public class Book extends Item{

    private String author;
    private String isbn;

    @Builder
    private Book(String name, int price, int stockQuantity, String author, String isbn){
        super(name, price, stockQuantity); //부모 클래스인 item 생성자 호출해서 초기화.
        this.author = author;
        this.isbn = isbn;
    }

}
