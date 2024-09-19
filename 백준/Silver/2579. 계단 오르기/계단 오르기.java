import java.util.Scanner;

public class Main {

    static int[] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] scores = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            scores[i] = in.nextInt();
        }

        solution(n, scores);
        System.out.println(dp[n]);
    }

    private static void solution(int n, int[] scores) {
        if (n == 1) {
            dp[1] = scores[1];
            return;
        }
        
        dp[1] = scores[1];
        dp[2] = scores[1] + scores[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + scores[i - 1]) + scores[i];
        }
    }
}