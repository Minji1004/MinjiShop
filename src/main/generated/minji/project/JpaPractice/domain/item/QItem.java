package minji.project.JpaPractice.domain.item;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QItem is a Querydsl query type for Item
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QItem extends EntityPathBase<Item> {

    private static final long serialVersionUID = 1012359374L;

    public static final QItem item = new QItem("item");

    public final minji.project.JpaPractice.domain.QBaseTimeEntity _super = new minji.project.JpaPractice.domain.QBaseTimeEntity(this);

    public final ListPath<minji.project.JpaPractice.domain.category.Category, minji.project.JpaPractice.domain.category.QCategory> categories = this.<minji.project.JpaPractice.domain.category.Category, minji.project.JpaPractice.domain.category.QCategory>createList("categories", minji.project.JpaPractice.domain.category.Category.class, minji.project.JpaPractice.domain.category.QCategory.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath name = createString("name");

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final NumberPath<Integer> stockQuantity = createNumber("stockQuantity", Integer.class);

    public QItem(String variable) {
        super(Item.class, forVariable(variable));
    }

    public QItem(Path<? extends Item> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItem(PathMetadata metadata) {
        super(Item.class, metadata);
    }

}

