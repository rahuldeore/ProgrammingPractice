package book.masteringlambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Rahul on 9/20/20
 */
public class Chapter3 {

    // page 48
    Optional<Integer> max = Arrays.asList(1,2,3,4,5)
            .stream()
            .map(integer -> integer*10)
            .max(Integer::compareTo);

    // page 49
    int nums[] = new int[]{1,2,3,4,5};
    OptionalInt num = IntStream.of(nums)
            .map(operand -> operand + 1)
            .max();

    // unnecessary but demonstrating possible inter conversions. pg 49
    DoubleStream ds = IntStream.rangeClosed(1, 10).asLongStream().asDoubleStream();
    DoubleStream doubleStream = IntStream.rangeClosed(1,10).asDoubleStream();

    // Converting into boxed type. pg 49
    Stream<Integer> is = IntStream.rangeClosed(1, 1000).boxed();
    ArrayList list = is.collect(Collectors.toCollection(ArrayList::new));

    // unwrapping a boxed type. pg 49
    Stream<Integer> integerStream = Stream.of(1, 2);
    IntStream intStream = integerStream.mapToInt(Integer::intValue);

    static int n=1000;
    static List<Integer> nums2 = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());




    public static void main(String... args) {
        Chapter3 chapter3 = new Chapter3();

        System.out.println(chapter3.num.getAsInt());


        nums2.forEach( i -> {
            if (i % 3 == 0) {
                if (i % 5 == 0) {
                    System.out.println("fizzbuzz");
                } else {
                    System.out.println("fizz");
                }
            } else if (i % 5 == 0) {
                System.out.println("buzz");
            } else {
                System.out.println(i);
            }
        });
    }

}
