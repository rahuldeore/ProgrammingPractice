package book.masteringlambda;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Supplier;

/**
 * Created by Rahul on 9/5/20
 *
 * This file contains all the sample snippets that i evaluated while going through the book:
 * Mastering Lambdas - Java programming in multicore world by Oracle Inc ---- Chapter 2.
 */
public class Chapter2 {

    // page 24
    DoubleUnaryOperator sqrt = x -> { return Math.sqrt(x); };

    // page 30, lambda expression body
    Callable<Runnable> c = () -> () -> System.out.println("hi");
    // another example of above lambda
    Callable<Runnable> c1 = () ->{
        System.out.println("call method");
        return  () -> System.out.println("run method");
    };

    // page 30, ternary conditional lambda expression
    boolean flag = true;
    Callable<Integer> ternary = flag ? () -> 47: ()->38;

    // page 30, cast expressions
    //Object o = () -> "hi"; // illegal
    Object s = (Supplier) () -> "hi";
    Object c2 = (Callable) () -> "hi"; // textually identical to the above, but target type is different
    // Don't do this. Casting a lambda to another will compile but fail during runtime with ClassCastException
    //Callable c3 = (Callable) s;

    // page 32
    List<Point> pointList = Arrays.asList((new Point(1,2)),new Point(2,3));
    List<String> strings = Arrays.asList("qwe","asd","zxc");

    // Page 33 bound method reference
    void printPointList(List<Point> pointList){
        pointList.forEach(System.out::print);
        String str = "alpha-bravo-charlie";
        Map<String, String> map = new TreeMap();
        map.put("alpha", "x");
        map.put("bravo", "y");
        map.put("charlie", "z");

        System.out.println();
        map.entrySet().stream().forEach(System.out::println);

        map.replaceAll((k,v) -> {return str.replace(k,v);});
        /* Result will be
        * alpha=alpha-bravo-charlie
        * bravo=alpha-bravo-charlie
        * charlie=alpha-bravo-charlie
        * */

        //Another way of achieving above result using method reference operator
        map.replaceAll(str::replace);

        System.out.println();
        map.entrySet().stream().forEach(System.out::println);

        // unbound method reference. Receiver is the first argument to the lambda
        map.replaceAll(String::concat);

        System.out.println();
        map.entrySet().stream().forEach(System.out::println);

    }


    // Page 34 Unbound method reference
    //Comparator personComp = Comparator.comparing(Person::getLastName);

    public static void main(String... args) {
        Chapter2 snippet = new Chapter2();
        //System.out.println(snippet.sqrt.applyAsDouble(16));

        //snippet.pointList.forEach(point -> System.out.println(point));
        //snippet.pointList.forEach(System.out::println);

        snippet.printPointList(Arrays.asList(new Point(1,2),new Point(2,3)));

    }
}
