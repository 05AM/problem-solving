import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] memory = new int[n];
        int[] cost = new int[n];
        int sumCost = 0;

        for (int i = 0; i < n; i++) {
            memory[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            cost[i] = in.nextInt();
            sumCost += cost[i];
        }

        int[] dp = new int[sumCost + 1];

        for (int i = 0; i < n; i++) {
            for (int j = sumCost; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
            }
        }

        for (int i = 0; i <= sumCost; i++) {
            if (dp[i] >= m) {
                System.out.println(i);
                return;
            }
        }
    }
}
