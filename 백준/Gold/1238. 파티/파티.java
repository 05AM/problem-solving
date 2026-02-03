import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int to;
    int cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

public class Main {

    private static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(input.nextToken());
        int m = Integer.parseInt(input.nextToken());
        int x = Integer.parseInt(input.nextToken());

        ArrayList<Node>[] graph = new ArrayList[n + 1];
        ArrayList<Node>[] reverseGraph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            input = new StringTokenizer(in.readLine());

            int from = Integer.parseInt(input.nextToken());
            int to = Integer.parseInt(input.nextToken());
            int cost = Integer.parseInt(input.nextToken());

            graph[from].add(new Node(to, cost));
            reverseGraph[to].add(new Node(from, cost));
        }

        int[] distToX = dijkstra(x, reverseGraph);
        int[] distFromX = dijkstra(x, graph);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, distToX[i] + distFromX[i]);
        }

        System.out.println(max);
    }

    private static int[] dijkstra(int start, ArrayList<Node>[] graph) {
        int n = graph.length - 1;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.to;
            int nowCost = cur.cost;

            if (nowCost > dist[now]) continue;

            for (Node edge : graph[now]) {
                int next = edge.to;
                int nextCost = nowCost + edge.cost;

                if (nextCost < dist[next]) {
                    dist[next] = nextCost;
                    pq.offer(new Node(next, nextCost));
                }
            }
        }

        return dist;
    }
}
