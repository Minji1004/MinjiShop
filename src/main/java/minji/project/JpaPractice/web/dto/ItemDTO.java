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

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.price = item.getPrice();
        this.stockQuantity = item.getStockQuantity();

        if(item instanceof Album) {
            this.itemType = "A";
            this.artist = ((Album) item).getArtist();
            this.etc = ((Album) item).getEtc();
        }else if(item instanceof Book) {
            this.itemType = "B";
            this.itemType = "B";
            this.author = ((Book) item).getAuthor();
            this.isbn = ((Book) item).getIsbn();
        }else if(item instanceof Movie) {
            this.itemType = "M";
            this.director = ((Movie) item).getDirector();
            this.actor = ((Movie) item).getActor();
        }
    }


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
