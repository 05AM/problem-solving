import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] dp = new int[n + 1];
        dp[1] = 1;

        int seed = 1;
        for (int i = 1; i <= n; i++) {
            if (Math.pow(seed + 1, 2) == i) {
                seed++;
                dp[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;

                for (int j = seed; j >= 1; j--) {
                    int value = (int)Math.pow(j, 2);
                    min = Math.min(min, dp[value] + dp[i - value]);
                }

                dp[i] = min;
            }
        }

        System.out.println(dp[n]);
    }
}