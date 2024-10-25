import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static long[] remainder;
    static HashMap<Long, Long> remainderCount;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        remainder = new long[n + 1];
        remainderCount = new HashMap<>();

        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = in.nextInt();
        }

        System.out.println(solution(n, m, nums));
    }

    private static long solution(int n, int m, int[] nums) {
        long count = 0;
        remainderCount.put(0L, 1L);

        for (int i = 1; i <= n; i++) {
            remainder[i] = (remainder[i - 1] + nums[i]) % m;

            count += remainderCount.getOrDefault(remainder[i], 0L);
            remainderCount.merge(remainder[i], 1L, Long::sum);
        }

        return count;
    }
}