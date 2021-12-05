package leetcodearrays;

import java.util.Arrays;

/**
 * Created by Rahul on 11/30/21
 */
public class HeightChecker {

    public static int heightChecker(int[] heights) {
        int length = heights.length, mismatch=0;
        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);

        for (int i=0; i<length; i++) {
            if (heights[i] != expected[i]) {
                mismatch++;
            }
        }
        return mismatch;
    }

    public static void main(String... args) {
        System.out.println(heightChecker(new int[]{1,1,4,2,1,3}));
        System.out.println(heightChecker(new int[]{5,1,2,3,4}));
        System.out.println(heightChecker(new int[]{1,2,3,4,5}));
    }
}
