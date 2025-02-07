import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = in.readLine().split(" ");
        int v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);

        List<Edge> graph = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            input = in.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            graph.add(new Edge(from, to, weight));
        }

        out.write(bellmanFord(1, v, graph));
        out.flush();
        out.close();
        in.close();
    }

    private static String bellmanFord(int start, int v, List<Edge> graph) {
        long[] dist = new long[v + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        for (int i = 0; i < v - 1; i++) {
            for (Edge edge : graph) {
                if (dist[edge.from] != INF
                        && dist[edge.from] + edge.weight < dist[edge.to]) {
                    dist[edge.to] = dist[edge.from] + edge.weight;
                }
            }
        }

        boolean isMinusCycle = false;
        for (Edge edge : graph) {
            if (dist[edge.from] != INF && dist[edge.from] + edge.weight < dist[edge.to]) {
                return NOT_FOUND;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if (i == start) {
                continue;
            }
            result.append(dist[i] != Integer.MAX_VALUE ? dist[i] : NOT_FOUND).append("\n");
        }

        return result.toString();
    }
}