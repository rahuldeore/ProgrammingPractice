package hackerrank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Rahul on 12/26/20
 *
 * Worked !
 */
public class BetweenTwoSets {

    /**
     * There will be two arrays of integers. Determine all integers that satisfy the following two conditions:
     * The elements of the first array are all factors of the integer being considered
     * The integer being considered is a factor of all elements of the second array
     * These numbers are referred to as being between the two arrays. Determine how many such numbers exist.
     *
     * Example
     * a=[2,6]
     * b=[24,36]
     * There are two numbers between the arrays: 6 and 12.
     * 6%2=0, 6%6=0, 24%6=0 AND 36%6=0
     * */

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {

        int totalX = 0;

        List<Integer> betweenNums = new ArrayList<>();
        Optional<Integer> listNum = a.stream().max(Comparator.comparing(Integer::intValue));
        Integer list1Max = listNum.orElse(null);
        if (list1Max == null) {
            return 0;
        }
        listNum = b.stream().min(Comparator.comparing(Integer::intValue));
        Integer list2Min = listNum.orElse(null);
        if (list2Min == null) {
            return 0;
        }

        /*
        * Step1:
        * Find the between numbers whose factors are each elements of list a
        * */
        for (int num=list1Max; num<=list2Min; num++) {
            int betweenNum = num;
            List<Integer> notFactors = a.stream()
                    .filter(x -> betweenNum % x != 0 )
                    .collect(Collectors.toList());
            if (notFactors.isEmpty()) {
                // this means all elements of list a are factors of current betweenNum
                betweenNums.add(betweenNum);
            }
        }

        /*
        * Step2:
        * Filter the between numbers that are factor of each element in list b
        * */
        List<Integer> betweenNums2 = new ArrayList<>();
        for (Integer betweenNum : betweenNums) {
            List<Integer> notBetween = b.stream()
                    .filter( x -> x % betweenNum != 0)
                    .collect(Collectors.toList());

            if (notBetween.isEmpty()) {
                betweenNums2.add(betweenNum);
                totalX++;
            }
        }


        return totalX;
    }

    public static void main(String... args) {
        System.out.println("totalX: " + getTotalX(List.of(2,6), List.of(24,36)));
    }
}
