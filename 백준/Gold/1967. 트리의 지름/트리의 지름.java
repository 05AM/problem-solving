import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * < 문제 분석 >
 *     - 트리에서 각 노드로 연결되는 경로는 단 하나다.
 *     - 트리의 모든 노드는 이어져 있다.
 *     - 트리는 사이클이 없다.
 *     - 따라서 임의의 점에서 가장 먼 점은 지름의 양 끝점 중 하나다. (U - A - B - C - D - V)
 *     - 트리가 아닌 그래프에서는 각 노드로 연결되는 경로가 여러 개이므로 (사이클 등) 위 가정이 성립하지 않는다.
 * < 구현 방법 >
 *     - 임의의 점에서 가장 먼 노드를 먼저 찾는다. (지름의 양 끝점 중 하나)
 *     - 해당 점에서 가장 먼 노드와의 거리를 구한다. (= 트리의 지름)
 */

class Path {
    int node;
    int distance;

    public Path(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Edge {
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Main {

    static int endpoint = -1;
    static int max = Integer.MIN_VALUE;

    static int n;
    static List<Edge>[] tree;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        tree = new ArrayList[n + 1];
        isVisited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n - 1; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[n1].add(new Edge(n2, weight));
            tree[n2].add(new Edge(n1, weight));
        }

        // dfs O(n - 1)
        // 지름의 endpoint 찾기
        Arrays.fill(isVisited, false);
        isVisited[1] = true;
        dfs(1, 0);

        // 지름의 길이 구하기
        Arrays.fill(isVisited, false);
        isVisited[endpoint] = true;
        dfs(endpoint, 0);

        // dijkstra O(e * logv)
        // 지름의 endpoint 찾기
        dijkstra(1);

        // 지름의 길이 구하기
        dijkstra(endpoint);

        System.out.println(max);
    }

    private static void dfs(int start, int total) {
        boolean isEndNode = true;

        for (Edge edge : tree[start]) {
            if (!isVisited[edge.to]) {
                isEndNode = false;
                isVisited[edge.to] = true;
                dfs(edge.to, total + edge.weight);
            }
        }

        if (isEndNode) {
            if (total > max) {
                endpoint = start;
                max = total;
            }
        }
    }

    private static void dijkstra(int start) {
        int[] dist = new int[n + 1];
        PriorityQueue<Path> pq = new PriorityQueue<>(Comparator.<Path>comparingInt(p -> p.distance).reversed());
        pq.add(new Path(start, 0));

        while (!pq.isEmpty()) {
            Path path = pq.poll();

            for (Edge edge : tree[path.node]) {
                if (dist[edge.to] >= path.distance + edge.weight) {
                    dist[edge.to] = path.distance + edge.weight;
                    pq.add(new Path(edge.to, dist[edge.to]));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dist[i] > max) {
                max = dist[i];
                endpoint = i;
            }
        }
    }
}
