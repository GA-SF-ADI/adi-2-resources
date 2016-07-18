package ly.generalassemb.arraysandnestedjsontojava.models;

/**
 * Object to model a library from JSON results
 *
 * This object holds an array of bookshelves
 */
public class Library {
    Bookshelf[] bookshelves;

    public Bookshelf[] getBookshelves() {
        return bookshelves;
    }

    public void setBookshelves(Bookshelf[] bookshelves) {
        this.bookshelves = bookshelves;
    }
}
