import java.util.Scanner;

public class Main {
    static int[][] prefixSum;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        prefixSum = new int[n + 1][n + 1];

        int[][] nums = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                nums[i][j] = in.nextInt();
            }
        }

        solution(n, nums);

        for (int i = 0; i < m; i++) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();

            int result = prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1];
            System.out.println(result);
        }
    }

    private static void solution(int n, int[][] nums) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + nums[i][j];
            }
        }
    }
}