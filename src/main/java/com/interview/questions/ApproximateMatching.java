package com.interview.questions;

import java.io.*;


/*
 * Complete the 'calculateScore' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. STRING text
 *  2. STRING prefixString
 *  3. STRING suffixString
 * nothing
 * bruno
 * ingenious
 * o/p nothing
 * The substring of the text with the highest textScore begins with prefix no and ends with suffix ing is nothing
 *
 *
 */
public class ApproximateMatching {
    public static String calculateScore(String text, String prefixString, String suffixString) {
        // Write your code here
        int prefixScore=0, suffixScore=0, textScore=0;
        int index = 0;
        //find prefix score and largest prefix slice from prefixString end matching substring in text
        while (index != prefixString.length()-1) {

        }

        // find suffix score similar to prefix score
        //the substring of text that begins with matching prefix and ends with matching suffix is the string to remember

        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String text = bufferedReader.readLine();

        String prefixString = bufferedReader.readLine();

        String suffixString = bufferedReader.readLine();

        String result = ApproximateMatching.calculateScore(text, prefixString, suffixString);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
