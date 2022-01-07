package leetcodearrays;

import java.util.Arrays;

/**
 * Created by Rahul on 11/30/21
 *
 * Exp --> [1,1,1,2,3,4]
 * I/P --> [1,1,4,2,1,3]
 *
 *
 */
public class HeightChecker {

    /*
    * Solution from leetcode
    * */
    public int heightCheckerSol(int[] heights) {
        if(heights == null) return 0;
        if(heights.length == 1) return 1;

        int length = heights.length;
        int[] copy = Arrays.copyOf(heights, length);

        Arrays.sort(copy);

        int result = 0;
        for(int i = 0; i < length; i++){
            if(heights[i] != copy[i]){
                result++;
            }
        }
        return result;
    }

    public static int heightChecker(int[] heights) {
        int length = heights.length, mismatch=0;
        int[] expected = Arrays.copyOf(heights, length);
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
