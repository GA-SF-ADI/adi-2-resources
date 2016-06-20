package ly.generalassemb.drewmahrt.bookshelf;

import java.util.Comparator;

import static android.R.attr.id;

/**
 * Created by drewmahrt on 12/16/15.
 */
public class ComparatorYear implements Comparator<Book> {
    @Override
    public int compare(Book lhs, Book rhs) {
        //TODO: Write the comparison for the years
        int lhsInt = Integer.parseInt(lhs.getYear());
        int rhsInt = Integer.parseInt(rhs.getYear());
        if(rhsInt<lhsInt){
            return 1;
        }else if(lhsInt<rhsInt){
            return -1;
        }else{
            return 0;
        }

    }
}
