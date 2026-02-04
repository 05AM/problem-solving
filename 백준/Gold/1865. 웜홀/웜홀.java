import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Edge {
    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            StringTokenizer input = new StringTokenizer(in.readLine());

            int n = Integer.parseInt(input.nextToken());
            int m = Integer.parseInt(input.nextToken());
            int w = Integer.parseInt(input.nextToken());

            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                input = new StringTokenizer(in.readLine());
                int v1 = Integer.parseInt(input.nextToken());
                int v2 = Integer.parseInt(input.nextToken());
                int cost = Integer.parseInt(input.nextToken());

                edges.add(new Edge(v1, v2, cost));
                edges.add(new Edge(v2, v1, cost));
            }

            for (int i = 0; i < w; i++) {
                input = new StringTokenizer(in.readLine());
                int v1 = Integer.parseInt(input.nextToken());
                int v2 = Integer.parseInt(input.nextToken());
                int cost = Integer.parseInt(input.nextToken());

                edges.add(new Edge(v1, v2, -cost));
            }

            int[] dists = new int[n + 1];
            Arrays.fill(dists, 0);

            boolean hasNegativeCycle = false;
            for (int i = 1; i <= n; i++) {
                boolean updated = false;
                for (Edge edge : edges) {
                    int dist = dists[edge.from] + edge.cost;

                    if (dists[edge.to] > dist) {
                        dists[edge.to] = dist;
                        updated = true;

                        if (i == n) {
                            hasNegativeCycle = true;
                            break;
                        }
                    }
                }

                if (!updated) {
                    break;
                }
                if (hasNegativeCycle) {
                    break;
                }
            }

            System.out.println(hasNegativeCycle ? "YES" : "NO");
        }
    }
}
