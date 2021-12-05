package leetcodearrays;

import java.util.Arrays;

/**
 * Created by Rahul on 11/28/21
 */
public class RemoveElementsFromArray_2 {
    public static int removeElement(int[] nums, int val) {
        int nonVal = 0, length = nums.length, temp=0;
        int i=0;
        for (i=0; i<length && nonVal < length; i++) {
            if(nums[i] != val) {
                nonVal++;
            } else {
                while (nonVal < length && nums[nonVal] == val) {
                    nonVal++;
                }
                if(nonVal >= length) {
                    break;
                }
                temp=nums[i];
                nums[i] = nums[nonVal];
                nums[nonVal] = temp;
            }
        }

        Arrays.stream(nums)
                .forEach(num -> System.out.print(num + " "));
        return i;
    }

    public static void main(String... args) {
        removeElement(new int[]{3,2,2,3}, 3);
    }
}
