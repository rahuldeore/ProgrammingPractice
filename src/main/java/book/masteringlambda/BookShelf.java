package book.masteringlambda;

import book.masteringlambda.libs.Book;

import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Rahul on 10/4/20
 * Page 52 onwards, mastering lambdas
 *
 * Questions:
 *  - How to copy a stream ?        multiple copies or references on stream...cloning ?
 *  - How to repeat on a stream ?   Repeatable streams...
 */
public class BookShelf {

    static Book nails = new Book("Fundamentals of Chinese Fingernail Image",
            Arrays.asList("Li", "Fu", "Li"),
            new int[]{256},
            Year.of(2014),
            25.2,
            Book.TOPIC.MEDICINE);

    static Book dragon = new Book("Compilers: Principles, Techniques and Tools", Arrays.asList("Aho", "Lam", "Sethi", "Ullman"),
            new int[]{1009},
            Year.of(2006), // publication date (2nd edition)
            23.6, Book.TOPIC.COMPUTING);

    static Book voss = new Book("Voss", Arrays.asList("Patrick White"), new int[]{478},
            Year.of(1957),
            19.8,
            Book.TOPIC.FICTION);

    static Book lotr = new Book("Lord of the Rings", Arrays.asList("Tolkien"),
            new int[]{531, 416, 624}, Year.of(1955),
            23.0, Book.TOPIC.FICTION);


    static List<Book> library = List.of(nails, dragon, voss, lotr);

    public static void main(String... args) {


        // A stream that contains only computing books:
        Stream<Book> computingBooks = library.stream().filter(book -> book.getTopic()== Book.TOPIC.COMPUTING);
        System.out.println("\nA stream that contains only computing books:");
        computingBooks.forEach(book -> {
            System.out.println(book.getTitle());
        });

        // A stream of book titles:
        Stream<String> bookTitles = library.stream().map(Book::getTitle);
        System.out.println("\nA stream of book titles:");
        bookTitles.forEach(System.out::println);

        // A stream of Book, sorted by title:
        // Stream<Book> booksSortedByTitles = library.stream().sorted((o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
        Stream<Book> booksSortedByTitles = library.stream().sorted(Comparator.comparing(Book::getTitle));
        System.out.println("\nA stream of Book, sorted by title:");
        booksSortedByTitles.forEach(book -> {
            System.out.println(book.getTitle());
        });

        // Use this sorted stream to create a stream of authors, in order of book title, with duplicates removed: pg 53
        Stream<String> uniqueAuthors = library.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .flatMap(book -> book.getAuthors().stream())
                .distinct();

        System.out.println("\nA stream of authors, in order of book title, with duplicates removed:");
        uniqueAuthors.forEach(System.out::println);

        // Use this sorted stream to create a stream of authors, in reverse order of book title, with duplicates removed
        // Experiment problem/code not in book
        Stream<List<String>> listOfAuthorsBySortedBookTitles = library.parallelStream()
                .sorted(Comparator.comparing(Book::getTitle).reversed())
                .map(book -> {
                    return book.getAuthors().stream()
                            .map(s -> book.getTitle() + " : " + s)
                            .distinct()
                            .collect(Collectors.toCollection(ArrayList::new));
                });

        Stream<List<String>> copy1 = listOfAuthorsBySortedBookTitles; // doesnt clones the stream

        System.out.println("\nA stream of authors, in order of book title, with duplicates removed:");
        listOfAuthorsBySortedBookTitles.forEach(strings -> {
            strings.forEach(System.out::println);
        });

        // A stream yielding the first 100 books in alphabetical order of title:
        Stream<Book> first100BooksSorted = library.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .limit(100);

        System.out.println("\nA stream yielding the first 100 books in alphabetical order of title:");
        first100BooksSorted.forEach(book -> System.out.println(book.getTitle()));

        // A stream with the rest:
        Stream<Book> restOfBooks = library.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .skip(100);
        System.out.println("\nA stream with the rest:");
        restOfBooks.forEach(book -> System.out.println(book.getTitle())); // this will be empty as we have only 4 in library

        // The earliest-published book in my library:
        Optional<Book> earliestPublishedBook = library.stream()
                .min(Comparator.comparing(Book::getPubDate));
        System.out.println("\nThe earliest-published book in my library:");
        earliestPublishedBook.ifPresent(book -> System.out.println(book.getTitle() + " : " + book.getPubDate()));

        // The set of titles of the books in my library
        Set<String> allTitles = library.stream()
                .map(Book::getTitle)
                .collect(Collectors.toSet());
        System.out.println("\nThe set of titles of the books in my library");
        allTitles.forEach(System.out::println);

        // Count the total number of authorship (defining an authorship as the contribution of an author to a book) of
        // all books in my library - pg 56
        int totalAuthorship = library.stream()
                .mapToInt(book -> book.getAuthors().size())
                .sum();
        System.out.println("\nCount the total number of authorship (defining an authorship as the contribution of " +
                "an author to a book) of all books in my library");
        System.out.println(totalAuthorship);

        // Total page count of all volumes of all books
        int totalPages = library.stream()
                .mapToInt(book ->  IntStream.of(book.getPageCounts()).sum())
                .peek(System.out::println)
                .sum();
        System.out.println("\nTotal page count of all volumes of all books:\n" + totalPages);

        totalPages = library.stream()
                .flatMapToInt(book -> IntStream.of(book.getPageCounts()))
                .peek(System.out::println)
                .sum();
        System.out.println("\nTotal page count of all volumes of all books:\n" + totalPages);
    }
}
