import java.util.Scanner;

public class Main {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        dp = new int[n + 1][3];
        int[][] costs = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                costs[i][j] = in.nextInt();
            }
        }

        System.out.println(solution(n, costs));
    }

    private static int solution(int n, int[][] costs) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = costs[i][j] + Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[n][i]);
        }

        return min;
    }
}
