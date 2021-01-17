package gladiator;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Rahul on 3/26/20
 */
public class EnglishAlphabets {
    public static void main(String args[] ) throws Exception {
        int numStrings=0;
        List<String> myString = new LinkedList<>();
        try {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                myString.add(scanner.next());
            }
            scanner.close();
            numStrings = Integer.parseInt(myString.get(0).trim());
            myString.remove(0);

            for (String str : myString) {
                processString(str);
            }
        } catch (Exception e) {
            System.out.println("Error occurred " + e.toString());
        }
    }

    static void processString(String str) {
        int v=0, c=0;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
                    || str.charAt(i) == 'u' || str.charAt(i) == 'A' || str.charAt(i) == 'E' || str.charAt(i) == 'I'
                    || str.charAt(i) == 'O' || str.charAt(i) == 'U' ) {
                v++;
            } else {
                c++;
            }
        }
        System.out.println(v + " " + c + " " + v*c);
    }
}
