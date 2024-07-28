import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {

    static boolean[] primeNumbers;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        solution(n);
    }

    static void solution(int n) {
        primeNumbers = new boolean[n + 1];
        Arrays.fill(primeNumbers, true);
        primeNumbers[1] = false;

        List<Integer> factors = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (primeNumbers[i]) {
                while ((n != 1) && (n % i == 0)) {
                    n /= i;
                    factors.add(i);
                }

                for (int j = i; j <= n; j += i) {
                    primeNumbers[j] = false;
                }
            }
        }

        factors.forEach(System.out::println);
    }
}
