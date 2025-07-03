import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final StringBuilder results = new StringBuilder();

    private static int n, m;
    private static int[] nums, selected;
    private static String last = "";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        nums = new int[n];
        selected = new int[m];

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        Arrays.sort(nums);
        solution(0, 0);

        System.out.println(results);
    }

    private static void solution(int index, int start) {
        if (index == m) {
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < m; i++) {
                result.append(selected[i]).append(" ");
            }

            if (last != result.toString()) {
                results.append(result).append("\n");
                last = result.toString();
            }
            return;
        }

        for (int i = start; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            selected[index] = nums[i];
            solution(index + 1, i);
        }
    }
}