import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] amounts = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            amounts[i] = in.nextInt();
        }

        System.out.println(solution(n, amounts));
    }

    private static int solution(int n, int[] amounts) {
        if (n == 1) {
            return amounts[1];
        }

        int[] dp = new int[n + 1];

        dp[1] = amounts[1];
        dp[2] = amounts[1] + amounts[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + amounts[i], dp[i - 3] + amounts[i - 1] + amounts[i]));
        }

        return dp[n];
    }
}