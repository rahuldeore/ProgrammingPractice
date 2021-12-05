package leetcodearrays;

import java.util.Arrays;

/**
 * Created by Rahul on 11/11/21
 *
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 * Explanation:
 * - index 0 --> the greatest element to the right of index 0 is index 1 (18).
 * - index 1 --> the greatest element to the right of index 1 is index 4 (6).
 * - index 2 --> the greatest element to the right of index 2 is index 4 (6).
 * - index 3 --> the greatest element to the right of index 3 is index 4 (6).
 * - index 4 --> the greatest element to the right of index 4 is index 5 (1).
 * - index 5 --> there are no elements to the right of index 5, so we put -1.
 *
 * Input: arr = [400]
 * Output: [-1]
 * Explanation: There are no elements to the right of index 0.
 *
 */
public class ReplaceElementsWithGreatestOnRight {
    public static int[] replaceElements(int[] arr) {

        int maxToRight = -1, currElem;
        for (int i=arr.length-1; i>=0; i--) {
            currElem = arr[i];
            arr[i] = maxToRight;
            if (maxToRight < currElem) {
                maxToRight = currElem;
            }
        }
        return arr;
    }
    public static void main (String... args) {
        //Assert.assertEquals("Success", new int[]{18,6,6,6,1,-1}, replaceElements(new int[]{17,18,5,4,6,1}));

        Arrays.stream(replaceElements(new int[]{17,18,5,4,6,1})).forEach(num -> System.out.print(num + " "));
        System.out.println();
        Arrays.stream(replaceElements(new int[]{400})).forEach(num -> System.out.print(num + " "));


    }
}
