import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final long MOD = 1_000_000_009L;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(in.readLine());

        int T = Integer.parseInt(input.nextToken());
        int[] nums = new int[T];

        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < T; i++) {
            nums[i] = Integer.parseInt(in.readLine());
            maxNum = Math.max(maxNum, nums[i]);
        }

        long[] dp = new long[maxNum + 1];

        if (maxNum >= 0) {
            dp[0] = 1;
        }
        if (maxNum >= 1) {
            dp[1] = 1;
        }
        if (maxNum >= 2) {
            dp[2] = 2;
        }

        for (int i = 3; i <= maxNum; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
        }

        for (int num : nums) {
            System.out.println(dp[num]);
        }
    }
}