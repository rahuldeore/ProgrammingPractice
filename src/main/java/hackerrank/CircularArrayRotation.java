package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Rahul on 12/29/20
 */
public class CircularArrayRotation {
    /**
     * John Watson knows of an operation called a right circular rotation on an array of integers. One rotation operation
     * moves the last array element to the first position and shifts all remaining elements right one. To test Sherlock's
     * abilities, Watson provides Sherlock with an array of integers. Sherlock is to perform the rotation operation a
     * number of times then determine the value of the element at a given position.
     *
     * For each array, perform a number of right circular rotations and return the values of the elements at the given indices.
     *
     * a=[3,4,5]    - original list
     * k=2          - number of shifts
     * queries=[1,2]- indices for elements to return
     *
     * return the values from the zero-based indices 1 and 2 as indicated in the queries array.
     *
     * k=4
     * [1,2,3,4,5,6,7,8,9]
     * [6,7,8,9,1,2,3,4,5]
     * old position: 0
     * new position: 4
     * */


    /**
     * Too primitive and slow solution. Tke too much time
     * */
    static int[] circularArrayRotation(int[] a, int k, int[] queries) {

        int aCount = (int) Arrays.stream(a).boxed().count();

        // this preserves the original index positions of elements in List
        List<Integer> aList = Arrays.stream(a).boxed().collect(Collectors.toList());

        if (aCount == k) {
            // no need of rotation
        } else {

            for (int steps=0; steps<k; steps++) {
                List<Integer> aListShifted = new ArrayList<>();
                //Add last element to beginning of new list
                aListShifted.add(aList.get(aList.size()-1));
                for(int i=0; i<aList.size()-1; i++) {
                    aListShifted.add(aList.get(i));
                }
                aList = aListShifted;
            }
        }

        List<Integer> finalAList = aList;

        return Arrays.stream(queries)
                .map(finalAList::get)
                .toArray();
    }

    /**
     * Optimized solution. One pass shift
     *
     * More optimized solution would be to unlink elements from length-k index and ling the first half to the end of
     * second half but that would need your own linked list implementation since java's node level linkedlist operations
     * are private
     * */
    static int[] circularArrayRotation2(int[] a, int k, int[] queries){

        LinkedList<Integer> aList = new LinkedList<>();

        aList.addAll(Arrays.stream(a)
                .boxed()
                .collect(Collectors.toList()));

        if(a.length == k) { // in case no shifting is required

        } else {
            for (int i = 0; i < k; i++) {
                Integer element = aList.getLast();
                aList.removeLast();
                aList.addFirst(element);
            }
        }

        return Arrays.stream(queries)
                .map(aList::get)
                .toArray();
    }

    public static void main (String... args) {
        /*int[] result = circularArrayRotation(new int[]{1,2,3,4,5,6,7,8,9}, 4, new int[]{1,2});
        // [6,7,8,9,1,2,3,4,5]
        Arrays.stream(result)
                .forEach(System.out::print);*/

        int[] res2 = circularArrayRotation2(new int[]{1,2,3,4,5,6,7,8,9,10}, 5, new int[]{0,9,2});
        System.out.println("---Answer---");
        Arrays.stream(res2)
                .forEach(System.out::println);

    }
}
