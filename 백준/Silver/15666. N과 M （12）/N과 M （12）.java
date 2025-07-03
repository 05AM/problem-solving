import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static int n;
    private static int m;

    private static int[] nums;
    private static int[] selected;

    private static final Set<String> results = new HashSet<>();

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
    }

    private static void solution(int index, int start) {
        if (index == m) {
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < m; i++) {
                result.append(selected[i]).append(" ");
            }

            if (!results.contains(result.toString())) {
                results.add(result.toString());
                System.out.println(result);
            }
            return;
        }

        for (int i = start; i < n; i++) {
            selected[index] = nums[i];
            solution(index + 1, i);
        }
    }
}