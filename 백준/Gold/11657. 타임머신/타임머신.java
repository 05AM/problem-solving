import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Edge {
    int from;
    int to;
    int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

public class Main {
    private static final int INF = Integer.MAX_VALUE;
    private static final String NOT_FOUND = "-1";
    private static final int START = 1;

    private static int v;
    private static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        String[] input = in.readLine().split(" ");
        v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);

        List<Edge> graph = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            input = in.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            graph.add(new Edge(from, to, weight));
        }

        // 결과 출력
        if (!bellmanFord(v, START, graph)) {
            System.out.println(NOT_FOUND);
        } else {
            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= v; i++) {
                if (i == START) {
                    continue;
                }
                result.append(dist[i] != INF ? dist[i] : NOT_FOUND).append("\n");
            }

            System.out.println(result);
        }

        in.close();
    }

    private static boolean bellmanFord(int v, int start, List<Edge> graph) {
        dist = new long[v + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        // 모든 간선을 v번 돌며 최단 거리 갱신
        for (int i = 1; i <= v; i++) {
            boolean updated = false;

            for (Edge edge : graph) {
                if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.weight) {
                    dist[edge.to] = dist[edge.from] + edge.weight;
                    updated = true;
                }
            }

            // v번째에 갱신되면 음수 사이클 존재
            if (i == v && updated) {
                return false;
            }
        }

        return true;
    }
}
