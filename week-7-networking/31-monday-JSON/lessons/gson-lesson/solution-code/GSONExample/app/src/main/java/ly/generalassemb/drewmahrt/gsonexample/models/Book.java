package ly.generalassemb.drewmahrt.gsonexample.models;

/**
 * Models a book that has title, author and book cover object called cover
 */
public class Book {
    private String title;
    private String author;
    private BookCover cover;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookCover getCover() {
        return cover;
    }

    public void setCover(BookCover cover) {
        this.cover = cover;
    }
}
