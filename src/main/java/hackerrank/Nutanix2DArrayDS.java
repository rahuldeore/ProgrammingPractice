package hackerrank;

/**
 * Created by Rahul on 1/24/21
 * Given a 6x6 2D Array, arr:
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * An hourglass in A is a subset of values with indices falling in this pattern in arr's graphical representation:
 *
 * a b c
 *   d
 * e f g
 *
 * There are 16 hourglasses in arr. An hourglass sum is the sum of an hourglass' values. Calculate the hourglass sum for
 * every hourglass in arr, then print the maximum hourglass sum. The array will always be 6x6.
 *
 * Example:
 * -9 -9 -9  1 1 1
 *  0 -9  0  4 3 2
 * -9 -9 -9  1 2 3
 *  0  0  8  6 6 0
 *  0  0  0 -2 0 0
 *  0  0  1  2 4 0
 *
 *  The 16 hourglass sums are:
 *
 *  -63, -34, -9, 12,
 * -10,   0, 28, 23,
 * -27, -11, -2, 10,
 *   9,  17, 25, 18
 *
 *   The highest hourglass sum is 28 from the hourglass beginning at row 1, column 2:
 *   0 4 3
 *     1
 *   8 6 6
 *
 *   so return 28.
 *
 */

public class Nutanix2DArrayDS {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        Integer maxHourGlassSum = null;

        for (int i=0; i<=3; i++) {
            for (int j=0; j<=3; j++) {
                Integer oneHourGlassSum = (arr[i][j] + arr[i][j+1] + arr[i][j+2]) +
                        arr[i+1][j+1] +
                        (arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2]);
                if(maxHourGlassSum==null || maxHourGlassSum < oneHourGlassSum) {
                    maxHourGlassSum = oneHourGlassSum;
                }
            }
        }
        return maxHourGlassSum;
    }

    public static void main(String... args) {
        System.out.println(hourglassSum(new int[][]{{1,1,1,0,0,0},{0,1,0,0,0,0},{1,1,1,0,0,0},{0,0,0,0,0,0},
                {0,0,0,0,0,0},{0,0,0,0,0,0}}));
    }

}
