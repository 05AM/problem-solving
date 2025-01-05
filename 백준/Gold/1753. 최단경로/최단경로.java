import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge {
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

class Path {
    int idx;
    int dist;

    public Path(int idx, int dist) {
        this.idx = idx;
        this.dist = dist;
    }
}

class Main {

    static final String INFINITE = "INF";
    static List<Edge>[] graph;
    static int[] dist;
    static int start;

    public static void main(String[] args) {
        input();
        dijkstra(start);
        printShortestDistance();
    }

    private static void input() {
        Scanner in = new Scanner(System.in);

        int v = in.nextInt();
        int e = in.nextInt();
        start = in.nextInt();

        graph = new List[v + 1];
        dist = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= e; i++) {
            graph[in.nextInt()].add(new Edge(in.nextInt(), in.nextInt()));
        }
    }

    private static void dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Path> pq = new PriorityQueue<>(Comparator.comparingInt(path -> path.dist));
        pq.add(new Path(start, dist[start]));

        while (!pq.isEmpty()) {
            Path path = pq.poll();

            if (path.dist > dist[path.idx]) {
                continue;
            }

            for (Edge edge : graph[path.idx]) {
                int newDist = path.dist + edge.weight;

                if (newDist >= dist[edge.to]) {
                    continue;
                }

                dist[edge.to] = newDist;
                pq.add(new Path(edge.to, newDist));
            }
        }
    }

    private static void printShortestDistance() {
        for (int i = 1; i < dist.length; i++) {
            int result = dist[i];

            if (result != Integer.MAX_VALUE) {
                System.out.println(dist[i]);
            } else {
                System.out.println(INFINITE);
            }
        }
    }
}