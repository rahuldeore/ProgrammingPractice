package com.interview.questions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class ArrayRotate {

    public static void main (String args[]) throws Exception{

        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine()), s=0;
        String twoDArray = bufferedReader.readLine();
        String[] array = twoDArray.split(" ");
        StringBuilder sb = new StringBuilder();
        int [][] arr = new int[n][n];
        for (int j=n-1; j>=0; j--) {
            for(int i=0; i<n; i++){
                arr[i][j] = Integer.parseInt(array[s]);
                s++;
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                sb.append(arr[i][j]+" ");
            }
        }
        //System.out.println(sb.toString());
        bufferedWriter.write(sb.toString());
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();

    }
}
