package ly.generalassemb.drewmahrt.bookshelf;

import java.util.Comparator;

/**
 * Created by drewmahrt on 12/16/15.
 */
public class ComparatorAuthor implements Comparator<Book> {

    @Override
    public int compare(Book lhs, Book rhs) {
        //TODO: Write the comparison for the authors

        return lhs.getAuthor().compareTo(rhs.getAuthor());

    }
}

//
//class ComparatorA implements Comparator<ExampleClass>{
//    public int compare(ExampleClass ex1, ExampleClass ex2){
//        return ex1.getStrA().compareTo(ex2.getStrA());
//    }
//}