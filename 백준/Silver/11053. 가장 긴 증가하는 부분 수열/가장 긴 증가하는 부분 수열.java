import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] nums = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            nums[i] = in.nextInt();
        }

        System.out.println(solution(n, nums));
    }

    private static int solution(int n, int[] nums) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = nums[1] < nums[2] ? 2 : 1;

        int answer = Integer.MIN_VALUE;

        for (int i = 3; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

                if (dp[i] == 0) {
                    dp[i] = 1;
                }

                answer = Math.max(answer, dp[i]);
            }
        }

        return answer;
    }
}