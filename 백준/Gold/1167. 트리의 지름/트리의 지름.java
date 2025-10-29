import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * < 가중치가 있음에도 BFS 사용 가능한 이유 >
 * 일반적으로 가중치가 있는 그래프에서 BFS를 사용하면, 처음 초기화된 거리가 최대/최소인지 알 수 없으므로
 * 방문 여부 배열 등을 사용하지 못하고, 완전 탐색이 되어버린다. 시간 복잡도 = O(2^n)
 * 하지만 트리는 두 정점을 잇는 경로가 하나라는 것이 보장되고, 사이클이 없기 때문에 처음에 초기화한 거리가 최적값임을 보장할 수 있다.
 * 따라서 가중치가 있는 트리는 BFS를 써도 성능이 보장된다.
 *
 * < DFS를 잘 사용하지 않는 이유 >
 * 스택 오버플로우가 발생할 가능성이 있기 때문에 BFS 사용이 가능하면 BFS를 사용하여 구현하는 것이 안정적이다.
 */

class Edge {
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Main {

    static int n;
    static List<Edge>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        tree = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            int v1 = Integer.parseInt(st.nextToken());

            while (true) {
                int v2 = Integer.parseInt(st.nextToken());

                if (v2 == -1) {
                    break;
                }

                int weight = Integer.parseInt(st.nextToken());
                tree[v1].add(new Edge(v2, weight));
            }
        }

        // 지름의 endpoint 찾기
        Result result1 = farthestFrom(1);
        // 지름의 길이 구하기
        Result result2 = farthestFrom(result1.endpoint);

        System.out.println(result2.distance);
    }

    static class Result {
        int endpoint;
        int distance;

        public Result(int endpoint, int distance) {
            this.endpoint = endpoint;
            this.distance = distance;
        }
    }

    private static Result farthestFrom(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[start] = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        int farNode = start;
        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (dist[curr] > dist[farNode]) {
                farNode = curr;
            }

            for (Edge edge : tree[curr]) {
                if (dist[edge.to] == -1) {
                    dist[edge.to] = dist[curr] + edge.weight;
                    queue.offer(edge.to);
                }
            }
        }

        return new Result(farNode, dist[farNode]);
    }
}
