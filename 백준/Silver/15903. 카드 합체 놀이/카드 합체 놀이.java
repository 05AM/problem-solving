import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer input = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(input.nextToken());
        int m = Integer.parseInt(input.nextToken());

        long[] nums = new long[n];
        input = new StringTokenizer(in.readLine());

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input.nextToken());
        }

        long result = findMinSum(m, nums);
        System.out.println(result);
    }

    private static long findMinSum(int m, long[] nums) {
        for (int i = 0; i < m; i++) {
            Arrays.sort(nums);

            long sum = nums[0] + nums[1];
            nums[0] = sum;
            nums[1] = sum;
        }

        return Arrays.stream(nums)
                .sum();
    }
}