package methodreferenceoperator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rahul on 2019-09-02
 */
public class MethodReferenceOperatorStaticMethodInvocation {

    // static function to be called
    static void someFunction(String s)
    {
        System.out.println(s);
    }

    public static void main(String[] args)
    {

        List<String> list = new ArrayList<String>();
        list.add("Geeks");
        list.add("For");
        list.add("GEEKS");

        // call the static method
        // using double colon operator
        list.forEach(MethodReferenceOperatorStaticMethodInvocation::someFunction);

        list.forEach(s -> someFunction(s));


    }
}
