package methodreferenceoperator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rahul on 2019-09-02
 */

// Java code to show use of double colon operator
// for instance methods

public class MethodReferenceOperatorInstanceMethodInvocation {
    // instance function to be called
    void someFunction(String s)
    {
        System.out.println(s + ": Appender");
    }

    public static void main(String[] args)
    {
        MethodReferenceOperatorInstanceMethodInvocation obj = new MethodReferenceOperatorInstanceMethodInvocation();
        List<String> list = new ArrayList<>();
        list.add("Geeks");
        list.add("For");
        list.add("GEEKS");

        // call the instance method
        // using double colon operator
        list.forEach(String::length);
        list.forEach(System.out::println);
        list.forEach(name -> System.out.println(name));
    }
}