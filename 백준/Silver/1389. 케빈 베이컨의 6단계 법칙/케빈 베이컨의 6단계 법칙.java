import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = in.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        // 그래프 연결
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int[] input = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            graph.get(input[0]).add(input[1]);
            graph.get(input[1]).add(input[0]);
        }

        // 케빈 베이컨 수 구하기
        System.out.println(solution(n, graph));
    }

    private static int solution(int n, List<List<Integer>> graph) {
        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            boolean[] isVisited = new boolean[n + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            isVisited[i] = true;

            while (!queue.isEmpty()) {
                int now = queue.poll();

                for (int next : graph.get(now)) {
                    if (!isVisited[next]) {
                        queue.add(next);
                        dist[i][next] = dist[i][now] + 1;
                        isVisited[next] = true;
                    }
                }
            }
        }

        // 답 구하기
        int index = 1;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += dist[i][j];
            }

            if (min > sum) {
                index = i;
                min = sum;
            }
        }

        return index;
    }
}