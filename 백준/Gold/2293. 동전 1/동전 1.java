import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = in.nextInt();
        }

        // 가치의 합이 index가 되는 경우의 수
        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int sum = coin; sum <= k; sum++) {
                dp[sum] += dp[sum - coin];
            }
        }

        System.out.println(dp[k]);
    }
}