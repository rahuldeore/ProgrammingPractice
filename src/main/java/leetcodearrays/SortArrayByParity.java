package leetcodearrays;

import java.util.Arrays;

/**
 * Created by Rahul on 11/21/21
 *
 * [3,1,2,4] ==> [2,4,3,1] or [2,4,3,1] or [4,2,3,1]
 */
public class SortArrayByParity {
    public static int[] sortArrayByParity(int[] nums) {
        int even=0, temp=0, length=nums.length;
        for (int i=0; i<length && even < length; i++) {
            if (nums[i] % 2 == 0) {
                even++;
            } else {
                while (even < length && nums[even] % 2 != 0) {
                    even++;
                }
                if(even >= length) {
                    break;
                }
                temp = nums[even];
                nums[even] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }

    public static void main(String... args) {

        int nums[];
        nums = sortArrayByParity(new int[]{2,3,9,8,17,1,12,63,20});
        Arrays.stream(nums)
                .forEach(num -> System.out.print(num + " "));

    }

}