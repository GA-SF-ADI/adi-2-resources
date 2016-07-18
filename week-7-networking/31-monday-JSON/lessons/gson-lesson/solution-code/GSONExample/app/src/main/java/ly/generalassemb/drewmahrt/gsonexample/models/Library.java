package ly.generalassemb.drewmahrt.gsonexample.models;

/**
 * Models library that has an array of book shelves
 */
public class Library {
    BookShelf[] bookshelves;

    public BookShelf[] getBookshelves() {
        return bookshelves;
    }

    public void setBookshelves(BookShelf[] bookshelves) {
        this.bookshelves = bookshelves;
    }
}
