/**
 * Created by Rahul on 2019-07-21
 */
@FunctionalInterface
interface FuncInter2
{
    void sayMessage(String message);
    default void someMethod(){
        System.out.println("This is default method in the Functional Interface 2");
    }
}

abstract class testAbstractClass
{
    abstract void someMethod();
    void sayHello(){
        System.out.println("Hello from abstract class");
    }
    public static void main(String args[]){
        System.out.println("Hello !");
    }
}

// Java program to demonstrate working of lambda expressions
public class LambdaTest {

        // operation is implemented using lambda expressionsi
        @FunctionalInterface
        interface FuncInter1
        {
            int operation(int a, int b);
            default int operation2 (int x, int y, int z){
                System.out.println("This is first default method of functional interface 1. Operation is set to x * y / z");
                return (x*y)/z;
            }
            default void hello (){
                System.out.println("Hello from second default method of functional interface 1");
            }
        }

        // sayMessage() is implemented using lambda expressions
        // above


        // Performs FuncInter1's operation on 'a' and 'b'
        private int operate(int a, int b, FuncInter1 fobj)
        {
            return fobj.operation(a, b);
        }

        public static void main(String args[])
        {
            // lambda expression for addition of two parameters
            // data type for x and y is optional.
            // This expression implements 'FuncInter1' interface
            FuncInter1 add = (int x, int y) -> (x + y);

            // lambda expression multiplication for two parameters
            // This expression also implements 'FuncInter1' interface
            FuncInter1 multiply = (x, y) -> x * y;

            // lambda expression for implementing functional interface 2 to say greeting
            FuncInter2 greeting = m -> {
                String s = new String("From Rahul " + m);
                System.out.println(s);
            };

            greeting.sayMessage("Hello from Rahul!");

            // Creating an object of methodreferenceoperator.Test to call operate using
            // different implementations using lambda Expressions
            LambdaTest tobj = new LambdaTest();

            // Add two numbers using lambda expression
            System.out.println("Addition is " +
                    tobj.operate(6, 3, add));

            // Multiply two numbers using lambda expression
            System.out.println("Multiplication is " +
                    tobj.operate(6, 3, multiply));

            // lambda expression for single parameter
            // This expression implements 'FuncInter2' interface
            FuncInter2 fobj = message ->System.out.println("Hello "
                    + message);
            fobj.sayMessage("Geek");
            fobj.someMethod();

            // invoking the lambda implementation of a functional interface
            System.out.println("The Addition operation results in: "+ add.operation(5,7));
        }

}
