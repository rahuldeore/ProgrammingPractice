package leetcodearrays;

import org.junit.Assert;

/**
 * Created by Rahul on 11/7/21
 */
public class SearchNumAndDouble {

    public static boolean checkIfExist(int[] arr) {


        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                if (arr[j] == 2 * arr[i] && i != j) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String... args) {
        Assert.assertEquals(true, checkIfExist(new int[]{10,2,5,3}));
        Assert.assertEquals(false, checkIfExist(new int[]{-2,0,10,-19,4,6,-8}));

    }
}
