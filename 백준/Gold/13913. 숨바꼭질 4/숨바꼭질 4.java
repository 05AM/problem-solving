import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 최단거리 + 경로
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
        int[] dist = new int[LIMIT + 1];
        int[] prev = new int[LIMIT + 1];
        Arrays.fill(dist, -1);
        Arrays.fill(prev, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(n);
        dist[n] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (curr == k) {
                break;
            }

            int[] nexts = {curr - 1, curr + 1, curr * 2};
            for (int next : nexts) {
                if (next < 0 || next > LIMIT || dist[next] != -1) {
                    continue;
                }

                prev[next] = curr;
                dist[next] = dist[curr] + 1;
                queue.add(next);
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(dist[k]).append("\n");

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = k; i != -1; i = prev[i]) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }

        System.out.println(result);
    }
}

