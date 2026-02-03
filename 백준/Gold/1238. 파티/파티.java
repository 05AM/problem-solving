import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * [ 오답 노트 ]
 * - 다익스트라: 시작점 x로 부터 다른 노드까지의 최단 거리
 * - 그래프의 방향을 뒤집으면, 다른 노드들로부터 x까지의 최단 거리
 */

class Node {
    int to;
    int cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

class Path {
    int loc;
    int dist;

    public Path(int loc, int dist) {
        this.loc = loc;
        this.dist = dist;
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

        int[] distFromX = dijkstra(x, graph);
        int[] distToX = dijkstra(x, reverseGraph);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, distToX[i] + distFromX[i]);
        }

        System.out.println(max);
    }

    private static int[] dijkstra(int start, ArrayList<Node>[] graph) {
        int n = graph.length;
        int[] dists = new int[n];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[start] = 0;

        PriorityQueue<Path> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.dist));
        pq.offer(new Path(start, 0));

        while (!pq.isEmpty()) {
            Path curr = pq.poll();

            if (curr.dist > dists[curr.loc]) {
                continue;
            }

            for (Node node : graph[curr.loc]) {
                int newDist = curr.dist + node.cost;

                if (newDist < dists[node.to]) {
                    dists[node.to] = newDist;
                    pq.offer(new Path(node.to, newDist));
                }
            }
        }

        return dists;
    }
}
