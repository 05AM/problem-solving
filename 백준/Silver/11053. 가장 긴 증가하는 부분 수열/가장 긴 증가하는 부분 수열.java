import java.util.Arrays;
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
        Arrays.fill(dp, 1);

        int answer = Integer.MIN_VALUE;

        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j >= 1; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

                answer = Math.max(answer, dp[i]);
            }
        }

        return answer;
    }
}