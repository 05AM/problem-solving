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

    public static int solution(int n, int[] nums) {
        int[] dpAsc = new int[n + 1];
        int[] dpDesc = new int[n + 1];

        Arrays.fill(dpAsc, 1);
        Arrays.fill(dpDesc, 1);

        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j >= 1; j--) {
                if (nums[i] > nums[j]) {
                    dpAsc[i] = Math.max(dpAsc[i], dpAsc[j] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                if (nums[i] > nums[j]) {
                    dpDesc[i] = Math.max(dpDesc[i], dpDesc[j] + 1);
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dpAsc[i] + dpDesc[i] - 1);
        }

        return answer;
    }
}