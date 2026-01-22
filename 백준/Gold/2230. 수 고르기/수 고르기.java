import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(in.readLine());
        }

        int result = solution(n, m, nums);
        System.out.println(result);
    }

    private static int solution(int n, int m, int[] nums) {
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sub;

        while (right < n && right >= left) {
            sub = nums[right] - nums[left];

            if (sub < m) {
                right++;
            } else {
                min = Math.min(min, sub);
                left++;
            }
        }

        return min;
    }
}