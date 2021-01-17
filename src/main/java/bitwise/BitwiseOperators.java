package bitwise;

/**
 * Created by Rahul on 3/15/20
 *
 * Mathematical division and bitwise right by 1 both yields same results.
 * 0 - 000
 * 1 - 001
 * 2 - 010
 * 3 - 011
 * 4 - 100
 * 5 - 101
 * 6 - 110
 * 7 - 111
 *
 * 2 + 5 = 6 = 110 in binary
 * bitwise right shift makes the leading bit 0 and truncates trailing bit i.e 110 becomes 011 which is 3
 * Ques: Is bitwise right shift cheaper than arithmetic average ?
 *  Ans: Yes. Refer below information.
 *  The result of a Left Shift operation is a multiplication by 2**n , where n is the number of shifted bit positions.
 *  The result of a Right Shift operation is a division by 2**n , where n is the number of shifted bit positions.
 *
 *  Note: With the shift operation, you can only work with number in multiples of 2. For example, if you want to divide
 *  a number by 3, you cannot use bitwise shifting. TODO: What else can I do to work with odd numbers ???
 */
public class BitwiseOperators {
    static class RightShift {
        static int rightShiftByPosition(int a, int pos) {
            return a >>> pos;
        }
    }

    static class LeftShift {
        static int leftShiftByPosition(int a, int pos) {
            return a << pos;
        }
    }


    public static void main(String[] args) {
        int a = 2, b = 4;
        int rightShiftByOne = RightShift.rightShiftByPosition(a + b, 1);
        System.out.println("Bitwise right shift of " + a + " and "+ b + " is: " + rightShiftByOne);
        System.out.println("Mathematical average of " + a + " and "+ b + " is: " +(a+b)/2);

        int leftShiftByOne = LeftShift.leftShiftByPosition(a + b, 1);
        System.out.println("Bitwise right shift of " + a + " and "+ b + " is: " + rightShiftByOne);
        System.out.println("Mathematical average of " + a + " and "+ b + " is: " +(a+b)*2);

    }
}
