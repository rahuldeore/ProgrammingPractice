package leetcodearrays;

/**
 * Created by Rahul on 9/19/21
 */
public class MaxConsecutiveOnes_01 {
    public static int solution(int[] nums) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (getDigitCount(nums[i]) % 2 == 0) {
                count++;
            }
        }
        return count;
    }
// 96%
//    int eventCount = 0, count = 0, num = 0;
//        for (int i = 0; i < nums.length; i++) {
//        count = 0;
//        num = nums[i];
//        while (num != 0) {
//            num = num / 10;
//            count++;
//        }
//        if (count % 2 == 0) {
//            eventCount++;
//        }
//    }
//        return eventCount;


// 18%
//        return (int)Arrays.stream(nums)
//                .map(num -> getDigitCount(num)) //return the count of digits
//                .filter(digitCount -> digitCount % 2 == 0 )
//                .count();

    public static int getDigitCount(int num) {
        int count = 0;
        while (num != 0 ) {
            num = num / 10;
            count ++;
        }
        return count;
    }
 }
