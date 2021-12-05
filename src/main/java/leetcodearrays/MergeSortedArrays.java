package leetcodearrays;

import java.util.Arrays;

/**
 * Created by Rahul on 10/12/21
 */
public class MergeSortedArrays {

    /*
    * arrays are sorted in natural order / ascending order. m and n are total number of elements in respective arrays
    *
    * Size of nums1 is m+n and size of nums2 is n
    * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    *
    * Output: [1,2,2,3,5,6]
    * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
    * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
    * */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int ar1 = m-1, ar2 = n-1;
        for (int index=m+n-1; index >= 0; ) {
            if (ar1>=0 && ar2>=0 ) {
                if (nums1[ar1] > nums2[ar2]) {
                    nums1[index] = nums1[ar1];
                    index--;
                    ar1--;
                } else {
                    nums1[index] = nums2[ar2];
                    index--;
                    ar2--;
                }
            } else if (ar2 >= 0) {
                nums1[index] = nums2[ar2];
                index--;
                ar2--;
            } else {
                nums1[index] = nums1[ar1];
                index--;
                ar1--;
            }
        }
        Arrays.stream(nums1)
                .forEach(System.out::println);
    }

    public static void main(String... args) {
        int[] nums1={1,2,3,0,0,0}, nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3 );
        System.out.println();

        merge(new int[]{0}, 0, new int[]{1}, 1 );
        System.out.println();

        merge(new int[]{2, 0}, 1, new int[]{1}, 1 );
        System.out.println();

        merge(new int[]{}, 0, new int[]{}, 0 );
        System.out.println();
    }

}
