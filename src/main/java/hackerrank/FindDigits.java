package hackerrank;

/**
 * Created by Rahul on 1/15/21
 *
 * Given an integer, for each digit that makes up the integer determine whether it is a divisor. Count the number of
 * divisors occurring within the integer.
 *
 * n=124
 * Check whether 1,2 and 4 are divisors of 124. All three numbers divide evenly into 124 so return 3.
 * n=10
 * 0 is not divisor of 10 but 1 is. So return 1.
 */
public class FindDigits {

    static int findDigits(int n) {

        int num = n;
        int divisors = 0;

        while (num != 0) {
            int lastDigit = num % 10;
            if (lastDigit != 0 && n % lastDigit == 0) {
                divisors++;
            }
            num = num / 10;
        }

        return divisors;
    }

    public static void main (String args[]) {
        System.out.println(findDigits(124));
        System.out.println(findDigits(123456789));
        System.out.println(findDigits(10));
    }

}
