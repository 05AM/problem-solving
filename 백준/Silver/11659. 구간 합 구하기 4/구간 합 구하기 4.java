import java.util.Scanner;

public class Main {
    static int[] prefixSum;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        prefixSum = new int[n + 1];
        int[] nums = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            nums[i] = in.nextInt();
        }

        calculatePrefixSum(n, nums);

        for (int cnt = 0; cnt < m; cnt++) {
            int i = in.nextInt();
            int j = in.nextInt();

            System.out.println(prefixSum[j] - prefixSum[i - 1]);
        }
    }

    private static void calculatePrefixSum(int n, int[] nums) {
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
    }
}