package hackerrank;

/**
 * Created by Rahul on 6/26/21
 *
 * Your local library needs your help! Given the expected and actual return dates for a library book, create a program that calculates the fine (if any). The fee structure is as follows:
 * If the book is returned on or before the expected return date, no fine will be charged (i.e.: fine=0).
 * If the book is returned after the expected return day but still within the same calendar month and year as the expected return date, fine = 15 Hackos x (number of days late).
 * If the book is returned after the expected return month but still within the same calendar year as the expected return date, the fine = 500 Hackos x (number of months late).
 * If the book is returned after the calendar year in which it was expected, there is a fixed fine of 10000 Hackos.
 * Charges are based only on the least precise measure of lateness. For example, whether a book is due January 1, 2017 or December 31, 2017, if it is returned January 1, 2018, that is a year late and the fine would be 10,000 Hackos.
 *
 * Test cases:
 * 1. Same month return
 * 2. Same year return
 * 3. Different year return
 *
 */
public class LibraryFine {
    /*
     * Complete the 'libraryFine' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER d1 return date
     *  2. INTEGER m1 return month
     *  3. INTEGER y1 return year
     *  4. INTEGER d2 expected return date
     *  5. INTEGER m2 expected return month
     *  6. INTEGER y2 expected return year
     *
     * if y1 - y2 > 0, return 10000 Hackos
     * else if m1 - m2 > 0, return 500 * (m1 - m2)
     * else if d1 - d2 > 0, return  15 * (d1 - d2)
     * else return 0
     *
     * Examples:
     * 2 7 1014
     * 1 1 1015
     *
     */

    // 3 Edge cases failing
    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        int fine = 0;

        if ((y1-y2) < 0) {          // returned previous year, so no fine regardless of what month and date
            fine = 0;
        } else if ((y1-y2) > 0) {   // returned next year, so fixed fine
            fine = 10000;
        } else if ((m1 - m2) < 0) { // returned same year (inferred from two if-conditions above) but earlier months, so no fines regardless of date
            fine = 0;
        } else if ((m1 - m2) > 0) { // returned same year (inferred from two if-conditions above) but later months, so charge fines
            fine = 500 * (m1 - m2);
        } else if ((d1 - d2) > 0) { // returned same year, same month but later date, so charge fine. Otherwise fine is 0 as defined in variable declaration.
            fine = 15 * (d1 - d2);
        }
        return fine;
    }

}
