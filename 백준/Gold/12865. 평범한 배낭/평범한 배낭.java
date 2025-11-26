// 정석 2차원 배열
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] weights = new int[n + 1];
        int[] values = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            weights[i] = in.nextInt();
            values[i] = in.nextInt();
        }

        // n: 현재까지 고려한 물건 번호, k: 현재 사용할 수 있는 배낭의 무게
        int[][] dp = new int[n + 1][k + 1];

        // 물건은 한 번만 담을 수 있으므로 물건 번호가 바깥 루프
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= k; w++) {
                if (w < weights[i]) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w - weights[i]] + values[i], dp[i - 1][w]);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}


// 1차원 배열
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] W = new int[N + 1];
        int[] V = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            W[i] = sc.nextInt();
            V[i] = sc.nextInt();
        }

        int[] dp = new int[K + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = K; j >= W[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
            }
        }

        System.out.println(dp[K]);
    }
}

