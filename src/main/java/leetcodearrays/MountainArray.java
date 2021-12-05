package leetcodearrays;

/**
 * Created by Rahul on 11/10/21
 * Input: arr = [2,1]
 * Output: false
 *
 * Input: arr = [3,5,5]
 * Output: false
 *
 * Input: arr = [0,3,2,1]
 * Output: true
 */
public class MountainArray {
    public boolean validMountainArray(int[] arr) {
        int length = arr.length, peak=1;

        if (length < 3) return false;

        // Check uphil
        while (peak < length && arr[peak-1] < arr[peak]) {
            peak++;
        }
        if (peak == length || peak == 1)
            return false;
        // Check downhill
        while(peak < length && arr[peak-1] > arr[peak]) {
            peak++;
        }
        if (peak == length)
            return true;
        return false;
    }
}
