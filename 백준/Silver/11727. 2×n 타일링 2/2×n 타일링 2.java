import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int divisor = 10007;
        int[] dp = new int[n + 1];

        dp[1] = 1;

        if (n > 1) {
            dp[2] = 3;

            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2] * 2) % divisor;
            }
        }

        System.out.println(dp[n]);
    }
}