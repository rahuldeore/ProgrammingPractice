package contest185;
/**
 * Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).
 *
 * You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit. That is, no two adjacent characters have the same type.
 *
 * Return the reformatted string or return an empty string if it is impossible to reformat the string.
 *
 * Input: s = "a0b1c2"
 * Output: "0a1b2c"
 * Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.
 *
 * Input: s = "leetcode"
 * Output: ""
 * Explanation: "leetcode" has only characters so we cannot separate them by digits.
 *
 * Input: s = "covid2019"
 * Output: "c2o0v1i9d"
 *
 * Input: s = "ab123"
 * Output: "1a2b3"
 *
 * */
public class ReformatTheString {

    public static String reformat(String s) {
        String[] ch= new String(s).split("([^a-z]+)"), nm = s.split("([0-9]+)");
        char[] chars = ch[0].toCharArray(), nums = nm[0].toCharArray();
        for (char str : chars) {
            System.out.print(str);
        }
        System.out.println();
        for (char str : nums) {
            System.out.print(str);
        }

        if (Math.abs(chars.length - nums.length) > 1) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        if (String.valueOf(s.charAt(0)).equalsIgnoreCase(String.valueOf(chars[0]))) {
            for (int i=0; i<chars.length;i++) {
                str.append(nums[i]);
                str.append(chars[i]);
            }
        } else {
            for (int i=0; i<chars.length;i++) {
                str.append(chars[i]);
                str.append(nums[i]);
            }
        }
        return str.toString();
    }

    public static void main(String args[]) {
        String s = reformat("covid2019");
        System.out.println(s);

    }

}
