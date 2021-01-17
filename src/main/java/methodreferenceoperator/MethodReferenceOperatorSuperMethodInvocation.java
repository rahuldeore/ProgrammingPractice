package methodreferenceoperator; /**
 * Created by Rahul on 2019-09-02
 */

// Java code to show use of double colon operator
// for super methods

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class Test {

    // super function to be called
    String print(String str)
    {
        return ("Hello " + str + "\n");
    }
}

class MethodReferenceOperatorSuperMethodInvocation extends Test {

    // instance method to override super method
    @Override
    String print(String s)
    {

        // call the super method
        // using double colon operator
        Function<String, String>
                func = super::print;

        String newValue = func.apply(s);
        newValue += "Bye " + s + "\n";
        System.out.println(newValue);

        return newValue;
    }

    // Driver code
    public static void main(String[] args)
    {

        List<String> list = new ArrayList<String>();
        list.add("Geeks");
        list.add("For");
        list.add("GEEKS");

        // call the instance method
        // using double colon operator
        list.forEach(new MethodReferenceOperatorSuperMethodInvocation()::print);
    }
}


