import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

    public class Main {

        static int v, e;
        static List<Edge>[] graph;

        static class Path {
            int node;
            int dist;

            public Path(int node, int dist) {
                this.node = node;
                this.dist = dist;
            }
        }

        static class Edge {
            int to;
            int cost;

            public Edge(int to, int cost) {
                this.to = to;
                this.cost = cost;
            }
        }

        public static void main(String[] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            // 도시의 개수 (1 ~ n)
            v = Integer.parseInt(in.readLine());

            // 버스의 개수
            e = Integer.parseInt(in.readLine());

            // 그래프 생성
            graph = new ArrayList[v + 1];
            for (int i = 0; i <= v; i++) {
                graph[i] = new ArrayList<>();
            }

            // 그래프 초기화
            for (int i = 0; i < e; i++) {
                String[] inputs = in.readLine().split(" ");
                int a = Integer.parseInt(inputs[0]);
                int b = Integer.parseInt(inputs[1]);
                int cost = Integer.parseInt(inputs[2]);

                graph[a].add(new Edge(b, cost));
            }

            String[] inputs = in.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);

            // 최소비용 && 비용 >= 0 => 다익스트라로 풀기
            int minCost = dijkstra(start, end);
            System.out.println(minCost);
        }

        private static int dijkstra(int start, int end) {
            int[] dist = new int[v + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            PriorityQueue<Path> pq = new PriorityQueue<>(Comparator.comparingInt(path -> path.dist));
            pq.add(new Path(start, 0));

            while (!pq.isEmpty()) {
                Path current = pq.poll();

                if (dist[current.node] < current.dist) {
                    continue;
                }

                for (Edge edge : graph[current.node]) {
                    int newDist = current.dist + edge.cost;

                    if (dist[edge.to] > newDist) {
                        dist[edge.to] = newDist;
                        pq.add(new Path(edge.to, newDist));
                    }
                }
            }

            return dist[end];
        }
    }