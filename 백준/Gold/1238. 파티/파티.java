import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static class Edge {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class Path {
        int node;
        int totalCost;

        public Path(int node, int totalCost) {
            this.node = node;
            this.totalCost = totalCost;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new InputStreamReader(System.in));

        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();

        // graph 초기화
        List<Edge>[] graph = new ArrayList[n + 1];           // 나로부터 갈 수 있는 곳
        List<Edge>[] graphReversed = new ArrayList[n + 1];   // 나에게로 올 수 있는 곳
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
            graphReversed[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            int cost = in.nextInt();

            graph[from].add(new Edge(to, cost));
            graphReversed[to].add(new Edge(from, cost));
        }

        // 최장거리 찾기
        System.out.println(solution(n, m, x, graph, graphReversed));
    }

    private static int solution(int n, int m, int x, List<Edge>[] graph, List<Edge>[] graphReversed) {
        // 각 n에서 x로 가는 최단거리
        int[] distToX = dijikstra(n, x, graphReversed);

        // x에서 각 마을로 가는 최단거리
        int[] distFromX = dijikstra(n, x, graph);

        int max = Integer.MIN_VALUE;
        for (int j = 1; j <= n; j++) {
            max = Math.max(max, distToX[j] + distFromX[j]);
        }

        return max;
    }

    private static int[] dijikstra(int n, int x, List<Edge>[] graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Path> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.totalCost));
        pq.add(new Path(x, 0));
        dist[x] = 0;

        while (!pq.isEmpty()) {
            Path curr = pq.poll();
            int node = curr.node;
            int totalCost = curr.totalCost;

            if (totalCost > dist[node]) {
                continue;
            }

            for (Edge edge : graph[node]) {
                int newCost = totalCost + edge.cost;

                if (newCost < dist[edge.to]) {
                    dist[edge.to] = newCost;
                    pq.add(new Path(edge.to, newCost));
                }
            }
        }

        return dist;
    }
}