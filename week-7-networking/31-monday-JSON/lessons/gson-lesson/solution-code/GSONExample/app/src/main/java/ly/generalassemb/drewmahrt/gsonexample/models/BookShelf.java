package ly.generalassemb.drewmahrt.gsonexample.models;

/**
 * Models a book shelf that has an array of books
 */
public class BookShelf {
    Book[] books;

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }
}
