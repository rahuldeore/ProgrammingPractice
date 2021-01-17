/**
 * Created by Rahul on 2019-07-21
 */
public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("A thread created and running ...");
            }
        }).start();
    }
}
