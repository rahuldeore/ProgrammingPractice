package leetcodearrays;

import org.junit.Assert;

/**
 * Created by Rahul on 11/11/21
 *
 * [0, 0, 0, 1, 1, 3, 4, 5, 5, 5, 19, 19, 19, 60] ==> [0, 1, 3, 4, 5, 19, 60, x, x, x, x, x, x, x] Return k=7
 * [1,2,3,4,5] ==> [1,2,3,4,5] k=5
 * [] ==> [] k=0
 * [5,5] ==> [5,5] k=1
 * [1] ==> [1] k=1
 *
 */
public class RemoveDupesFromSortedArray_Repeat {
    public static int removeDuplicates(int[] nums) {
        int length = nums.length, k=0;

        if(length == 0) {
            return 0;
        }
        for (int i=0; i<length; i++) {
            if (nums[k] != nums[i]) {
                k++;
                nums[k] = nums[i];
            }
        }
        return k + 1;
    }
    public static void main(String... args) {
        Assert.assertEquals(7, removeDuplicates(new int[] {0, 0, 0, 1, 1, 3, 4, 5, 5, 5, 19, 19, 19, 60}));
        Assert.assertEquals(5, removeDuplicates(new int[] {1,2,3,4,5}));
        Assert.assertEquals(0, removeDuplicates(new int[] {}));
        Assert.assertEquals(1, removeDuplicates(new int[] {5,5}));
        Assert.assertEquals(1, removeDuplicates(new int[] {1}));
    }
}
