import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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
        int distance;

        public Path(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());

        List<Edge>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, cost));
        }

        st = new StringTokenizer(in.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 다익스트라로 최소 거리 구하면서, 경로 기록하기
        long[] dist = new long[n + 1];
        int[] prev = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[start] = 0;

        PriorityQueue<Path> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.distance));
        pq.add(new Path(start, 0));

        while (!pq.isEmpty()) {
            Path path = pq.poll();

            if (path.distance > dist[path.node]) {
                continue;
            }

            for (Edge edge : graph[path.node]) {
                int newDist = path.distance + edge.cost;

                if (newDist < dist[edge.to]) {
                    dist[edge.to] = newDist;
                    prev[edge.to] = path.node;
                    pq.add(new Path(edge.to, newDist));
                }
            }
        }

        // 최소 비용
        System.out.println(dist[end]);

        // 경로
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = end; i != -1; i = prev[i]) {
            stack.push(i);
        }

        // 경로 포함 도시 개수
        System.out.println(stack.size());

        // 경로
        stack.stream()
            .map(i -> i + " ")
            .forEach(System.out::print);
    }
}