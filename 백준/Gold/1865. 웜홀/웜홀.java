import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int u;
        int v;
        int weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(in.readLine());
        while (tc-- != 0) {
            StringTokenizer input = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(input.nextToken());
            int m = Integer.parseInt(input.nextToken());
            int w = Integer.parseInt(input.nextToken());

            List<Edge> edges = new ArrayList<>();
            // 도로 간선 초기화
            for (int i = 0; i < m; i++) {
                input = new StringTokenizer(in.readLine());

                int u = Integer.parseInt(input.nextToken());
                int v = Integer.parseInt(input.nextToken());
                int weight = Integer.parseInt(input.nextToken());

                edges.add(new Edge(u, v, weight));
                edges.add(new Edge(v, u, weight));
            }

            // 웜홀 간선 초기화
            for (int i = 0; i < w; i++) {
                input = new StringTokenizer(in.readLine());

                int u = Integer.parseInt(input.nextToken());
                int v = Integer.parseInt(input.nextToken());
                int weight = Integer.parseInt(input.nextToken());

                edges.add(new Edge(u, v, -weight));
            }

            String answer = hasNegativeCycle(n, edges) ? "YES" : "NO";
            System.out.println(answer);
        }
    }

    private static boolean hasNegativeCycle(int n, List<Edge> edges) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, 0);

        for (int i = 1; i <= n - 1; i++) {
            for (Edge edge : edges) {
                if (dist[edge.v] > dist[edge.u] + edge.weight) {
                    dist[edge.v] = dist[edge.u] + edge.weight;
                }
            }
        }

        boolean hasNegativeCycle = false;
        for (Edge edge : edges) {
            if (dist[edge.v] > dist[edge.u] + edge.weight) {
                hasNegativeCycle = true;
                break;
            }
        }

        return hasNegativeCycle;
    }
}