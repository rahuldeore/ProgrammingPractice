package hackerrank;

/**
 * Created by Rahul on 1/24/21
 *
 * Watson likes to challenge Sherlock's math ability. He will provide a starting and ending value that describe a range
 * of integers, inclusive of the endpoints. Sherlock must determine the number of square integers within that range.
 *
 * Example: a=24, b=49. There are three square integers in the range: 25,36 and 49. Return 3.
 */
public class WatsonAndSquares {

    // Complete the squares function below.
    // Time limit exceeded
    static int squares(int a, int b) {
        int result = 0;

        Double sqrtLowerRange = Math.sqrt(a);
        Double sqrtHigherRange = Math.sqrt(b);

        result = sqrtHigherRange.intValue() - sqrtLowerRange.intValue();

        if (sqrtLowerRange - sqrtLowerRange.intValue() == 0){
            result++;
        }
        return result;
    }

    public static void main (String... args) {
        //System.out.println(squares(1, 1));
        System.out.println(squares(1, 10));
        System.out.println(squares(2, 10));
        //System.out.println(squares(1, 100));
        //System.out.println(squares(1, 1000));
        //System.out.println(squares(1, 10000));
        //System.out.println(squares(1, 1000000000));
        System.out.println(squares(1, 1000000000));

    }
}
