package leetcodearrays;

/**
 * Created by Rahul on 9/26/21
 */
public class SquaresOfSortedArraySorted_02 {
    // HINT: use two pointers i and j since there are negative numbers whose absolute value could be larger than some non negative numbers
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int left=0, right=length-1;
        return result;
    }

/*
    public int[] sortedSquares(int[] nums) {
        for (int i=0; i< nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
*/

/* 66.75%
for (int i=0; i< nums.length; i++) {
    nums[i] = nums[i] * nums[i];
}
Arrays.sort(nums);
return nums;
*/

/* 11.7%
return Arrays.stream(nums)
    .map(num -> num * num)
    .sorted()
    .toArray();
*/



}
