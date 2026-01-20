import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(n, nums);
        System.out.println(result);
    }

    private static int solution(int n, int[] nums) {
        Arrays.sort(nums);

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (isGood(i, nums)) {
                cnt++;
            }
        }

        return cnt;
    }

    private static boolean isGood(int i, int[] nums) {
        int value = nums[i];

        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (l == i) {
                l++;
            } else if (r == i) {
                r--;
            } else {
                if (nums[l] + nums[r] == value) {
                    return true;
                } else if (nums[l] + nums[r] < value) {
                    l++;
                } else if (nums[l] + nums[r] > value) {
                    r--;
                }
            }
        }

        return false;
    }
}
