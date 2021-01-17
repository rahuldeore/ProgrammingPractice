package hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Rahul on 6/10/20
 *
 * GoldMan Sachs Online Phone Round 6/10/20
 */
public class SimpleHashMapUse {
    static Integer getBestScore(String[][] scores) {
        // Structure will have string key and value will be array list of 2 nos, count and total
        HashMap<String, List<Integer>> scoreTotals = new HashMap<>();
        Integer bestAverageScore = null;
        List<Integer> values = null;
        for (String[] oneScore : scores) {
            if (scoreTotals.containsKey(oneScore[0])) {
                values = scoreTotals.get(oneScore[0]);

                int counter = values.get(0) + 1;
                int total = values.get(1) + Integer.valueOf(oneScore[1]);
                values.removeAll(values);

                // increment the counter at position 0
                values.add(0, counter);

                // update the total score at position 1
                values.add(1, total);

                // calculate avg and update if the avg is highest
                int avg = total/counter;
                bestAverageScore = bestAverageScore != null ? (avg > bestAverageScore ? avg : bestAverageScore) : avg;
            } else {
                int score = Integer.valueOf(oneScore[1]);
                scoreTotals.put(oneScore[0], new LinkedList<>(Arrays.asList(1, score)));
                bestAverageScore = bestAverageScore != null ? (score > bestAverageScore ? score : bestAverageScore) : score;
            }
        }

        System.out.println("\nOutput: " + scoreTotals.entrySet() + "\n\tand Best Average Score: " + bestAverageScore);

        return bestAverageScore;
    }

    public static void main(String args[]){
        getBestScore(new String[][]{
                {"Bob","70"},
                {"Alice", "50"},
                {"Bobby", "100"},
                {"Alice", "90"},
                {"Pete", "75"}
        });

        getBestScore(new String[][] {
                //empty list
        });

        getBestScore(new String[][] {
                {"Bob", "10"},
                {"Bob", "10"},
                {"Bob", "10"},
                {"Bob", "10"},
                {"Bob", "10"},
                {"Bob", "10"},
                {"Bob", "10"}
        });

        getBestScore(new String[][] {
                {"Bob","-20"},
                {"Alice","-90"},
                {"Mark","-10"},
                {"Pete","-2000"},
                {"Bob","-50"}
        });
    }
}
