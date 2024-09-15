import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] costs = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                costs[i][j] = in.nextInt();
            }
        }

        int min = solution(n, costs);
        System.out.println(min);
    }

    private static int solution(int n, int[][] costs) {
        int[][] dp = new int[n][n];

        dp[0][0] = costs[0][0];

        for (int row = 1; row < n; row++) {
            for (int col = 0; col <= row; col++) {
                if (col == 0) {
                    dp[row][col] = dp[row - 1][col] + costs[row][col];
                    continue;
                }

                if (col == row) {
                    dp[row][col] = dp[row - 1][col - 1] + costs[row][col];
                    continue;
                }

                dp[row][col] = Math.max(dp[row - 1][col], dp[row - 1][col - 1]) + costs[row][col];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[n - 1][i]);
        }

        return max;
    }
}