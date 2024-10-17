import java.util.Scanner;

public class Main {
    static int[] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        dp = new int[n + 1];
        int[] costs = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            costs[i] = in.nextInt();
        }

        System.out.println(solution(n, costs));
    }

    private static int solution(int n, int[] costs) {
        if (n == 1) {
            return costs[1];
        }
        
        dp[1] = costs[1];
        dp[2] = dp[1] + costs[2];

        for (int i = 3; i <= n; i++) {
            int max = Math.max(dp[i - 3] + costs[i - 1], dp[i - 2]);
            dp[i] = costs[i] + max;
        }

        return dp[n];
    }
}