package book.masteringlambda;

/**
 * Created by Rahul on 9/5/20
 */
public class Chapter1 {

    Runnable r1 = () -> { System.out.println(this); };
    Runnable r2 = () -> { System.out.println(toString()); };

    public static void main(String... args) {
        new Chapter1().r1.run();
        new Chapter1().r2.run();
    }

    public String toString() { return "Hello, world!"; }

}