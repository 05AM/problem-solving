import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        while (T-- > 0) {
            int n = in.nextInt();
            int[] files = new int[n];
            int[] prefixSum = new int[n + 1];
            int[][] dp = new int[n][n];

            // 파일 크기 입력 및 prefixSum 계산
            for (int i = 0; i < n; i++) {
                files[i] = in.nextInt();
                prefixSum[i + 1] = prefixSum[i] + files[i];
            }

            // DP 계산
            for (int length = 2; length <= n; length++) { // 부분 파일의 길이
                for (int i = 0; i <= n - length; i++) {   // 시작점
                    int j = i + length - 1;              // 끝점
                    dp[i][j] = Integer.MAX_VALUE;

                    for (int k = i; k < j; k++) {        // 구간 분할점
                        int cost = dp[i][k] + dp[k + 1][j] + (prefixSum[j + 1] - prefixSum[i]);
                        dp[i][j] = Math.min(dp[i][j], cost);
                    }
                }
            }

            System.out.println(dp[0][n - 1]);
        }
    }
}