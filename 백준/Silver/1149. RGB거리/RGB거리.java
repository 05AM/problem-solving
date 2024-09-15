import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] costs = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                costs[i][j] = in.nextInt();
            }
        }

        int min = solution(n, costs);
        System.out.println(min);
    }

    private static int solution(int n, int[][] costs) {
        int[][] dp = new int[n][3];

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                int minCost = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);

                dp[i][j] = costs[i][j] + minCost;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }

        return min;
    }
}