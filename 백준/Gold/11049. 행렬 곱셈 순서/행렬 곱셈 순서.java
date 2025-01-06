import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] matrixs = new int[n + 1][2];    // 행: 행렬의 순서 번호 / 열[0]: 행 개수 / 열[1]: 열 개수

        for (int i = 1; i <= n; i++) {
            matrixs[i][0] = in.nextInt();
            matrixs[i][1] = in.nextInt();
        }

        int[][] dp = new int[n + 1][n + 1];
        for (int length = 2; length <= n; length++) {
            for (int i = 1; i <= n - length + 1; i++) {
                int j = i + length - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    if (matrixs[k][1] == matrixs[k + 1][0]) {
                        int multiplied = matrixs[i][0] * matrixs[k][1] * matrixs[j][1];
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + multiplied);
                    }
                }
            }
        }

        System.out.println(dp[1][n]);
    }
}