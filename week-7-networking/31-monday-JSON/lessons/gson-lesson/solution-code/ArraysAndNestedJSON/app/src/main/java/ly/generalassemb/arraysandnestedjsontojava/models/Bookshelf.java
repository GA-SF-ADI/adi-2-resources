package ly.generalassemb.arraysandnestedjsontojava.models;

/**
 * Object to model a bookshelf from JSON results
 *
 * It has an array of books.
 *
 * It could also have other properties, like name, etc.
 */
public class Bookshelf {
    Book[] books;

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }
}
