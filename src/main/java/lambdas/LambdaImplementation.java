package lambdas;

import java.util.Calendar;

/**
 * Created by Rahul on 2019-09-02
 */
interface MyLocalTime {
    void printLocalTime();
}

@FunctionalInterface
interface MyFunctionalInterface{

    // abstract is redundant here
    abstract void sayMessage(String message);

    //cannot have this because functional interface can only have one abstract unimplemented method
    //void oneMessage();

    //other methods can be default and implemented
    default void helloMessage() {
        System.out.println("Hello from Functional Interface Default Method");
    }
}

public class LambdaImplementation {
    public static void main(String args[]){
        MyFunctionalInterface myFuncInter = message ->  {
            Calendar cal = Calendar.getInstance();
            if (cal.get(Calendar.AM_PM)==Calendar.AM){
                message = "Good Morning " + message;
            }
            else{
                message = "Good Afternoon " + message;
            }
            System.out.println(message);
        };
        myFuncInter.sayMessage("from Rahul !");

        MyFunctionalInterface myFunctionalInterface = message -> {
            System.out.println(message);
        };

        MyLocalTime myLocalTime = () -> {
            Calendar calendar = Calendar.getInstance();
            System.out.println(calendar.getTime());
        };
        myLocalTime.printLocalTime();
    }
}
