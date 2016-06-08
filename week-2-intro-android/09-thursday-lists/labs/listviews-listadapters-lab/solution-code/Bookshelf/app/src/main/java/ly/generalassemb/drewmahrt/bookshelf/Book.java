package ly.generalassemb.drewmahrt.bookshelf;

/**
 * Created by drewmahrt on 12/16/15.
 */
public class Book {
    private String mTitle;
    private String mAuthor;
    private String mYear;

    public Book(String title,String author, String year){
        mTitle = title;
        mAuthor = author;
        mYear = year;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getYear() {
        return mYear;
    }
}
