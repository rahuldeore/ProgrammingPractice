package leetcodearrays;

/**
 * Created by Rahul on 9/30/21
 *
 */
public class DuplicateZeros_03 {

/*  27.81, 60.80 percentile runtime and memory dist
    public static void duplicateZeros(int[] arr) {
        int length = arr.length;
        for (int i=0; i<length; i++){
            if (arr[i] == 0) {
                arr = dupe(i, arr, length); // TODO: When array is passed in function parameters, is it reconstructing
                                                //new array or passing reference
                i++;
            }
        }
    }
    public static int[] dupe(int index, int[] arr, int length){
        for (int i=length-1; i>index; i--) {
            arr[i] = arr[i-1];
        }
        return arr;
    }*/


    /** Too complicated to implement and not working
     * [0, 2, 0, 4, 5, 0, 7, 8, 9, 0]
     * When shifting, assume your array is only this much: [0, 2, 0, 4, 5, 0, (7)]. 7 is in parenthesis to denote it is
     * not originally part of the shift and dupe logic but later became eligible when zero count from scrap parts were
     * removed from totalZeros
     *
     * Consider this as scrap part of the array: [(7), 8, 9, 0]
     *
     * Result should be: [0, 0, 2, 0, 0, 4, 5, 0, 0, 7]
     * */
    /*public static void duplicateZeros(int[] arr) {
        int totalZeros = 0, length = arr.length;
        // 1 pass traverse on the array to count the total zeros and remember the indexes of each zero
        for (int i=0; i<length; i++) {
            if (arr[i] == 0) {
                totalZeros++;
            }
        }
        if (totalZeros == arr.length || totalZeros == 0) {
            return;
        }
        // reduce the total zero count if zeros exist in the scrap part of the array
        for (int i = length - totalZeros; i < length; i++) { // start from first index in scrap part of array
            if (arr[i] == 0) {
                totalZeros--;
            }
        }
        // shift elements and dupe zeros
        for (int i = length - totalZeros - 1; i >= 0; i--) {
            if (arr[i] == 0 && i != length - totalZeros - 1) {
                arr[i + totalZeros] = arr[i]; // shift the zero
                arr[i + totalZeros - 1] = 0; // dupe the zero to previous position
                totalZeros--;
            } else {
                arr[i + totalZeros] = arr[i];
            }
        }
        Arrays.stream(arr)
                .forEach(num -> System.out.print(num + " "));
    }*/

    /*
    * Runtime 100% percentile
    * Using temp array and copy to original array
    * Time complexity - O(n)
    * Space complexity - O(n)
    * */
    /*public static void duplicateZeros(int[] arr) {
      int length = arr.length;
      int[] arr2 = new int[length];

      for (int i=0, j=0; j<length; i++, j++) {
          if (arr[i] == 0) {
              arr2[j] = 0;
              if (j < length-1) j++;
              arr2[j] = 0;
          } else {
              arr2[j] = arr[i];
          }
      }
      for(int i=0; i<length; i++) {
          arr[i] = arr2[i];
      }
    }*/
    public static void duplicateZeros(int[] arr) {
        int len = arr.length, zeros = 0;
        // Count zeros
        for (int i=0; i<len; i++) {
            if (arr[i] == 0)
                zeros++;
        }
        // Reduce zero count if zero exist in the scrap part of the array.
        for (int i=len-zeros; i<len-1; i++) {
            if (arr[i] == 0)
                zeros--;
        }

        // ideal cases
        if (zeros > 0 || zeros != len) {
            for (int i=len-1, j=i-zeros; i>=0 && j>=0; i--, j--) {
                arr[i] = arr[j];
                if (arr[j] == 0) {
                    i--;
                    arr[i] = 0;
                }
            }
        }
    }

    public static void main (String... args) {
        int[] nums = {1,0,2,3,0,4,5,0};
        duplicateZeros(nums);
        System.out.println();
        int[] nums1 = new int[]{0, 0, 0, 0, 0, 0, 0};
        duplicateZeros(nums1);
        System.out.println();
        int[] nums2 = {0,1,7,6,0,2,0,7};
        duplicateZeros(nums2);
        int[] nums3 = {8,4,5,0,0,0,0,7};
        duplicateZeros(nums3);
    }
}
