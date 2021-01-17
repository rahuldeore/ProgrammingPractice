package lambdas;

import java.util.Calendar;

/**
 * Created by Rahul on 2019-09-02
 */

abstract class MyAbstractClass{

    public abstract void sayGreeting();

    public static int multiplyOperation(int a, int b){
        return a*b;
    }
}

public class LambdaInAbstractClass {

    public static void main(String args[]){
        MyAbstractClass myAbstractClass= new MyAbstractClass() {
            @Override
            public void sayGreeting() {
                String greeting = null;
                Calendar cal = Calendar.getInstance();
                if (cal.get(Calendar.AM_PM) == Calendar.AM){
                    greeting = "Good Morning !";
                }else {
                    greeting = "Good Afternoon !";
                }
                System.out.println(greeting);
            }
        };
        myAbstractClass.sayGreeting();
    }

}
