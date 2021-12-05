package hackerrank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Rahul on 7/4/21
 *
 * You are given a number of sticks of varying lengths. You will iteratively cut the sticks into smaller sticks,
 * discarding the shortest pieces until there are none left. At each iteration you will determine the length of the
 * shortest stick remaining, cut that length from each of the longer sticks and then discard all the pieces of that
 * shortest length. When all the remaining sticks are the same length, they cannot be shortened so discard them.
 * Given the lengths of  sticks, print the number of sticks that are left before each iteration until there are none left.
 *
 * sticks-length        length-of-cut   sticks-cut
 * 5 4 4 2 2 8             2               6
 * 3 2 2 _ _ 6             2               4
 * 1 _ _ _ _ 4             1               2
 * _ _ _ _ _ 3             3               1
 * _ _ _ _ _ _           DONE            DONE
 *
 *
 * sticks-length        length-of-cut   sticks-cut  remainingSticks     result  min
 *  5 4 4 2 2 8             2               6           6               6       2
 *  3 2 2 _ _ 6             2               4           4               6,4     2
 *  1 _ _ _ _ 4             1               2           2
 *  _ _ _ _ _ 3             3               1
 *  _ _ _ _ _ _           DONE            DONE
 *
 *
 *
 */
public class CutTheSticks {
    /*
     * Complete the 'cutTheSticks' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> cutTheSticks(List<Integer> arr) {
        List<Integer> result = new ArrayList<>();

        int remainingSticks = arr.size();
        while (remainingSticks > 0) {
            result.add(remainingSticks);
            int cutLength = arr.stream().min(Comparator.naturalOrder()).get();

            /*for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) == cutLength) {
                    arr.remove(i);
                    i--;
                    remainingSticks--;
                } else {
                    arr.set(i, arr.get(i) - cutLength);
                }
            }*/

            arr = arr.stream()
                    .filter(integer -> integer > cutLength)
                    .map(integer -> integer - cutLength)
                    .collect(Collectors.toList());
            remainingSticks = arr.size();
        }
        return result;
    }

    public static void main (String... args) {
       List<Integer> sticks = Stream.of(5,4,4,2,2,8).collect(Collectors.toList());
       List result = cutTheSticks(sticks);
       result.forEach(System.out::println);
    }
}
