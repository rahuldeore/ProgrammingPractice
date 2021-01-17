/**
 * Created by Rahul on 1/24/20
 */

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Supplier;

class Parent {
    protected static int data = 10;
}

public class Solution extends Parent{
    public Solution() {
        data++;
    }

    //int data = 5;
    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> points = new ArrayList<>(2);
        int a1=0, b1=0;
        for (int i=0; i<a.size(); i++) {
            if (a.get(i) < b.get(i)) {
                b1++;
            } else if(a.get(i) > b.get(i)) {
                a1++;
            }
        }
        points.add(a1);
        points.add(b1);
        return points;
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int d1sum=0, d2sum=0;
        int d2Index=arr.size()-1;
        int d1Index = 0;

        /*Iterator<List<Integer>> itr1 = arr.iterator();
        while (itr1.hasNext()) {
            List<Integer> list2 = itr1.next();
            d1sum += list2.get(d1Index);
            d2sum += list2.get(d2Index);
            d1Index++;
            d2Index--;
        }*/

        for (List<Integer> list : arr){
            d1sum += list.get(d1Index);
            d2sum += list.get(d2Index);
            d1Index++;
            d2Index--;
        }
        return Math.abs(d1sum - d2sum);
    }

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets2(List<Integer> a, List<Integer> b) {
        List<Integer> points = new ArrayList<>(2);
        points.add(0);
        points.add(0);

        Iterator<Integer> a1 = a.iterator();
        Iterator<Integer> b1 = b.iterator();

        while (a1.hasNext() && b1.hasNext()) {
            if (a1.next() > b1.next()) {
                points.set(0, points.get(0) + 1);
            } else if (a1.next() < b1.next()) {
                points.set(1, points.get(1) + 1);
            }
        }
        return points;
    }


    static void plusMinus(int[] arr) {
        int length = arr.length;
        int pos=0, neg=0, neutral=0;
        for (int elem : arr) {
            if (elem > 0) {
                pos++;
            } else if (elem < 0) {
                neg++;
            } else {
                neutral++;
            }
        }
        System.out.println(String.format("%.4f", (float) pos/length) + "\n" + String.format("%.4f", (float)neg/length) + "\n"
                + String.format("%.4f",(float)neutral/length));
    }

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        int min=arr[0], max=arr[0], sum=0;
        for (int i=0; i<arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
            if (max < arr[i]) {
                max = arr[i];
            }
            sum += arr[i];
        }
        System.out.println((sum-max) + " " + (sum-min));
    }

    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] ar) {
        int max=ar[0];
        Map<Integer, Integer> candleCount = new HashMap<>();
        for (int i=0; i < ar.length; i++) {
            if (candleCount.containsKey(ar[i])) {
                candleCount.replace(ar[i], candleCount.get(ar[i]) + 1);
            } else {
                candleCount.put(ar[i],1);
            }
            if (max < ar[i]) {
                max=ar[i];
            }
        }
        return candleCount.get(max);
    }

    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles2(int[] ar) {
        int max=ar[0], maxCount=0;

        for (int i=0; i < ar.length; i++) {
            if (max < ar[i]) {
                max = ar[i];
                maxCount = 1;
            }
            else if (max == ar[i]) {
                maxCount++;
            }
        }
        return maxCount;
    }


    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ssa");
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(s);
        } catch (Exception e) {

        }
        return sdf2.format(date);
    }

    Supplier<Integer> incrementer(int start) {
        return () -> start+1; // start++ will not work as the variable is effectively final
    }


    /**
     * This function takes two double numbers and an arithmetic operation function, applies it to the parameters
     * and returns the result
     * */
    Double operate (Double a, Double b, BiFunction<Double, Double, Double> operation) {
        return operation.apply(a, b);
    }


    private <X> X processOperation (X x, X y, BiFunction<X, X, X> operator) {
        return operator.apply(x, y);
    }

    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int aCount = 0, oCount = 0;
        for (int pos : apples) {
            aCount = pos + a >= s ? (aCount + 1) : aCount;
        }
        for (int pos : oranges) {
            oCount = pos + b <= t ? oCount + 1 : oCount;
        }
        System.out.println(aCount);
        System.out.println(oCount);
    }

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        //The below code gives concurrent modification exception if I use list.remove method. Using set method instead.

        grades.forEach(grade -> {
            if (grade >= 38 ) {
                if (grade % 5 >= 3) {
                    int newGrade = grade + (5 - (grade % 5));
                    int index = grades.indexOf(grade);
                    grades.set(index, newGrade);
                }
            }
        });
        return grades;
    }

    static int[] breakingRecords(int[] scores) {
        int maxScore=scores[0], minScore=scores[0];
        int maxScoreBrokeCounter=0, minScoreBrokeCounter=0;
        for (int i=1; i<scores.length; i++) {
            if (maxScore < scores[i]) {
                maxScore = scores[i];
                maxScoreBrokeCounter++;
            } else if(minScore > scores[i]){
                minScore = scores[i];
                minScoreBrokeCounter++;
            }
        }
        int res[] = {maxScoreBrokeCounter, minScoreBrokeCounter};
        return res;
    }


    static int birthday(List<Integer> s, int d, int m) {
        int ways = 0;
        int daySum = 0;
        for (int i=0; i<s.size()-1; i++) {
            daySum = 0;
            for (int j=0; j<m; j++) {
                daySum += s.get(i+j);
            }
            ways = daySum == d ? ways++ : ways;
        }
        return ways;
    }

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> birds = new HashMap<>();
        arr.forEach(birdId -> {
            if(birds.containsKey(birdId)) {
                birds.replace(birdId, birds.get(birdId) + 1);
            }
            else {
                birds.put(birdId, 1);
            }
        });
        Map.Entry<Integer, Integer> mostCommonBirdKey = null;
        for (Map.Entry<Integer, Integer> bird : birds.entrySet()) {
            if (mostCommonBirdKey == null || bird.getValue() > mostCommonBirdKey.getValue()) {
                mostCommonBirdKey = bird;
            }
        }
        return mostCommonBirdKey.getKey();
    }

    // Complete the bonAppetit function below.
    static void bonAppetit(List<Integer> bill, int k, int b) {
        Integer total = 0;
        for (Integer itemPrice : bill) {
            total += itemPrice;
        }
        if(total/2 == b) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(bill.get(k)/2);
        }
    }

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        Integer numOfPairs = 0;
        Map<Integer,Integer> socks = new HashMap<Integer,Integer>();

        for (int i=0; i<n; i++) {
            if (socks.containsKey(ar[i])){
                int sockCount = socks.get(ar[i]) + 1;
                socks.replace(ar[i],sockCount);
                numOfPairs = sockCount % 2 == 0 ? numOfPairs + 1 : numOfPairs;
            } else {
                socks.put(ar[i], 1);
            }
        }
        return numOfPairs;
    }

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        if (p == 1 || p == n) {
            return 0;
        }
        else {
            if (p < n - p) {
                return p / 2;
            } else if ((n - p) == 1) {
                return 1;
            } else {
                return (n-p) / 2;
            }
        }
    }

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int valleyCount=0, stepCounter=0;
        String step = null;
        for (int i=0; i<n; i++) {
            step = String.valueOf(s.charAt(i));
            if (step.equalsIgnoreCase("D")) {
                stepCounter--;
                if (stepCounter == -1) {
                    valleyCount++;
                }
            } else {
                stepCounter++;
            }
        }
        return valleyCount;
    }

    /*
     * Complete the getMoneySpent function below. TODO: Improve the runtime from n2 to better
     */
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /*
         * Write your code here.
         */
        int maxSpendableAmount = -1;

        for (int i=0; i<keyboards.length; i++) {
            for (int j=0; j<drives.length; j++) {
                int dealAmt = keyboards[i] + drives[j];
                if (dealAmt <= b && dealAmt > maxSpendableAmount) {
                    maxSpendableAmount = dealAmt;
                }
            }
        }
        System.out.println(maxSpendableAmount);
        return maxSpendableAmount;
    }
    /** TODO: this is not working. Fix this
     * Complete the formingMagicSquare function below. This function does not build magic square from empty 2d array,
     * but just calculate the cost to ensure 3x3 magic square property will be met after replacing elements.
     * The magic square property states that each row, column, and diagonal sums up to on number, the magic constant.
     * In case of 3x3 square, the magic constant is 15.
     */
    static int formingMagicSquare(int[][] s) {
        List<Integer> corners = new ArrayList<>(Arrays.asList(2,4,6,8));
        int cost = 0;
        // Check and replace the center with 5
        if (s[1][1] != 5) {
            cost = Math.abs(s[1][1] - 5);
            s[1][1] = 5;
        }
        int i=0, j=0;
        while (!corners.isEmpty()) {
            if (corners.contains(s[i][j])) {
                if (i==2 && j==0 && s[i][j] + s[j][i] != 10) {
                    Integer skipElement = s[i][j];
                    int optimumElement = getOptimumReplacement(s[i][j], corners, skipElement);
                    cost += Math.abs(s[i][j]-optimumElement);
                    corners.remove(Integer.valueOf(optimumElement));
                    s[i][j] = optimumElement;
                } else {
                    corners.remove(Integer.valueOf(s[i][j]));
                }
            } else {
                Integer skipElement = null;
                int optimumElement = getOptimumReplacement(s[i][j], corners, null);
                cost += Math.abs(s[i][j]-optimumElement);
                corners.remove(Integer.valueOf(optimumElement));
                s[i][j] = optimumElement;
            }
            if (i==2 && j==0) {
                i=2; j=2;
            }
            if (i==0 && j==2) {
                i=2; j=0;
            }
            if (i==0 && j==0) {
                i=0; j=2;
            }
        }
        /*
        //check corners
        if(corners.contains(s[0][0])) {
            corners.remove(Integer.valueOf(s[0][0]));
        } else {
            int optimumElement = getOptimumReplacement(s[0][0], corners);
            cost += Math.abs(s[0][0]-optimumElement);
            corners.remove(Integer.valueOf(optimumElement));
            s[0][0] = optimumElement;
        }
        if (corners.contains(s[0][2])) {
            corners.remove(Integer.valueOf(s[0][2]));
        } else {
            int optimumElement = getOptimumReplacement(s[0][2], corners);
            cost += Math.abs(s[0][2]-optimumElement);
            corners.remove(Integer.valueOf(optimumElement));
            s[0][2] = optimumElement;
        }
        if (corners.contains(s[2][0])) {
            //check if its the right position as well
            if (s[0][2] + s[2][0] == 10) {
                corners.remove(Integer.valueOf(s[2][0]));
            } else {
                int optimumElement = getOptimumReplacement(s[2][0], corners);
                cost += Math.abs(s[2][0]-optimumElement);
                corners.remove(Integer.valueOf(optimumElement));
                s[2][0] = optimumElement;
            }
        } else {
            int optimumElement = getOptimumReplacement(s[2][0], corners);
            cost += Math.abs(s[2][0]-optimumElement);
            corners.remove(Integer.valueOf(optimumElement));
            s[2][0] = optimumElement;
        }
        if (corners.contains(s[2][2])) {
            corners.remove(Integer.valueOf(s[2][2]));
        } else {
            int optimumElement = getOptimumReplacement(s[2][2], corners);
            cost += Math.abs(s[2][2]-optimumElement);
            corners.remove(Integer.valueOf(optimumElement));
            s[2][2] = optimumElement;
        }*/

        // Make sure opposite corner elements sum up to 10
        if (s[0][0] + s[2][2] != 10) {
            int temp = s[0][0];
            s[0][0] = s[0][2];
            s[0][2] = temp;
        }
        if (s[0][0] + s[2][2] != 10) {
            int temp = s[0][0];
            s[0][0] = s[2][0];
            s[2][0] = temp;
        }

        int centerElement=0;
        // check sum 15 property
        centerElement = 15 - (s[0][0] + s[0][2]);
        if (centerElement != s[0][1]) {
            cost += Math.abs(centerElement - s[0][1]);
            s[0][1] = centerElement;
        }

        centerElement = 15 - (s[0][2] + s[2][2]);
        if (centerElement != s[1][2]) {
            cost += Math.abs(centerElement - s[1][2]);
            s[1][2] = centerElement;
        }

        centerElement = 15 - (s[2][2] + s[2][0]);
        if (centerElement != s[2][1]) {
            cost += Math.abs(centerElement - s[2][1]);
            s[2][1] = centerElement;
        }

        centerElement = 15 - (s[2][0] + s[0][0]);
        if (centerElement != s[1][0]) {
            cost += Math.abs(centerElement - s[1][0]);
            s[1][0] = centerElement;
        }

        return cost;
    }

    static int getOptimumReplacement(int element, List<Integer> corners, Integer skipElement){
        int cost = Integer.MAX_VALUE, replacement = 0;
        for (int e : corners){
            if (skipElement != null && e == skipElement){
                continue;
            } else{
                if (Math.abs(e - element) < cost) {
                    replacement = e;
                    cost = Math.abs(e - element);
                }
            }
        }
        return replacement;
    }

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        TreeMap<Integer, Integer> sortedArray = new TreeMap<>(Comparator.naturalOrder());
        a.forEach(key -> {
            Integer value = sortedArray.get(key);
            if (value != null) {
                sortedArray.replace(key, value+1);
            } else {
                sortedArray.put(key, 1);
            }
        });

        sortedArray.forEach((key,val) -> {
            System.out.println("Key: " + key.intValue() + "Value: " +val.intValue());
        });

        Integer prevKey = null, prevVal = null;

        Integer subArrElemCount = 0, arrLength = sortedArray.size();
        Iterator<Map.Entry<Integer, Integer>> sortedArrayIterator =  sortedArray.entrySet().iterator();
        while (sortedArrayIterator.hasNext()) {
            Map.Entry<Integer,Integer> element = sortedArrayIterator.next();
            Integer key = element.getKey(), val = element.getValue();

            if (subArrElemCount < val) {
                subArrElemCount = val;
            }
            if (prevKey != null && key-prevKey == 1) {
                if (prevVal + val > subArrElemCount) {
                    subArrElemCount = prevVal + val;
                }
            }
            prevKey = key;
            prevVal = val;
        }
        return subArrElemCount.intValue();
    }

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard2(int[] scores, int[] alice) {
        int[] ranking = new int[alice.length];
        int rankingIndex = 0;

        for (int aliceScore : alice) {
            boolean insertLast = true;
            int prevScore = -1, aliceRank = 0;
            for (int i=0; i<scores.length; i++) {
                if (prevScore != scores[i]) {
                    prevScore = scores[i];
                    aliceRank++;
                    if (aliceScore >= scores[i]) {
                        insertLast=false;
                        break;
                    }
                }
            }
            if (insertLast) {
                ranking[rankingIndex] = aliceRank + 1;
                rankingIndex++;
            } else {
                ranking[rankingIndex] = aliceRank;
                rankingIndex++;
            }
        }
        return ranking;
    }

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard1(int[] scores, int[] alice) {
        Map<Integer, Integer> scoreBoard = new TreeMap<>(Comparator.naturalOrder());
        SortedSet<Integer> sb = new TreeSet<>(Comparator.naturalOrder());

        int rank = 1;
        int[] ranking = new int[alice.length];
        int index = 0;
        for (int score : scores) {
            if ( !scoreBoard.containsKey(score)) {
                scoreBoard.put(score, rank);
                rank++;
            }
        }
        for (int aliceScore : alice) {
            if (scoreBoard.containsKey(aliceScore)) {
                ranking[index] = scoreBoard.get(aliceScore);
                index++;
            }
            //if (scoreBoard.)
        }
        return null;
    }

    // Complete the climbingLeaderboard function below. Binary search technique TODO not working
    static int[] climbingLeaderboard3(int[] scores, int[] alice) {
        Object[] scoreBoard = null;
        int rank[] = new int[alice.length];
        if (true){
            SortedSet<Integer> uniqueScores = new TreeSet<>(Comparator.reverseOrder());
            for (int score : scores) {
                if ( !uniqueScores.contains(score)) {
                    uniqueScores.add(score);
                }
            }
            scoreBoard = uniqueScores.toArray();
        }

        int[] newScores = new int[scoreBoard.length];
        for(int i=0; i<scoreBoard.length; i++){
            newScores[i] = (int) scoreBoard[i];
        }
        Arrays.sort(newScores);

        if (scoreBoard != null) {
            int index=0;
            for (int aliceScore : alice) {
                rank[index] = Arrays.binarySearch(newScores,aliceScore);
                System.out.println(rank[index]);
                index++;
            }
        }
        return rank;
    }

    static int[] climbingLeaderboard(int[] scores, int[] alice){
        // setup the ranks array with rank of each score in the scores array. Use it for quick lookup of rank since
        // game uses dense ranking, we will have repeating scores and repeating ranks.

        ArrayList<Integer> aliceRanks = new ArrayList<>(alice.length);
        int[] scoreRanks = new int[scores.length];
        Integer rank = 1, prev = scores[0];
        scoreRanks[0] = 1;
        for (int i=1; i<scores.length; i++) {
            if(scores[i] == prev) {
                scoreRanks[i] = rank;
            } else if (scores[i] < prev) {
                prev = scores[i];
                rank++;
                scoreRanks[i] = rank;
            }
        }
        for (int r: scoreRanks){
            System.out.print(r);
        }
        System.out.println();
        int low = 0, high = scores.length-1, mid=0, index=0;
        for (int j=0; j<alice.length; j++) {

            index = binaryFindScorePosition(scores, alice[j]);
            //rank = index > scoreRanks.length-1 ? scoreRanks[scoreRanks.length-1] + 1 : index < 0 ?  1 : scoreRanks[index];
            if (index > scoreRanks.length-1) {
                rank = scoreRanks[scoreRanks.length-1] + 1;
            } else if (index < 0) {
                rank = 1;
            } else {
                rank = scoreRanks[index];
            }
            aliceRanks.add(rank);
        }
        int ans[] = new int[aliceRanks.size()];
        for (int i=0; i<aliceRanks.size(); i++) {
            ans[i] = aliceRanks.get(i);
        }
        return ans;
    }

    static int binaryFindScorePosition(int[] scores, int aliceScore) {
        int low=0, high = scores.length-1, mid= (int) Math.ceil((low+high)/2.0d);
        while (low < high) {
            if (scores[mid] == aliceScore) {
                return mid;
            }
            if (aliceScore < scores[mid]) {
                low = mid+1;
                mid = (int) Math.ceil((low+high) / 2.0d);
            } else {
                high = mid-1;
                mid = (int) Math.ceil((low+high) / 2.0d);
            }
        }
        if (low == high) {
            if (aliceScore == scores[mid]) {
                return mid;
            } else if (aliceScore < scores[mid]) {
                return mid + 1;
            } else {
                return mid;
            }
        }
        return mid;
    }

    // Binary Search Working Code
    public static int binarySearch(int[] arr, int elem) {
        int low = 0, high = arr.length, mid = 0;
        while (low != high) {
            mid = (int) Math.ceil((low + high) / 2.0);
            if (elem < arr[mid]) {
                low = mid + 1;
            } else if (elem > arr[mid]) {
                high = mid - 1;
            } else if (elem == arr[mid]) {
                return mid;
            }
        }
        return -1;
    }


    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {

        int maxHeight = 0, wordLength = word.length();
        for (int i=0; i<wordLength; i++) {
            if (h[(Integer.valueOf(word.charAt(i))-97)] > maxHeight ) {
                maxHeight = h[Integer.valueOf(word.charAt(i))-97];
            }
        }
        return wordLength * maxHeight;
    }

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {

        int totalBeautifulDays = 0;

        for (int day = i; day <= j; day++) {
            int num = day;
            int revNum = getReverseNum(day);
            if (Math.abs(num-revNum) % k == 0) {
                totalBeautifulDays ++;
            }
        }
        return totalBeautifulDays;
    }
    static int getReverseNum(int num) {
        String number = "" + num;
        String revNumber = "";
        for (char c : number.toCharArray()) {
            revNumber = c + revNumber;
        }
        return Integer.valueOf(revNumber);
    }


    public static int diagonalDifference2(List<List<Integer>> arr) {
        int diag1Sum=0, diag2Sum=0;
        for (int i=0; i<arr.size(); i++) {
            diag1Sum += arr.get(i).get(i);
            int size = arr.get(i).size()-1;
            diag2Sum += arr.get(i).get(size-i);
        }
        return Math.abs(diag1Sum-diag2Sum);
    }


    public static void main(String[] args) throws IOException {
        List<Integer> a = new ArrayList<>(3);
        a.add(17);
        a.add(28);
        a.add(30);

        List<Integer> b = new ArrayList<>(3);
        b.add(99);
        b.add(16);
        b.add(18);

        List<Integer> result = compareTriplets(a, b);
        Iterator<Integer> iterator = result.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }

        List<List<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>());
        arr.add(new ArrayList<>());
        arr.add(new ArrayList<>());
        for (List<Integer> list : arr) {
            list.add(1);
            list.add(2);
            list.add(3);
        }
        System.out.println("\nDiagonal Diff: " + diagonalDifference(arr));

        int arr2[] = {1, 1, 0, -1, -1};

        plusMinus(arr2);
        System.out.println("Time formatted to 24hr: " + timeConversion("06:22:12PM"));

        List<Integer> chocolate = Arrays.asList(1,1,1,1,1,1);
        System.out.println(birthday(chocolate, 3, 2));
        chocolate = Arrays.asList(1,2,1,3,2);
        System.out.println(birthday(chocolate, 3, 2));
        chocolate = Arrays.asList(4);
        System.out.println(birthday(chocolate, 4, 1));

        List<Integer> array = Arrays.asList(1, 2, 2, 3, 1, 2);
        //System.out.println("Picking Numbers: " + pickingNumbers(array));

        int ranking[] = climbingLeaderboard(new int[] {100, 100, 50, 40, 40, 20, 10}, new int[] {5,25,50,120});
        for (int rank : ranking) {
            System.out.print(rank);
        }

        System.out.println();
        ranking = climbingLeaderboard(new int[]{100,90,90,80,75,60}, new int[]{50,65,77,90,102});
        for (int rank : ranking) {
            System.out.print(rank);
        }

        System.out.println();
        ranking = climbingLeaderboard(new int[] {99898857, 99889660, 99869152, 99837681, 99736538, 99703188, 99673092, 99438723, 99188873, 99182024, 98941219, 98847091, 98834424, 98552564, 98476874, 98398348, 98383509, 98265264, 98219491, 98191077, 98165233, 97983638, 97981128, 97789951, 97774327, 97754636, 97636469, 97569914, 97540158, 97504843, 97398178, 97148541, 96820968, 96759214, 96380773, 96371061, 96364322, 96289197, 96165809, 96139504, 96134779, 96082233, 96017200, 95906550, 95757436, 95540407, 95534204, 95388550, 95337193, 95235067, 95160090, 95087785, 95065060, 95024100, 94965051, 94845473, 94782986, 94768896, 94242274, 94191731, 94172664, 94163364, 94089720, 93955021, 93774815, 93718265, 93624880, 93556432, 93527673, 93518041, 93486743, 93383140, 93329526, 93261889, 93243864, 93239358, 93132132, 93073213, 92871536, 92735907, 92359924, 92187449, 92185209, 92022763, 91984664, 91911126, 91768343, 91580168, 91006030, 90966775, 90918276, 90865305, 90782670, 90764511, 90588136, 90567346, 90550011, 90539504, 90366610, 90247430, 90163683, 90039364, 89964884, 89770309, 89648081, 89632081, 89394413, 89215653, 89200873, 89043099, 89020791, 88899309, 88765616, 88681806, 88681734, 88664086, 88636769, 88458223, 88320571, 88310928, 88200336, 88147259, 88111168, 88060354, 88051598, 88003109, 87851868, 87680720, 87632498, 87484779, 87463793, 87413592, 87390682, 87347096, 87198915, 87084884, 86981448, 86877227, 86837432, 86730928, 86665202, 86558222, 86479589, 86437161, 86368585, 86313016, 85936421, 85852296, 85758025, 85753484, 85501928, 85383427, 85328683, 85297887, 85277577, 85275044, 84714041, 84644948, 84573185, 84484722, 84483293, 84470839, 84468342, 84445590, 84408964, 84375901, 84351273, 84319931, 84296547, 84250753, 84165132, 84164342, 84156204, 83832482, 83644580, 83494421, 83266972, 83229813, 83153066, 83068491, 82958792, 82529712, 82203357, 81718051, 81642632, 81581680, 81342609, 81294777, 81235055, 81172242, 81106960, 81042054, 81038341, 80883974, 80883864, 80375157, 80205800, 80096537, 80073936, 79989028, 79833146, 79756091, 79591100, 79525698, 79462246, 79392928, 79376281, 79349218, 79346940, 79345242, 79230696, 79102264, 79092058, 79081507, 79029153, 78662939, 78236803, 78213437, 78002023, 78001933, 77899885, 77755112, 77647274, 77531772, 77427863, 77390200, 77380433, 77026911, 77026739, 76992735, 76992529, 76807965, 76803173, 76781571, 76606476, 76500650, 76437794, 76319750, 76298752, 76084721, 75955818, 75934545, 75876716, 75856659, 75836962, 75833423, 75445682, 75289722, 75213851, 75191474, 75147090, 75009094, 74860476, 74854476, 74762611, 74660586, 74651120, 74497163, 74480821, 74416106, 74373610, 74324213, 74211291, 73781823, 73707013, 73701614, 73672565, 73497954, 73441533, 73036167, 72892708, 72889205, 72585585, 72416845, 72303349, 72160943, 72137913, 72119300, 72078349, 72003299, 71941300, 71892836, 71773532, 71632435, 71521276, 71468615, 71466067, 71300432, 71245146, 71081443, 71009621, 70903214, 70776786, 70481661, 70450989, 70442023, 70335193, 70090900, 69985196, 69963203, 69892252, 69704000, 69501776, 69241044, 69132626, 68949851, 68909586, 68901758, 68804733, 68438409, 68403415, 68388574, 68256706, 68233843, 68226727, 68220953, 67718956, 67626779, 67570376, 67476832, 67156487, 67001481, 66950206, 66920900, 66886650, 66879732, 66870911, 66827552, 66699689, 66551294, 66460650, 66415752, 66321790, 66199025, 66130142, 66001792, 65953283, 65759440, 65674431, 65651956, 65612680, 65599660, 65502905, 65395015, 65162561, 65041922, 64897146, 64735975, 64682717, 64537284, 64534498, 64372715, 64331812, 64175174, 64119892, 64036775, 64010388, 63865508, 63765666, 63718626, 63683869, 63670239, 63452595, 63436897, 63278564, 63277712, 63231578, 63158765, 63088408, 63087647, 63080228, 63005208, 62799030, 62756701, 62752183, 62723523, 62637979, 62396913, 62369503, 62311464, 62280897, 62226940, 61942802, 61872377, 61744815, 61725861, 61662046, 61649427, 61374721, 61372786, 61331183, 61285249, 61270463, 61219483, 61030892, 60965760, 60891206, 60880319, 60863105, 60785546, 60775227, 60653226, 60633286, 60618406, 60353657, 60319274, 60279733, 60264283, 60244877, 60051391, 60034420, 60030599, 59976268, 59941980, 59880911, 59843278, 59787484, 59294838, 59268369, 59060033, 59017480, 58809472, 58616767, 58576790, 58480947, 58206350, 58152517, 57845227, 57799037, 57655592, 57574446, 57461776, 57434424, 57399296, 57388801, 57280876, 57240423, 57196939, 57142288, 57073375, 56995908, 56972421, 56871618, 56513308, 56330312, 56319998, 56229962, 56147438, 56060795, 56014663, 55959180, 55950667, 55721071, 55591040, 55481516, 55465161, 55048486, 55035572, 54952449, 54907503, 54859595, 54548336, 54425407, 54295971, 54020757, 53985644, 53853693, 53654945, 53627873, 53591381, 53525017, 53324983, 53314801, 53297759, 53126919, 53084439, 52954242, 52753107, 52702526, 52523162, 52491052, 52371959, 52322642, 52299154, 52287256, 52152546, 51911108, 51790588, 51787078, 51777437, 51616679, 51615899, 51394126, 51283786, 50936551, 50935981, 50723219, 50587608, 50484287, 50136625, 49905408, 49769792, 49736839, 49496028, 49409832, 49338817, 49147982, 49123195, 49119855, 48904647, 48881538, 48816993, 48768770, 48700767, 48582310, 48571821, 48562828, 48458819, 48410758, 48355213, 47962443, 47728081, 47561353, 47553337, 47472760, 47467255, 47330165, 47295473, 47205907, 47078215, 46886548, 46434898, 46307185, 46239450, 46234631, 46130801, 45983571, 45621141, 45593352, 45544991, 45519872, 45420697, 45389780, 44971870, 44865643, 44832851, 44686680, 44595790, 44471953, 44379467, 44346004, 44243889, 44039168, 43965328, 43883130, 43759219, 43533771, 43481124, 43393242, 43348155, 43240650, 43231410, 43217430, 43083861, 42928063, 42877645, 42782297, 42486326, 42459573, 42410022, 42402617, 42389710, 42290611, 42217530, 42115142, 42036628, 41964111, 41944473, 41857932, 41570274, 41514515, 41501660, 41482470, 41299344, 41281531, 41237553, 41057608, 40853643, 40838474, 40788611, 40464280, 40435960, 40367825, 40235705, 39944724, 39821191, 39758387, 39733157, 39712574, 39621355, 39466346, 39423527, 39411840, 39269151, 39169534, 39157478, 38923832, 38850265, 38815594, 38656097, 38575653, 38430509, 38318919, 38233525, 38012448, 37864075, 37808894, 37749704, 37672921, 37658556, 37634077, 37614934, 37475138, 37389307, 37346787, 37238991, 37233004, 37227673, 37157726, 37132959, 37131336, 36951768, 36746439, 36618354, 36565937, 36515932, 36494798, 36088099, 35973514, 35940782, 35872411, 35855416, 35677252, 35587597, 35576546, 35033889, 35022404, 34914914, 34804545, 34582879, 34501579, 34478060, 34246493, 34236026, 34136600, 34095909, 33873149, 33851288, 33840443, 33651721, 33616225, 33486324, 33409108, 33371160, 33081859, 33026057, 33019125, 32957948, 32776462, 32672287, 32647271, 32620090, 32597483, 32564531, 32559706, 32525711, 32256339, 32222258, 32183771, 32178557, 32151507, 31541478, 31500641, 31383209, 31296990, 31221308, 31129807, 30894716, 30880372, 30814823, 30624157, 30538757, 30201893, 29889150, 29883393, 29840852, 29831711, 29752592, 29688606, 29633121, 29456864, 29406441, 29307117, 29183024, 29085993, 28970471, 28710917, 28562054, 28534876, 28421090, 28360002, 28345962, 28291238, 28287305, 28273053, 28206329, 28141374, 27790473, 27728924, 27560382, 27502928, 27493362, 27432892, 27428865, 27407130, 27381053, 27239902, 27165414, 27016781, 26968193, 26953106, 26544750, 26515061, 26464181, 26437273, 26045559, 25994868, 25883050, 25866525, 25843732, 25646508, 25643866, 25622009, 25451541, 25433144, 25093795, 25060964, 24900394, 24824269, 24652066, 24627100, 24505252, 24467041, 24327220, 24284080, 24268364, 24245022, 24184127, 24165262, 24097674, 24094525, 24027993, 24023578, 24019400, 23869765, 23704694, 23632244, 23452624, 23373000, 23152366, 23100343, 23013666, 22882819, 22820548, 22819120, 22812759, 22644278, 22637065, 22438481, 22347122, 22314017, 22275894, 22271876, 22239077, 22135838, 21928432, 21867816, 21731527, 21615197, 21571005, 21548136, 21153248, 21138892, 20953111, 20943846, 20913526, 20911737, 20820781, 20779829, 20765805, 20677838, 20498116, 20227184, 19951249, 19795707, 19635324, 19576223, 19475704, 19457546, 19401964, 19347489, 19320004, 19299890, 19283479, 19243393, 19200019, 19175472, 19016178, 18960046, 18901876, 18887114, 18836976, 18801779, 18636309, 18570974, 18208201, 18164084, 17795609, 17460119, 17390455, 17161179, 16835265, 16718182, 16632317, 16613652, 16384221, 16381153, 16229361, 16169721, 16050119, 16022852, 16021832, 15785833, 15660755, 15588145, 15439694, 15416322, 15250856, 15206441, 15192236, 15143584, 14952547, 14947330, 14871408, 14856257, 14784585, 14751899, 14620420, 14455379, 14440612, 14418513, 14214261, 14122792, 14117795, 14102138, 13855944, 13796399, 13789045, 13408789, 13256891, 13094473, 13066038, 12964764, 12956892, 12758003, 12704778, 12586847, 12027757, 11953943, 11920947, 11822425, 11580194, 11267534, 11007929, 10777024, 10625199, 10563359, 10545245, 9988234, 9932041, 9877402, 9458507, 9442671, 9369805, 9284741, 9234715, 9168390, 9162165, 9040438, 8768324, 8602686, 8546271, 8526715, 8519247, 8415976, 8361529, 8342931, 8303364, 8291180, 7848549, 7847864, 7823851, 7773936, 7699327, 7602749, 7540526, 7385441, 7366433, 7337630, 7272373, 7187504, 7175749, 7023343, 7016216, 7010723, 6889607, 6863558, 6591329, 6531546, 6426286, 6407031, 6365870, 6311121, 6221977, 5801839, 5747997, 5730472, 5724599, 5424544, 5354783, 5296128, 5295458, 5238523, 5149248, 4850739, 4791108, 4763665, 4750185, 4719109, 4526021, 4494678, 4449061, 4362767, 4237908, 4213229, 4207655, 4169092, 4138237, 3938541, 3790285, 3766792, 3754053, 3632939, 3617582, 3608983, 3521123, 3330943, 3279031, 3227047, 3094550, 3025172, 3009534, 2943676, 2904654, 2809765, 2551266, 2428570, 2301374, 2254113, 2231034, 2228132, 2208756, 1810975, 1702807, 1698924, 1668930, 1654148, 1536080, 1477819, 1328232, 1000898, 925673, 874028, 630208, 524009, 502548, 387784, 283346, 59336, 17498}, new int[] {391846, 801454, 932294, 992081, 1432552, 1433244, 1436692, 1463582, 1703613, 1762894, 1794359, 1800192, 1894975, 1913203, 1964838, 2005948, 2047999, 2383858, 2684319, 2743219, 2836582, 3152591, 3238095, 3318511, 3402656, 3496157, 3506024, 3597120, 3638481, 3642843, 3670712, 3726377, 4150638, 4554272, 4802824, 4857664, 4898431, 5012543, 5280270, 5364626, 5676136, 5876874, 6022361, 6028227, 6245061, 6328848, 6580175, 6589494, 6791072, 6972786, 7219001, 7219169, 8449989, 8535620, 8608383, 8655386, 8825649, 8850774, 9058610, 9100221, 9119377, 9234359, 9366618, 9950180, 9994385, 10435500, 10550362, 10745332, 11153289, 11278740, 11299917, 11662805, 11693685, 11887990, 12148439, 12230424, 12286089, 12335688, 12589537, 13116895, 13456869, 13573727, 13668838, 13780348, 14028223, 14141947, 14354840, 15166110, 15718836, 15951581, 15983035, 16179427, 16217776, 16461748, 16690227, 17136624, 17586139, 17746429, 17962226, 17976610, 18107913, 18422389, 18642912, 18661809, 18695793, 18926655, 19190917, 19235936, 19387084, 19436183, 19439737, 19706074, 19865961, 19934195, 20219123, 20253953, 20679961, 20979273, 21159394, 21334369, 21367965, 21407073, 21482635, 21644357, 21705470, 21820171, 21899801, 22233185, 22312056, 22448820, 22575323, 22576884, 22832750, 22925897, 22988414, 23392266, 23470835, 23493224, 23511294, 23769257, 23872661, 24347501, 24751711, 25926015, 25976461, 26190491, 26499847, 26522588, 26776156, 27014398, 27100658, 27113794, 27289744, 27413026, 27423490, 27542904, 27575610, 27841647, 27891639, 28860977, 29184032, 29300814, 29323478, 29470586, 29475131, 29536195, 29675966, 29798114, 29945456, 30678564, 30798410, 30909184, 31111832, 31716591, 31971458, 32354071, 32380194, 32686984, 32735533, 32742174, 33232711, 33263849, 33359246, 33450766, 33742615, 34244707, 34408627, 34527993, 34578289, 34917461, 34954364, 35086580, 35124049, 36047971, 36158047, 36278447, 36483806, 36511452, 36594736, 36988057, 37098103, 37355315, 37828700, 37886907, 37979515, 39008036, 39178417, 39267111, 39683129, 41081657, 41110149, 41230016, 41409716, 41474286, 41764335, 41840751, 41915121, 42066987, 42136136, 42186378, 42200312, 42565789, 42614495, 42828837, 43070356, 43241588, 43571452, 43630492, 43751492, 43821686, 43841447, 44213463, 44392895, 44626622, 44631738, 44772111, 44791612, 45091523, 45122311, 45627790, 45650997, 45819713, 45821875, 46533603, 47032899, 47230938, 47565467, 48211152, 48637237, 49409974, 49466277, 49807998, 49944381, 50055869, 50944886, 51075111, 51236335, 51489853, 51922722, 52068578, 52531969, 52827202, 52902185, 53188237, 53418920, 53844116, 53967731, 53970796, 54241430, 54608737, 54638091, 55341442, 55362257, 55669391, 55670566, 55756085, 56770750, 57045767, 57361589, 57736703, 57751872, 57793340, 57876186, 57920259, 58518626, 58729518, 58760383, 58818749, 59052638, 59169255, 59212162, 59262169, 59380743, 59385422, 59511588, 59786438, 60094793, 60356579, 60661450, 60909937, 61221713, 61457378, 61751276, 61769572, 61890267, 62028912, 62193882, 62218889, 62547818, 62815742, 63026778, 63172740, 63189901, 63213453, 63264117, 63403888, 63432460, 63503450, 63792181, 64004709, 64112481, 64361073, 64431988, 64636323, 64840580, 64977367, 65367763, 65378535, 65512394, 65955648, 66272078, 66288732, 66483638, 66613842, 66677724, 66783787, 67223950, 67350642, 67519846, 67586032, 67938430, 68129393, 68417488, 68615186, 68701158, 68715796, 68754853, 69017618, 69089954, 69490011, 70259135, 70285622, 70311047, 70413341, 70616446, 70668056, 70748454, 71123056, 71255410, 71569348, 71632167, 71667195, 71820726, 71910315, 72211877, 72406989, 72718992, 72751655, 72880692, 72900352, 73209188, 73572088, 73618781, 73825126, 73867960, 74044920, 74051822, 74100021, 74175166, 74191009, 74341000, 74397247, 74547982, 74852706, 74855211, 75107218, 75274368, 75470880, 75471475, 75714063, 76004935, 76134622, 77212808, 77395184, 77502677, 77819877, 77861211, 78180910, 78603376, 78656266, 79600155, 79875556, 80080049, 80245069, 80611415, 80657896, 80764361, 80839022, 81511536, 81843732, 82619530, 82650778, 82709002, 82758650, 83028684, 83047085, 83098533, 83229037, 83645665, 83679182, 84078703, 84079858, 84179092, 84349602, 84394883, 84461237, 84633029, 85032215, 85082307, 85282973, 85584791, 85937367, 86031498, 86404209, 86505858, 86511677, 86537930, 86628248, 86691770, 86872063, 87217864, 87533048, 87663322, 87821642, 87850570, 87998684, 88050144, 88089743, 88325890, 88328010, 88333427, 88365184, 88476933, 88606543, 89192223, 89439977, 89522427, 89698014, 89958399, 90090987, 91015721, 91075926, 91122860, 91534189, 91754922, 92051794, 92129438, 92537300, 92548200, 92693695, 92718229, 93219133, 93601907, 93629599, 94057033, 94146637, 94554957, 95337874, 95516680, 95733720, 95758719, 95776623, 95792891, 95877293, 95895748, 96196373, 96246973, 96318708, 96537266, 96699900, 96822480, 97539936, 97749924, 98041206, 98094483, 98252132, 98294927, 98412917, 98572075, 99944335});
        int[] aliceRanking = new int[]{997, 994, 992, 992, 990, 990, 990, 990, 984, 984, 984, 984, 983, 983, 983, 983, 983, 978, 976, 976, 975, 970, 969, 968, 967, 967, 967, 966, 963, 963, 963, 963, 958, 950, 946, 945, 945, 945, 943, 940, 939, 935, 935, 935, 934, 933, 929, 929, 928, 926, 921, 921, 905, 903, 901, 901, 900, 900, 899, 899, 899, 897, 895, 890, 889, 889, 888, 886, 884, 883, 883, 882, 882, 881, 878, 878, 878, 878, 877, 871, 869, 869, 869, 869, 866, 863, 862, 851, 844, 843, 843, 839, 839, 836, 834, 832, 829, 829, 828, 828, 828, 826, 824, 824, 824, 820, 817, 816, 811, 810, 810, 806, 805, 805, 804, 803, 801, 794, 792, 792, 792, 792, 792, 789, 789, 788, 787, 785, 782, 779, 779, 779, 774, 773, 773, 769, 768, 768, 768, 766, 765, 754, 750, 738, 738, 736, 734, 733, 732, 730, 729, 729, 727, 725, 725, 721, 720, 718, 718, 707, 704, 704, 703, 701, 701, 701, 700, 698, 694, 691, 691, 688, 688, 682, 682, 677, 677, 670, 670, 670, 665, 665, 665, 663, 660, 654, 653, 651, 651, 648, 648, 646, 646, 639, 638, 638, 638, 637, 635, 632, 632, 625, 617, 616, 616, 607, 605, 605, 600, 587, 587, 587, 584, 584, 580, 580, 579, 576, 575, 575, 575, 568, 568, 567, 565, 561, 557, 557, 557, 556, 556, 553, 550, 548, 548, 547, 547, 544, 544, 538, 538, 538, 538, 532, 531, 529, 523, 521, 515, 505, 505, 502, 501, 501, 495, 495, 495, 493, 487, 487, 480, 478, 478, 475, 472, 468, 467, 467, 465, 462, 462, 457, 457, 454, 454, 453, 444, 441, 436, 430, 430, 430, 428, 428, 425, 423, 423, 422, 421, 420, 420, 420, 418, 418, 418, 418, 410, 405, 402, 397, 394, 389, 385, 385, 384, 383, 383, 383, 378, 373, 372, 368, 368, 368, 367, 365, 365, 363, 359, 358, 356, 353, 352, 350, 348, 347, 345, 345, 343, 337, 334, 334, 331, 330, 330, 329, 321, 321, 320, 319, 317, 317, 311, 310, 310, 310, 310, 306, 306, 304, 298, 298, 298, 297, 294, 294, 294, 290, 289, 285, 285, 284, 283, 282, 276, 275, 273, 273, 273, 271, 270, 268, 268, 264, 264, 264, 264, 264, 264, 264, 262, 261, 258, 255, 254, 252, 249, 247, 247, 247, 241, 240, 228, 226, 225, 222, 222, 219, 217, 217, 203, 201, 199, 197, 196, 196, 196, 196, 187, 184, 182, 182, 182, 182, 181, 181, 180, 179, 175, 175, 174, 174, 171, 168, 166, 164, 159, 157, 157, 155, 151, 147, 147, 145, 143, 143, 143, 142, 141, 139, 135, 130, 129, 128, 128, 127, 126, 124, 119, 119, 119, 119, 118, 118, 110, 107, 107, 105, 104, 102, 89, 89, 89, 89, 88, 84, 84, 81, 81, 81, 81, 77, 68, 67, 64, 63, 59, 49, 48, 46, 45, 45, 45, 45, 45, 39, 39, 38, 35, 35, 33, 30, 27, 22, 22, 19, 18, 16, 14, 1};
        System.out.println("Returned output length:" + ranking.length + " Expected output length:" + aliceRanking.length);
        /*int[] sortedArray = new int[20];
        for (int i=100, j=0; i >= 0 && j<20; i=i-5, j++) {
            sortedArray[j] = i;
        }
        System.out.println("Position of elem: " + binarySearch( sortedArray, 5));
        System.out.println("Position of elem: " + binarySearch( sortedArray, 25));
        System.out.println("Position of elem: " + binarySearch( sortedArray, 75));
        System.out.println("Position of elem: " + binarySearch( sortedArray, 51));
        System.out.println("Position of elem: " + binarySearch( new int[] {100, 50, 40, 20, 10}, 25));
        System.out.println("Position of elem: " + binarySearch( new int[] {100, 50, 40, 20, 10}, 50));
        System.out.println("Position of elem: " + binarySearch( new int[] {100, 50, 40, 20, 10}, 40));*/

        /*
        {1,2,3}
        {}
        {}
        arr {{1,2,3},
            {3,4,5},
            {6,7,8}}

        */
        /*
        int[][] s = {{4,9,2},{3,5,7},{8,1,5}};
        System.out.println(formingMagicSquare(s) + "");

        int[][] s2 = {{4,8,2},{4,5,7},{6,1,6}};
        System.out.println("Minimum cost: "+formingMagicSquare(s2));
        */





    }













    /*
    1. Write a closure that returns the lesser of two double values.
    2. Write a closure that decides if a value is even.
    3. Write a closure that returns last n characters of a string.
    * */

    double lesser = operate(10.4, 2.9, (aDouble, bDouble) -> {
        return aDouble < bDouble ? aDouble : bDouble;
    } );

    double sum = operate(5.1, 2.22, (a, b) -> {
        return a+b;
    });

    Integer max = processOperation(1, 2, (x, y) -> x > y ? x : y);

    Float mulFloat = processOperation(3.3f, 9.1f, (x, y) -> x * y);
    Double mulDouble = processOperation(3.3, 9.1, (x, y) -> x * y);

    int square = processOperation(10, null, (x, y) -> x * x);

    //Supplier
    //Consumer
    //Optional

}



