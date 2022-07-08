package arrays;

public class EnhancedForDemo {
    public static void main(String[] args) {
        int[] primes = { 2, 3, 5, 7, 11,
        	13, 17, 19, 23, 29 };

        // Print the primes out without for/in loop
        for (int i = 0; i < primes.length ; i++) {
            System.out.print(primes[i] + ",");
        }
        System.out.println();

        // Print the primes out using a for/in loop
        for (int n : primes) {
            System.out.print(n + ",");
        }
    }
}
