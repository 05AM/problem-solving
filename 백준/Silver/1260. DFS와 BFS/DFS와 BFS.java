import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static boolean[] isVisited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int v = in.nextInt();

        isVisited = new boolean[n + 1];

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
            graph[i].sort(Comparator.naturalOrder());
        }

        dfs(graph, v);
        System.out.println();
        bfs(graph, v);
    }

    private static void dfs(ArrayList<Integer>[] graph, int v) {
        System.out.print(v + " ");
        isVisited[v] = true;

        for (int node : graph[v]) {
            if (!isVisited[node]) {
                dfs(graph, node);
            }
        }
    }

    private static void bfs(ArrayList<Integer>[] graph, int v) {
        Arrays.fill(isVisited, false);

        isVisited[v] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);

        while (!queue.isEmpty()) {
            int from = queue.poll();
            System.out.print(from + " ");

            for (int to : graph[from]) {
                if (!isVisited[to]) {
                    isVisited[to] = true;
                    queue.offer(to);
                }
            }
        }
    }
}