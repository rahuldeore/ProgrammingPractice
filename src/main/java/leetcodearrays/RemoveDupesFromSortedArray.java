package leetcodearrays;

import org.junit.Assert;

/**
 * Created by Rahul on 10/26/21
 */
public class RemoveDupesFromSortedArray {
    /**
     * runtime - 86 percentile
     * memory - 66 percentile
     */
    public static int removeDuplicates2(int[] nums) {
        int fillIndex=0, length=nums.length, uniqIndex=1;
        Boolean copy = false;

        while (uniqIndex < length) {
            if (nums[fillIndex] == nums[uniqIndex]) copy = true;
            while (uniqIndex < length && nums[fillIndex] == nums[uniqIndex]) {
                uniqIndex++;
            }
            if (uniqIndex >= length) {
                return fillIndex + 1;
            }
            fillIndex++;
            if (copy == true) {
                nums[fillIndex] = nums[uniqIndex];
            }
            uniqIndex++;
        }
        return fillIndex + 1;
    }

    /**
     *
     * */
    public static int removeDuplicates(int[] nums) {
        int fillIndex=0, length=nums.length, uniqIndex=1;
        for (uniqIndex=1; uniqIndex<length; uniqIndex++) {
            if (nums[fillIndex] != nums[uniqIndex]) {
                fillIndex++;
                nums[fillIndex] = nums[uniqIndex];
            }
        }
        return fillIndex + 1;
    }

    public static void main (String... args) {

        Assert.assertEquals(5, removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));

        Assert.assertEquals(2, removeDuplicates(new int[]{1,1,2,2}));

        Assert.assertEquals(5, removeDuplicates(new int[]{0,1,2,3,4}));

    }

}
