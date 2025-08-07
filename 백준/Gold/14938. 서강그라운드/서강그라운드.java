import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static class Edge {
        int to;
        int dist;

        public Edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    static class Path {
        int to;
        int totalDist;

        public Path(int to, int totalDist) {
            this.to = to;
            this.totalDist = totalDist;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new InputStreamReader(System.in));

        int n = in.nextInt();   // 지역 개수
        int m = in.nextInt();   // 수색 범위
        int r = in.nextInt();   // 길의 개수

        int[] items = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            items[i] = in.nextInt();
        }

        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= r; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int l = in.nextInt();

            graph[a].add(new Edge(b, l));
            graph[b].add(new Edge(a, l));
        }

        System.out.println(solution(n, m, items, graph));
    }

    private static int solution(int n, int m, int[] items, ArrayList<Edge>[] graph) {
        int answer = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            PriorityQueue<Path> pq = new PriorityQueue<>(Comparator.comparing((Path path) -> path.totalDist));
            int[] distances = new int[n + 1];
            Arrays.fill(distances, Integer.MAX_VALUE);

            pq.add(new Path(i, 0));

            while (!pq.isEmpty()) {
                Path current = pq.poll();

                if (current.totalDist > distances[current.to]) {
                    continue;
                }
                distances[current.to] = current.totalDist;

                for (Edge edge : graph[current.to]) {
                    int newDist = current.totalDist + edge.dist;

                    if (newDist <= m && newDist < distances[edge.to]) {
                        pq.add(new Path(edge.to, newDist));
                    }
                }
            }

            int totalItemCnt = 0;
            for (int j = 1; j <= n; j++) {
                if (distances[j] != Integer.MIN_VALUE && distances[j] <= m) {
                    totalItemCnt += items[j];
                }
            }

            answer = Math.max(answer, totalItemCnt);
        }

        return answer;
    }
}