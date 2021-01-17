package hackerrank;

import java.io.IOException;

/**
 * Created by Rahul on 6/15/20
 */
public class SaveThePrisoner {

    /**
     * Complete the saveThePrisoner function below.
     *
     * Example:
     *  n m s => o/p
     *  5 2 1 => 2
     *  5 2 2 => 3
     *
     *  1 <= n <= 10^9
     *  1 <= m <= 10^9
     *  1 <= s <= n
     *
     * @param n number of prisoners
     * @param m number of candies/sweets/desserts
     * @param s seat number to begin with
     * @return seat number of prisoner to be warned
     */
    static int saveThePrisoner(int n, int m, int s) {

        Integer numCandiesForLastRound = m % n, prisonerToBeWarned = s - 1 + numCandiesForLastRound;

        prisonerToBeWarned = prisonerToBeWarned == 0 ? n : prisonerToBeWarned > n ? prisonerToBeWarned % n : prisonerToBeWarned;

        return prisonerToBeWarned;

    }

    //private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Warn the prisoner " + saveThePrisoner(5,2,1));

        System.out.println("Warn the prisoner " + saveThePrisoner(5,2,2));

        System.out.println("Warn the prisoner " + saveThePrisoner(5,47,1));

        System.out.println("Warn the prisoner " + saveThePrisoner(47,47,1));

        System.out.println("Warn the prisoner " + saveThePrisoner(2147483647,2147483647,1));

        System.out.println("Warn the prisoner " + saveThePrisoner(7,19, 5));

        System.out.println("Warn the prisoner " + saveThePrisoner(3,7, 3));

        System.out.println("Warn the prisoner " + saveThePrisoner(214748,2147483647, 214748));

        System.out.println("Warn the prisoner " + saveThePrisoner(7,19, 2));

        System.out.println("Warn the prisoner " + saveThePrisoner(46934,543563655, 46743));



        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nms = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nms[0]);

            int m = Integer.parseInt(nms[1]);

            int s = Integer.parseInt(nms[2]);

            int result = saveThePrisoner(n, m, s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();*/
    }
}
