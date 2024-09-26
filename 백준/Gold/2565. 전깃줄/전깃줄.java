import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] lines = new int[n][2];

        for (int i = 0; i < n; i++) {
            lines[i][0] = in.nextInt();
            lines[i][1] = in.nextInt();
        }

        System.out.println(solution(n, lines));
    }

    private static int solution(int n, int[][] lines) {
        Arrays.sort(lines, Comparator.comparingInt(a -> a[0]));

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int lis_length = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (lines[i][1] > lines[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            lis_length = Math.max(lis_length, dp[i]);
        }

        return n - lis_length;
    }
}