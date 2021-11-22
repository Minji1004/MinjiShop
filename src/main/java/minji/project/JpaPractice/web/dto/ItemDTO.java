package minji.project.JpaPractice.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import minji.project.JpaPractice.domain.item.Album;
import minji.project.JpaPractice.domain.item.Book;
import minji.project.JpaPractice.domain.item.Item;
import minji.project.JpaPractice.domain.item.Movie;

@Getter
@Setter
@NoArgsConstructor
public class ItemDTO {
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    private String itemType;

    //Album
    private String artist;
    private String etc;

    //Book
    private String author;
    private String isbn;

    //Movie
    private String director;
    private String actor;

    public Item toItemEntity() {

        ItemType itemType = ItemType.fromString(this.itemType);

        switch(itemType){
            case ALBUM:
                return Album.builder()
                        .name(name)
                        .price(price)
                        .stockQuantity(stockQuantity)
                        .artist(artist)
                        .etc(etc)
                        .build();
            case BOOK:
                return Book.builder()
                    .name(name)
                    .price(price)
                    .stockQuantity(stockQuantity)
                    .author(author)
                    .isbn(isbn)
                    .build();
            case MOVIE:
                return Movie.builder()
                        .name(name)
                        .price(price)
                        .stockQuantity(stockQuantity)
                        .director(director)
                        .actor(actor)
                        .build();
        }

        return null;
    }

}
