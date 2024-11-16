import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static boolean[] visited;
    private static final int START = 1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        visited = new boolean[n + 1];

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

        System.out.println(bfs(graph));
    }

    public static int bfs(ArrayList<Integer>[] graph) {
        int cnt = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(START);
        visited[START] = true;

        while (!queue.isEmpty()) {
            int from = queue.poll();

            for (int to : graph[from]) {
                if (!visited[to]) {
                    visited[to] = true;
                    queue.offer(to);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}