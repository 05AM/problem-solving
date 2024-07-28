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

        for (int i = 2; i * i <= n; i++) {
            if (primeNumbers[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primeNumbers[j] = false;
                }
            }
        }

        List<Integer> factors = new ArrayList<>();
        int i = 2;
        while (n != 1) {
            if (primeNumbers[i] && (n % i == 0)) {
                n /= i;
                factors.add(i);
            } else {
                i++;
            }
        }

        factors.forEach(System.out::println);
    }
}