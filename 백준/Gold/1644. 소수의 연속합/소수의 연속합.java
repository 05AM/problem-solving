import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        System.out.println(getContinuousPrimeSumCount(n));
    }

    private static int getContinuousPrimeSumCount(int n) {
        if (n == 1) {
            return 0;
        }

        int[] primes = getPrimeNumbersUntil(n);
        int primesLength = primes.length;

        int count = 0;
        int front = 0;
        int back = 0;
        int currentSum = primes[0];

        while (front <= back) {
            if (currentSum == n) {
                count++;
            }

            if (currentSum <= n && back + 1 < primesLength) {
                currentSum += primes[++back];
            } else {
                currentSum -= primes[front++];
            }
        }

        return count;
    }

    private static int[] getPrimeNumbersUntil(int n) {
        boolean[] isPrimeNumber = new boolean[n + 1];
        Arrays.fill(isPrimeNumber, true);

        isPrimeNumber[0] = false;
        isPrimeNumber[1] = false;

        for (int i = 2; i <= n; i++) {
            if (isPrimeNumber[i]) {
                for (int j = 2, next = i * j; next <= n; j++, next = i * j) {
                    isPrimeNumber[next] = false;
                }
            }
        }

        return IntStream.range(2, n + 1)
                .filter(i -> isPrimeNumber[i])
                .toArray();
    }
}