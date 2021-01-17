package book.masteringlambda;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
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
    Stream<Integer> is = IntStream.rangeClosed(1, 10).boxed();

    // unwrapping a boxed type. pg 49
    Stream<Integer> integerStream = Stream.of(1, 2);
    IntStream intStream = integerStream.mapToInt(Integer::intValue);




    public static void main(String... args) {
        Chapter3 chapter3 = new Chapter3();

        System.out.println(chapter3.num.getAsInt());
    }

}
