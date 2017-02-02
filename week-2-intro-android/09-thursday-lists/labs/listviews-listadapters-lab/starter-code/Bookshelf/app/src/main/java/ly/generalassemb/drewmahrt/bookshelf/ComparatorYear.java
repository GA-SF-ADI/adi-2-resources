package ly.generalassemb.drewmahrt.bookshelf;

import java.util.Comparator;

/**
 * Created by drewmahrt on 12/16/15.
 */
public class ComparatorYear implements Comparator<Book> {
    @Override
    public int compare(Book lhs, Book rhs) {
        return lhs.getYear().compareTo(rhs.getYear());
    }
}
