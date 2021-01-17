package hackerrank;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Rahul
 * @createdate 1/10/2021
 */
public class SequenceEquation {
    static int i=0;
    static int getNextIndex() {
        i++;
        return i;
    }

    static int[] permutationEquation(int[] p) {

        HashMap<Integer,Integer> posLookup = new HashMap<>();
        List<Integer> res = new ArrayList<>(p.length);
        for (int i=1; i<=p.length; i++) {
            posLookup.put(p[i-1], i);
        }

        for (int i=1; i<=p.length; i++) {
            int yPos = posLookup.get(posLookup.get(i));
            res.add(yPos);
        }

        return res.stream()
                .mapToInt(value -> value)
                .toArray();
    }

    public static void main (String... args) {
        int[] p = {5,2,1,3,4};
        //  y[] = {4,2,5,1,3}
        int[] res = permutationEquation(p);
        for (int re : res) {
            System.out.println(re);
        }

    }
}
