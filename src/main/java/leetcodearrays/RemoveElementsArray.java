package leetcodearrays;

import java.util.Objects;

/**
 * Created by Rahul on 10/17/21
 */
public class RemoveElementsArray {
    public static int removeElements(int[] nums, int val) {
        int leftIndex=0, rightIndex = nums.length-1, length=nums.length;

        if (rightIndex < 0) return 0; // empty array

        while (leftIndex <= rightIndex && leftIndex < length) {
            if (nums[leftIndex] == val) {
                while (rightIndex >= 0 && nums[rightIndex] == val) {
                    rightIndex--;
                }
                if (rightIndex > leftIndex) {
                    nums[leftIndex] = nums[rightIndex];
                    nums[rightIndex]=val;
                    rightIndex--;
                    leftIndex++;
                }
            } else if (nums[leftIndex] != val) {
                leftIndex++;
            }
        }
        if (leftIndex < length && nums[leftIndex] != val) {
            leftIndex++;
        }
        return leftIndex;
    }

    /*
    * Sample best solution from leetcode
    * */
    public static int removeElements2(int[] nums, int val) {
        Objects.requireNonNull(nums);

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    public static void main(String... args) {

        int k;

        k = removeElements(new int[]{3,2,2,3}, 3);
        System.out.print("\n{3,2,2,3}: " + k);

        k = removeElements(new int[]{0,1,2,2,3,0,4,2}, 2);
        System.out.print("\n{0,1,2,2,3,0,4,2}: " + k);

        k = removeElements(new int[]{}, 0);
        System.out.print("\n{}: " + k);

        k = removeElements(new int[]{1}, 1);
        System.out.print("\n{1}: " + k);

        k = removeElements(new int[]{3,3}, 3);
        System.out.print("\n{3,3}: " + k);

        k = removeElements(new int[]{0,4,4,0,4,4,4,0,2}, 4);
        System.out.print("\n{0,4,4,0,4,4,4,0,2}: " + k); // k should be 4

        k = removeElements(new int[]{4,5}, 5);
        System.out.print("\n{4,5}: " + k);

        k = removeElements(new int[]{3}, 5);
        System.out.print("\n{3}: " + k);

        System.out.println();

        k = removeElements2(new int[]{3,2,2,3}, 3);
        System.out.print("\n{3,2,2,3}: " + k);

        k = removeElements2(new int[]{0,1,2,2,3,0,4,2}, 2);
        System.out.print("\n{0,1,2,2,3,0,4,2}: " + k);

        k = removeElements2(new int[]{}, 0);
        System.out.print("\n{}: " + k);

        k = removeElements2(new int[]{1}, 1);
        System.out.print("\n{1}: " + k);

        k = removeElements2(new int[]{3,3}, 3);
        System.out.print("\n{3,3}: " + k);

        k = removeElements2(new int[]{0,4,4,0,4,4,4,0,2}, 4);
        System.out.print("\n{0,4,4,0,4,4,4,0,2}: " + k); // k should be 4

        k = removeElements2(new int[]{4,5}, 5);
        System.out.print("\n{4,5}: " + k);

        k = removeElements2(new int[]{3}, 5);
        System.out.print("\n{3}: " + k);
    }
}
