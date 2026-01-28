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

        int cnt = 0;
        int left = 0;
        int right = 0;
        int sum = primes[0];

        while (left < primes.length) {
            if (sum < n && right + 1 < primes.length) {
                right++;
                sum += primes[right];
            } else {
                if (sum == n) {
                    cnt++;
                }
                sum -= primes[left];
                left++;
            }
        }

        return cnt;
    }

    private static int[] getPrimeNumbersUntil(int n) {
        boolean[] isPrimeNumber = new boolean[n + 1];
        Arrays.fill(isPrimeNumber, true);

        isPrimeNumber[0] = false;
        isPrimeNumber[1] = false;

        for (int i = 2; (long) i * i <= n; i++) {
            if (isPrimeNumber[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrimeNumber[j] = false;
                }
            }
        }

        return IntStream.range(2, n + 1)
                .filter(i -> isPrimeNumber[i])
                .toArray();
    }
}