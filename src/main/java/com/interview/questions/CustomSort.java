package com.interview.questions;
/*
 * Complete the 'moves' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY arr as parameter.
 *
 4    →   arr[] size n = 4
13   →   arr = [13, 10, 21, 20]
10
21
20
*
* O/P 1
*
*
* STDIN    Function
-----    --------
5    →   arr[] size n = 5
8    →   arr = [8, 5, 11, 4, 6]
5
11
4
6
*
* O/P 2
 */

import java.util.ArrayList;
import java.util.List;

public class CustomSort {

    public static int moves(List<Integer> arr) {
        // Write your code here
        int evenIndex=0, oddIndex = arr.size()-1, swaps=0;
        while (evenIndex < oddIndex && evenIndex < arr.size() && oddIndex >=0) {
            if (arr.get(evenIndex) % 2 != 0){
                // find even number from the reverse array
                while (evenIndex != oddIndex) {
                    if (arr.get(oddIndex) % 2 == 0) {
                        swaps++;
                        oddIndex--;
                        break;
                    } else {
                        oddIndex--;
                    }
                }
            }
            evenIndex++;
        }
        return swaps;
    }

    public static void main (String args[]) {
        List<Integer> input = new ArrayList<>(List.of(4,13,10,21,20));
        System.out.println(moves(input));

        input = new ArrayList<>(List.of(82921272, 110219722, 162495938, 470311130, 583170602, 329963077, 403414481, 437623101, 485366585, 599466263, 959094281));
        System.out.println(moves(input));


    }
}
