package hackerrank;

/**
 * Created by Rahul on 1/13/21
 */
public class JumpingOnTheClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {

        int cloudNumber = 0;
        int thunderClouds = 0;
        int energy = 100;
        do {
            thunderClouds += c[cloudNumber];
            energy--;
            cloudNumber = (cloudNumber + k) % c.length;
        } while (cloudNumber != 0);

        energy -= (thunderClouds * 2);
        return energy;
    }

    public static void main (String... args) {
        System.out.println(jumpingOnClouds(new int[] {0,0,1,0,0,1,1,0}, 2));
    }

}
