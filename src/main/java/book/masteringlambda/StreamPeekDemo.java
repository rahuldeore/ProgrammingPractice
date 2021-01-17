package book.masteringlambda;

import book.masteringlambda.libs.Book;

import java.time.Year;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Rahul on 10/17/20
 *
 * Pg 61-62
 *
 * If I run this sequentially on a list of 1000 elements, I get either 1 or 999 as a result, depending on whether each
 * element refers to its predecessor or successor. (This difference, which is entirely dependent on the implementation’s
 * choice of evaluation order, is suf􏰀cient reason in itself to avoid code like this.) But running it in parallel gives
 * inconsistent results varying unpredictably between 1 and 4 or else 995 and 999.
 *
 */
public class StreamPeekDemo {

    public static void main(String... args) {
        List<Book> books = new LinkedList<>();

        // initialize the books list
        for (int i=0; i<1000; i++) {
            books.add(new Book("Title", List.of("abc"), new int[]{i}, Year.of(2020), Double.valueOf(10),
                    Book.TOPIC.COMPUTING));
        }

        // forward linking
        /*for (int i=0; i<1000; i++) {
            if (i != 999){
                books.get(i).setReferredTo(books.get(i+1));
            } else {
                books.get(i).setReferredTo(books.get(0));
            }
        }*/

        // reverse linking
        for (int i=0; i<1000; i++) {
            if (i != 0){
                books.get(i).setReferredTo(books.get(i-1));
            } else {
                books.get(i).setReferredTo(books.get(999));
            }
        }

        Long count = books.parallelStream()
                .peek(book -> book.getReferredTo().setReferred(true))
                //.peek(book -> System.out.println(book.getPageCounts()[0] + " " + book.isReferred() + "..." + book.getRefererTo().isReferred()))
                .filter(book -> {
                    //System.out.println(book.getPageCounts()[0] + "..." + book.isReferred());
                    return book.isReferred();
                })
                .count();
        System.out.println(count);


        count = books.parallelStream()
                .filter(book -> book.isReferred())
                .count();
        System.out.println(count);

    }

}
