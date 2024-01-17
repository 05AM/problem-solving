import java.util.Scanner;

public class Main {
    public void solution(String[] numbers) {
        for (String number : numbers) {
            StringBuilder sb = new StringBuilder(number);
            int n = Integer.parseInt(sb.reverse().toString());

            if (isPrime(n)) {
                System.out.print(n + " ");
            }
        }
    }

    private boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String[] numbers = new String[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = in.next();
        }

        T.solution(numbers);
    }
}
