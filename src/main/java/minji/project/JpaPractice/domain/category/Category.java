package minji.project.JpaPractice.domain.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import minji.project.JpaPractice.domain.item.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            //다대다 관계를 일대다, 다대일로 풀어주는 연결 테이블 이름
            name = "CATEGORY_ITEM",
            //현재 방향인 Category와 조인하는 CATEGORY_ITEM 테이블의 COLUMN이름.
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            //Category의 반대방향인 ITEM과 조인하는 CATEGORY_ITEM 테이블의 COLUMN이름.
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
    )
    private List<Item> items = new ArrayList<Item>();

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<Category>();

    //연관관계 메서드//
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }

    public void addItem(Item item) {
        items.add(item);
    }


}
