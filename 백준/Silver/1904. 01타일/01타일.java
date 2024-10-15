import java.util.Scanner;

public class Main {
    static int[] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        dp = new int[n + 1];

        System.out.println(solution(n));
    }

    private static int solution(int n) {
        if (n == 1) {
            return 1;
        }

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 15746;
        }

        return dp[n];
    }
}