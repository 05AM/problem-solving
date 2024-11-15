import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static int[] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int r = in.nextInt();

        visited = new int[n + 1];

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = in.nextInt();
            int to = in.nextInt();

            graph[from].add(to);
            graph[to].add(from);
        }

        for (int i = 1; i <= n; i++) {
            graph[i].sort(Comparator.reverseOrder());
        }

        bfs(graph, r);

        for (int i = 1; i <= n; i++) {
            System.out.println(visited[i]);
        }
    }

    public static void bfs(ArrayList<Integer>[] graph, int r) {
        int order = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(r);
        visited[r] = order++;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int to : graph[node]) {
                if (visited[to] == 0) {
                    visited[to] = order++;
                    queue.offer(to);
                }
            }
        }
    }
}