import java.util.Scanner;

public class Main {
    static int[] prefixSum;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        prefixSum = new int[n + 1];
        int[] temperatures = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            temperatures[i] = in.nextInt();
        }

        System.out.println(solution(n, k, temperatures));
    }

    private static int solution(int n, int k, int[] temperatures) {
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + temperatures[i];

            if (i >= k) {
                max = Math.max(max, prefixSum[i] - prefixSum[i - k]);
            }
        }

        return max;
    }
}