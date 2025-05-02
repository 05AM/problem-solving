import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static boolean[] isVisited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        isVisited = new boolean[n + 1];

        // 무방향 그래프
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int v1 = in.nextInt();
            int v2 = in.nextInt();

            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        System.out.println(solution(n, m, graph));
    }

    private static int solution(int n, int m, List<List<Integer>> graph) {
        int trial = 0;

        for (int i = 1, start; i <= n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(i, graph);
                trial++;
            }
        }

        return trial;
    }

    private static void dfs(int start, List<List<Integer>> graph) {
        for (int i : graph.get(start)) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(i, graph);
            }
        }
    }
}