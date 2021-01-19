package hackerrank;

/**
 * Created by Rahul on 1/16/21
 *
 * @TODO ----- TRY TO REWRITE A BETTER VERSION -----
 *
 * You have two strings of lowercase English letters. You can perform two types of operations on the first string:
 * 1. Append a lowercase English letter to the end of the string.
 * 2. Delete the last character of the string. Performing this operation on an empty string results in an empty string.
 *
 * Sample input:
 * s = hackerhappy
 * t = hackerrank
 * k = 9
 * Return Yes
 * To convert s to t, we will need to delete 5 letters from the end of s and add 4 letters from t into s. So the cost
 * of doing that is 5 + 5 = 9
 *
 * aba
 * aba
 * 7
 *
 * Return Yes
 *
 * We perform 4 delete operations to reduce string s to the empty string. Recall that though the string will be empty
 * after 3 deletions, we can still perform a delete operation on an empty string to get the empty string. Next, we
 * perform 3 append operations (i.e., a, b, and a). Because we were able to convert s to t by performing exactly 7
 * operations, we return Yes.
 *
 *
 * ashley
 * ash
 * 2
 * Return No
 * SOLUTION---
 * Case 1
 *  s and t are same length
 *  hackerrank
 *  hackerbank
 * Case 2
 *  s is longer than t
 *  hackerhappy
 *  hackerrank
 * Case 3
 *  s is shorter than t
 *  hackers
 *  hackerrank
 * Case 4
 *  both are null
 *
 */
public class AppendAndDelete {

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        String result = "No";

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int index; // index where s is starting to differ from t
        for (index=0 ; index<t.length(); index++) {
            if (index < s.length()) {
                if (! (sChars[index] == tChars[index]) ) {
                    break;
                }
            } else {
                // s is shortest string and has been compared
                break;
            }
        }

        Boolean totalErase = index == 0 ? true : false;

        int sDeletions = s.length() - (index); // number of deletions required in s
        int sAdditions = t.length() - (index);

        if (k >= (sDeletions + sAdditions)) {
            result = "Yes";
            // check one edge case where we have surplus k-x steps remaining. If we can utilize the surplus steps
            // and keep the original string intact, it is a Yes, otherwise No.
            // also handle the case when deletion on empty string is possible ex: s=abc, t=abc, k=7, one deletion
            // on empty string is possible
            int surplusSteps = k - (sDeletions + sAdditions);
            if ( surplusSteps > 0 && !totalErase) {
                if ( !(surplusSteps%2 == 0 || surplusSteps >= t.length()*2) ) {
                        result = "No";
                }
            }
        }
        System.out.println(s + " | " + t + " | " + k + " | " + result);
        return result;
    }
    public static void main (String... args) {

        appendAndDelete("hackerhappy", "hackerrank", 9); //Yes
        appendAndDelete("hackerrank", "hacker", 1); //No
        appendAndDelete("hacker", "hackerrank", 1); //No
        appendAndDelete("hacker", "hackerrank", 4); //Yes
        appendAndDelete("hacker", "hackerrank", 5); //No
        appendAndDelete("hackeraank", "hackerrank", 1); //No
        appendAndDelete("hackeraank", "hackerrank", 8); //Yes
        appendAndDelete("hackerrank", "hackeraank", 14); //Yes
        appendAndDelete("hackerrank", "hackeraank", 13); //No
        appendAndDelete("abc", "abc", 0); //Yes
        appendAndDelete("abc", "xyz", 0); //No
        appendAndDelete("abcd", "abcdert", 11); //Yes
        appendAndDelete("abcd", "abcdert", 10); //No, cannot convert in exactly 10 operations
        appendAndDelete("abc", "abc", 3); //No, cannot convert in exactly 3 steps, even though they are same
        appendAndDelete("abc", "abc", 2); //Yes
        appendAndDelete("abc", "abc", 7); //Yes, i can perform 4 delete and 3 append.
        /* the below three troubled me */
        appendAndDelete("abcdef", "fedcba", 15); // Yes
        appendAndDelete("abc", "xyz", 8); // Yes
        appendAndDelete("abc", "xyz", 9); // Yes
    }
}
