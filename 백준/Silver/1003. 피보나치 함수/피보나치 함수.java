import java.util.Scanner;

public class Main {
    private static final int MAX_N = 40;
    private static Integer[][] dp = new Integer[MAX_N + 1][2];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        dp[0] = new Integer[] {1, 0};
        dp[1] = new Integer[] {0, 1};

        int testCase = in.nextInt();
        for (int i = 0; i < testCase; i++) {
            int n = in.nextInt();
            fibonacci(n);

            System.out.println(dp[n][0] + " " + dp[n][1]);
        }

        in.close();
    }

    private static void fibonacci(int n) {
        if (dp[n][0] != null && dp[n][1] != null) {
            return;
        }

        fibonacci(n - 2);
        fibonacci(n - 1);

        dp[n][0] = dp[n - 2][0] + dp[n - 1][0];
        dp[n][1] = dp[n - 2][1] + dp[n - 1][1];
    }
}