import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    private static int m;

    private static final Set<Integer> nums = new TreeSet<>();
    private static final Map<Integer, Integer> count = new HashMap<>();
    private static final List<String> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = in.nextInt();
        m = in.nextInt();
        int[] sequence = new int[n];

        for (int i = 0; i < n; i++) {
            sequence[i] = in.nextInt();
            nums.add(sequence[i]);
            count.merge(sequence[i], 1, Integer::sum);
        }

        // 사전순 정렬
        Arrays.sort(sequence);
        dfs(0, new StringBuilder());

        for (String result : results) {
            out.write(result);
            out.write("\n");
        }

        out.flush();
    }

    private static void dfs(int depth, StringBuilder sequence) {
        if (depth == m) {
            results.add(sequence.toString());
            return;
        }

        for (int num : nums) {
            if (count.get(num) > 0) {
                count.put(num, count.get(num) - 1);
                dfs(depth + 1, new StringBuilder(sequence).append(num).append(" "));
                count.put(num, count.get(num) + 1);
            }
        }
    }
}