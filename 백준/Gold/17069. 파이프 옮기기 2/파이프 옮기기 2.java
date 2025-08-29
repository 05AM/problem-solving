import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[][] a = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) a[i][j] = Integer.parseInt(st.nextToken());
        }
        
        long[][][] dp = new long[N + 1][N + 1][3];
        if (a[1][1] == 0 && a[1][2] == 0) dp[1][2][0] = 1;
        
        for (int i = 1; i <= N; i++) {
            for (int j = 3; j <= N; j++) {
                if (a[i][j] == 1) continue;
                dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][2];
                if (i > 1) dp[i][j][1] += dp[i - 1][j][1] + dp[i - 1][j][2];
                if (i > 1 && a[i - 1][j] == 0 && a[i][j - 1] == 0)
                    dp[i][j][2] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
            }
        }
        
        long ans = dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
        System.out.println(ans);
    }
}
