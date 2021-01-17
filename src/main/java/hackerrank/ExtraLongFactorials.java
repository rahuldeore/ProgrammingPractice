package hackerrank;

import java.math.BigInteger;

/**
 * Created by Rahul on 1/15/21
 */
public class ExtraLongFactorials {
    static void extraLongFactorials(int n) {

        BigInteger factorial = BigInteger.valueOf(n);

        int num = n - 1;

        while (num != 0) {
            factorial = factorial.multiply(BigInteger.valueOf(num));
            num--;
        }
        System.out.println(factorial);
    }

    public static void main (String... args) {
        extraLongFactorials(30);
    }
}
