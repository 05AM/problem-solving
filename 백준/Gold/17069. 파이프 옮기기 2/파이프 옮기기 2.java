import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;
    private static final int DIAGONAL = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[][] map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        // 이동했을 때 파이프가 특정 방향이 되는 경우의 수
        // 가로/세로/대각선 방향의 파이프가 각각 이동할 수 있는 경로가 다르기에 구분해야 함
        long[][][] dp = new long[3][n + 1][n + 1];
        dp[HORIZONTAL][1][2] = 1;

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                if (map[r][c] == 1) {
                    continue;
                }

                // 가로
                dp[HORIZONTAL][r][c] += dp[HORIZONTAL][r][c - 1] + dp[DIAGONAL][r][c - 1];
                // 세로
                dp[VERTICAL][r][c] += dp[VERTICAL][r - 1][c] + dp[DIAGONAL][r - 1][c];
                // 대각선
                if (map[r][c - 1] != 1 && map[r - 1][c] != 1) {
                    // 벽 조건을 만족하면,
                    dp[DIAGONAL][r][c] += dp[HORIZONTAL][r - 1][c - 1] + dp[VERTICAL][r - 1][c - 1] + dp[DIAGONAL][r - 1][c - 1];
                }
            }
        }

        System.out.println(dp[HORIZONTAL][n][n] + dp[VERTICAL][n][n] + dp[DIAGONAL][n][n]);
    }
}
