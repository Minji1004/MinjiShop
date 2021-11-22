package minji.project.JpaPractice.domain.item;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import minji.project.JpaPractice.domain.BaseTimeEntity;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //상속 관계 매핑
@DiscriminatorColumn(name = "DTYPE")  //지정하지 않으면 기본값이 DTYPE
@Entity
public class Item extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    public Item(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

}
