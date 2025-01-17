import java.util.Scanner;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }

        long numerator = factorial[n];
        long denominator = (factorial[k] * factorial[n - k]) % MOD;
        long denominatorInverse = modularInverse(denominator, MOD);

        long result = (numerator * denominatorInverse) % MOD;
        System.out.println(result);
    }

    static long modularInverse(long a, int mod) {
        return power(a, mod - 2, mod);
    }

    static long power(long base, long exponent, int mod) {
        long result = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exponent >>= 1;
        }
        return result;
    }
}