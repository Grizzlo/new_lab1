/**
 * Created by grizzly on 3/13/15.
 */
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String args[]) throws IOException {
        //Scanner sc = new Scanner(System.in);
        //int num_thread;
        // System.out.println("Enter num of thread");
        //num_thread = sc.nextInt();
        Random rand = new Random() ;
        int num_vector =1000*(1+rand.nextInt(1000));
        System.out.println("Vector:" + num_vector);
        for (int n=0;n<5;n++) {
            if (n==4) n=10;
            System.out.println("Thread:" + (n+1));
            for (int m = 0; m < 10; m++) {
                Work vect = new Work((n+1), num_vector);
            }
        }
    }
}
