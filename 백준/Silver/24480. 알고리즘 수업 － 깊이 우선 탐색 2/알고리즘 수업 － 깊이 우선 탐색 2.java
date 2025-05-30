import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static int[] visited;
    static int order = 1;

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

        dfs(graph, r);

        for (int i = 1; i <= n; i++) {
            System.out.println(visited[i]);
        }
    }

    public static void dfs(ArrayList<Integer>[] graph, int r) {
        visited[r] = order++;

        for (int to : graph[r]) {
            if (visited[to] == 0) {
                dfs(graph, to);
            }
        }
    }
}