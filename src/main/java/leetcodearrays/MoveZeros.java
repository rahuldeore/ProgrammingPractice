package leetcodearrays;

import java.util.Arrays;

/**
 * Created by Rahul on 11/13/21
 * [0,1,2,0,4,3,22,0,9] ==> [1,2,4,3,22,9,0,0,0]
 * [0,1,2,3,0,0,0] ==> [1,2,3,0,0,0,0]
 * [0,0,0,0] ==> [0,0,0,0]
 * [] ==> []
 * [1,0] ==> [1,0]
 * [1] ==> [1]
 * [2,1] ==> [2,1]
 * [1,2,3,4] ==> [1,2,3,4]
 */
public class MoveZeros {
    public static void moveZeroes(int[] nums) {
        int length=nums.length, putIndex=0, temp=0;
        for(int i=0; i<length; i++) {
            if(nums[i] != 0) {
                temp = nums[putIndex];
                nums[putIndex] = nums[i];
                nums[i] = temp;
                putIndex++;
            }
        }
        Arrays.stream(nums)
              .forEach(num -> System.out.print(num + " "));

    }
    public static void main(String... args) {
        moveZeroes(new int[]{0,1,2,0,4,3,22,0,9});
        System.out.println();
        moveZeroes(new int[]{0,1,2,3,0,0,0});
        System.out.println();
        moveZeroes(new int[]{0,0,0,0});
        System.out.println();
        moveZeroes(new int[]{});
        System.out.println();
        moveZeroes(new int[]{1,0});
        System.out.println();
        moveZeroes(new int[]{1});
        System.out.println();
        moveZeroes(new int[]{2,1});
        System.out.println();
        moveZeroes(new int[]{1,2,3,4});
        System.out.println();
    }
}
