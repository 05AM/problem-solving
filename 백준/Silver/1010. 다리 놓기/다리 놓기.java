import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();

        for (int i = 0; i < size; i++) {
            int n = in.nextInt();
            int m = in.nextInt();

            System.out.println(permutation(m, n));
        }
    }

    public static long permutation(int m, int n) {
        BigInteger numerator = BigInteger.valueOf(1);
        BigInteger denominator = BigInteger.valueOf(1);

        for (int i = m, j = n; i > (m - n); i--, j--) {
            numerator = numerator.multiply(BigInteger.valueOf(i));
            denominator = denominator.multiply(BigInteger.valueOf(j));
        }

        return numerator.divide(denominator).longValue();
    }
}