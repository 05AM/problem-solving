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

class Route {
    int currentPosition;
    int distance;

    public Route(int currentPosition, int distance) {
        this.currentPosition = currentPosition;
        this.distance = distance;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int testCases = in.nextInt();

        while (testCases-- > 0) {
            int n = in.nextInt();           // 정점의 수
            int m = in.nextInt();           // 간선의 수
            int t = in.nextInt();           // 목적지 후보의 수

            int start = in.nextInt();       // 출발지
            int g = in.nextInt();           // 지나간 간선의 구성 정점 1
            int h = in.nextInt();           // 지나간 간선의 구성 정점 2

            // 그래프 초기화
            List<List<Edge>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int a = in.nextInt();       // 정점 1
                int b = in.nextInt();       // 정점 2
                int d = in.nextInt();       // 비용

                graph.get(a).add(new Edge(b, d));
                graph.get(b).add(new Edge(a, d));
            }

            List<Integer> availableTargets = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                int target = in.nextInt();

                int[] distanceStart = dijkstra(start, graph);
                int[] distanceG = dijkstra(g, graph);
                int[] distanceH = dijkstra(h, graph);

                int shortest = distanceStart[target];
                int viaGToH = distanceStart[g] + distanceG[h] + distanceH[target];
                int viaHToG = distanceStart[h] + distanceH[g] + distanceG[target];

                if (viaGToH == shortest || viaHToG == shortest) {
                    availableTargets.add(target);
                }
            }

            availableTargets.sort(Comparator.naturalOrder());

            for (Integer target : availableTargets) {
                System.out.print(target + " ");
            }
            System.out.println();
        }
    }

    private static int[] dijkstra(int start, List<List<Edge>> graph) {
        int[] distances = new int[graph.size() + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<Route> pq = new PriorityQueue<>(Comparator.comparingInt(r -> r.distance));
        pq.add(new Route(start, 0));

        while (!pq.isEmpty()) {
            Route route = pq.poll();

            if (route.distance > distances[route.currentPosition]) {
                continue;
            }

            for (Edge edge : graph.get(route.currentPosition)) {
                int next = edge.to;
                int newDistance = route.distance + edge.weight;

                if (newDistance < distances[next]) {
                    distances[next] = newDistance;
                    pq.offer(new Route(next, newDistance));
                }
            }
        }

        return distances;
    }
}