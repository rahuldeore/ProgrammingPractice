package leedcodeproblems;

import java.util.HashMap;

/**
 * Working but slow algorithm
 *
 * */
public class LongestSubStringOfNonRepeatingChars {
    String inputString;
    Integer stringIndex=null, stringLength=null, subStringLength=null;

    public int lengthOfLongestSubstring(String s) {
        if (s==null || s.length() == 0) return 0;
        this.inputString = s;
        this.stringIndex = null;
        this.stringLength = null;
        this.subStringLength = null;

        String longestSubString=null;
        int longestSubStringLength=0, i=0;

        // Get each non-repeating character substring and its length
        String subString=null;

        while (hasMoreSubString()) {
            subString = getNextSubString();

            if (longestSubStringLength < this.subStringLength) {
                longestSubString = subString;
                longestSubStringLength = this.subStringLength;
            }
        }
        return longestSubStringLength;
    }

    boolean hasMoreSubString() {
        if (stringIndex==null) {
            stringIndex = 0;
            stringLength=inputString.length();
            return true;
        }
        if (stringIndex < stringLength-1) {
            return true;
        } else {
            return false;
        }
    }

    String getNextSubString() {
        StringBuilder s = new StringBuilder();
        HashMap<Character, Integer> subStrings = new HashMap<>();
        this.subStringLength = 0;
        int sIndex = stringIndex;
        while (sIndex <= stringLength-1 && !subStrings.containsKey(inputString.charAt(sIndex))) {
            s.append(inputString.charAt(sIndex));
            subStrings.put(inputString.charAt(sIndex), sIndex);
            sIndex++;
            this.subStringLength++;
        }
        if (sIndex < stringLength) {
            stringIndex = subStrings.get(inputString.charAt(sIndex)) + 1;
        } else {
            stringIndex = sIndex;
        }
        return s.toString();
    }
    public static void main(String args[]){
        /*
        * string examples
        *
        * abcabcab - abc
        * abcabcdeaxml - bcdeaxml
        * bbbbbb - b
        *
        * */
        LongestSubStringOfNonRepeatingChars subStr = new LongestSubStringOfNonRepeatingChars();
        System.out.println(subStr.lengthOfLongestSubstring("abcabcab"));
        System.out.println(subStr.lengthOfLongestSubstring("abcabcabcdef"));
        System.out.println(subStr.lengthOfLongestSubstring("bbbbbb"));
        System.out.println(subStr.lengthOfLongestSubstring("pwwkew"));
        System.out.println(subStr.lengthOfLongestSubstring("dvdf"));
        System.out.println(subStr.lengthOfLongestSubstring("   "));
        System.out.println(subStr.lengthOfLongestSubstring("abcabcdeaxml"));

    }
}
