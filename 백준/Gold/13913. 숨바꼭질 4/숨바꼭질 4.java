import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int LIMIT = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        solution(n, k);
    }

    private static void solution(int n, int k) {
        int min = Integer.MAX_VALUE;
        int[] prev = new int[LIMIT + 1];
        Arrays.fill(prev, -1);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {n, 0});
        prev[n] = LIMIT;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int loc = curr[0];
            int time = curr[1];

            if (loc == k) {
                min = time;
                break;
            }

            int[] nexts = {loc - 1, loc + 1, loc * 2};
            for (int next : nexts) {
                if (next < 0 || next > LIMIT || prev[next] != -1) {
                    continue;
                }

                prev[next] = loc;
                queue.add(new int[] {next, time + 1});
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(min).append("\n");

        List<Integer> path = new ArrayList<>();
        int idx = k;
        while (true) {
            path.add(idx);
            if (idx == n) break;
            idx = prev[idx];
        }

        for (int i = path.size() - 1; i >= 0; i--) {
            result.append(path.get(i)).append(" ");
        }
        System.out.println(result);
    }
}