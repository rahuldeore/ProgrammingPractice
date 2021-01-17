package com.interview.questions;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Rahul on 2/10/20
 */
public class CodilityOTA {
    // Find smallest positive integer greater than 0 missing in the array A.
    public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> sortedA = new TreeSet<Integer>(Comparator.naturalOrder());
        for (int a : A) {
            if (a > 0) {
                sortedA.add(a);
            }
        }
        Iterator<Integer> iteratorA = sortedA.iterator();
        int smallest = 1;
        while (iteratorA.hasNext()) {
            if (iteratorA.next() == smallest){
                smallest++;
            } else {
                return smallest;
            }
        }
        return smallest;
    }
    // for adding 5 to a number
    public int solution(int N) {
        // write your code in Java SE 8
        String num = N + ""; // converting the number into string for iteration on each digit
        String newN = "";
        boolean fiveInserted = false, sign = false;

        if (N < 0) {
            num = num.substring(1,num.length());
            sign = true;
        }

        for (int i=0; i<num.length(); i++) {
            if(!fiveInserted && Integer.parseInt(String.valueOf(num.charAt(i))) < 5) {
                newN = newN + "5";
                fiveInserted = true; // once 5 is inserted, do not insert again but construct the result string
            }
            newN = newN + num.charAt(i);
        }
        if (!fiveInserted) {
            if (sign) {
                newN = "-5" + newN; // for -ve numbers, special case
            } else {
                newN = newN + "5"; // for large numbers
            }
        }
        return Integer.valueOf(newN);
    }

    // find common equilibrium index of both arrays
    public int solution(int[] A, int[] B) {
        /* The approach is to find the balancing index of first array and check if its the balancing index of second
        array, if it is, return the index. If not, find the next balance index.
        To find the balance index, find the sum of the elements of A and maintain left and right sum variables. Then
        keep shifting the balance index on the array A until both left and right sum are equal. Use that index to find
        if array B is balanced. if it is balanced, then return the index and done. */

        int sumA = 0, sumB = 0;
        // Get the sum of both arrays separately
        for (int i=0; i< A.length; i++) {
            sumA += A[i];
            sumB += B[i];
        }
        int K = 0;
        int leftSumA = 0, rightSumA = sumA;
        for (int i=0; i<A.length; i++) {
            //visually shift the balance index
            leftSumA += A[i];
            rightSumA -= A[i];

            if (leftSumA == rightSumA) {
                // use this i to check array B balance
                boolean commonBalance = checkBalanceOfB(i, sumB, B);
                if (commonBalance) {
                    K = i;
                }
            }
        }
        return K;
    }
    boolean checkBalanceOfB(int index, int sumB, int[] B) {
        int leftSum = 0, rightSum = sumB;
        for (int i=0; i<index; i++) {
            leftSum += B[i];
        }
        return true;
    }

    public static void main (String args[]) {
        CodilityOTA test = new CodilityOTA();
        System.out.println(test.solution(457));
        System.out.println(test.solution(9999));
        System.out.println(test.solution(-9999));
        System.out.println(test.solution(new int[] {1,2,0,2,1}, new int[]{4,-1,0,-1,4}));
    }
}
