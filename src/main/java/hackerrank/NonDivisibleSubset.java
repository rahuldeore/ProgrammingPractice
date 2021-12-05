package hackerrank;

import java.util.*;

/**
 * Created by Rahul on 7/7/21
 * Difficulty - Medium
 *
 */
public class NonDivisibleSubset {

    /**
     * 1 + 7 = 8
     * 1 + 2 = 3
     * 1 + 4 = 5
     * 7 + 2 = 9
     * 7 + 4 = 11
     * 2 + 4 = 6
     * Only S'={1,7,4} will not ever sum to a multiple of k=3
     *
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */


    /*public static int nonDivisibleSubset(int k, List<Integer> s) {
        int maxSubsetLength = 0, result = 0;
        Integer num1=0, num2=0;
        HashMap<Integer, LinkedList<Integer>> subSets = new HashMap<>();
        for (int i=0; i< s.size(); i++) {
            num1 = s.get(i);
            LinkedList<Integer> subSet = new LinkedList<>();
            for (int j=i+1; j<s.size(); j++) {
                num2 = s.get(j);
                if ((num1 + num2) % k != 0) {
                    subSet.add(num2);
                }
            }
            if (subSet.size() > 0) {
                subSets.put(num1, subSet);
                //System.out.println(num1 + " -> " + subSets.get(num1));
            }

            if (subSet.size() > maxSubsetLength) {
                maxSubsetLength = subSet.size();
            }
        }

        for (int i=0; i<subSets.size(); i++) {
            LinkedList<Integer> subSet = subSets.get(s.get(i)); //top level sublist
            for (int j=0; j<subSet.size()-1; j++) { //top level sublist iterator
                Integer subListNum = subSet.get(j); // a number from top level sublist
                LinkedList<Integer> subList = subSets.get(subListNum); // that number's sublist
                for (k=j+1; k<subSet.size()-1; k++) { //top level sublist iterator 2
                    Integer subListNum2 = subSet.get(k);
                    if ( ! subList.contains(subListNum2)) {
                        subSet.remove(subListNum2);
                        k--;
                    }
                }
            }
            if (result < subSet.size() + 1) {
                result = subSet.size() + 1;
            }
            System.out.println(subSet);
        }

        return result;
    }*/

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int size = s.size();
        int result = size;

        HashMap<Integer, Integer> divisibleCounts = new HashMap<>(); // map of how many sums are divisible
        HashMap<Integer, HashSet<Integer>> nonDivisibles = new HashMap<>();
        HashSet<Integer> solutionSet = new HashSet<>();

        for(int i=0; i<size; i++) {
            Integer num1 = s.get(i);
            int divisibleCount = 0;
            HashSet<Integer> nonDivisible = new HashSet<>();
            for (int j=0; j<size; j++) {
                int num2 = s.get(j);
                if (num1 == num2) {
                    continue;
                }
                if ((num1 + num2) % k != 0) {
                    nonDivisible.add(num2);
                } else {
                    divisibleCount++;
                }
            }
            nonDivisibles.put(num1, nonDivisible);
            divisibleCounts.put(num1, divisibleCount);
        }

        nonDivisibles.forEach((key, value) -> solutionSet.addAll(value));

        System.out.println(solutionSet);

        /*for (int i=0, sSize = s.size(); i<sSize; i++) {
            Integer num1 = s.get(i);
            HashSet<Integer> num1NonDivisibles = nonDivisibles.get(num1);
            solutionSet.add(num1);
            for (int j=i+1; j<sSize; j++) {
                Integer num2 = s.get(j);
                if (num1 == num2) {
                    continue;
                }
                if (num1NonDivisibles.contains(num2)) {
                    solutionSet.add(num2);
                } else {
                    if (divisibleCounts.get(num1) > divisibleCounts.get(num2)) {
                        solutionSet.remove(num1); // remove num1 from solutionSet and ignore its comparison
                        s.remove(num1);
                        sSize--;
                        solutionSet.add(num2); // make sure num2 is in the solution set
                        break;
                    } else {
                        s.remove(num2);
                        sSize--;
                        continue; // do not add num2 to solutionSet since it has more divisibles. Num1 is already added
                    }
                }
            }
        }*/

        result = solutionSet.size();
        return result;
    }
    public static void main (String... args){

        int result = 0;
        //result = nonDivisibleSubset(3, Arrays.asList(1, 7, 2, 4));
        //System.out.println("result = "+result);

        /*result = nonDivisibleSubset(7, Arrays.asList(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718,771,
                575, 436));
        System.out.println("result = "+result);*/


        result = nonDivisibleSubset(7, new ArrayList<>(Arrays.asList(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771,
                575, 436)));
        System.out.println("result = "+result);

        /*result = nonDivisibleSubset(9, new ArrayList<>(Arrays.asList(61197933,56459859,319018589,271720536,358582070,
                849720202,481165658,675266245,541667092,615618805,129027583,755570852,437001718,86763458,791564527,
                163795318,981341013,516958303,592324531,611671866,157795445,718701842,773810960,72800260,281252802,
                404319361,757224413,682600363,606641861,986674925,176725535,256166138,827035972,124896145,37969090,
                136814243,274957936,980688849,293456190,141209943,346065260,550594766,132159011,491368651,3772767,
                131852400,633124868,148168785,339205816,705527969,551343090,824338597,241776176,286091680,919941899,
                728704934,37548669,513249437,888944501,239457900,977532594,140391002,260004333,911069927,586821751,
                113740158,370372870,97014913,28011421,489017248,492953261,73530695,27277034,570013262,81306939,519086053,
                993680429,599609256,639477062,677313848,950497430,672417749,266140123,601572332,273157042,777834449,
                123586826)));
        System.out.println("result = "+result); // Expected output is 50*/





    }
}
