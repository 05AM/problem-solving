import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Edge {
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Main {

    static int endpoint;
    static int max = Integer.MIN_VALUE;

    static int n;
    static List<Edge>[] tree;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        tree = new ArrayList[n + 1];
        isVisited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n - 1; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[n1].add(new Edge(n2, weight));
            tree[n2].add(new Edge(n1, weight));
        }

        // endpoint 찾기
        Arrays.fill(isVisited, false);
        isVisited[1] = true;
        dfs(1, 0);

        Arrays.fill(isVisited, false);
        isVisited[endpoint] = true;
        dfs(endpoint, 0);

        System.out.println(max);
    }

    private static void dfs(int start, int total) {
        boolean isEndNode = true;

        for (Edge edge : tree[start]) {
            if (!isVisited[edge.to]) {
                isEndNode = false;
                isVisited[edge.to] = true;
                dfs(edge.to, total + edge.weight);
            }
        }

        if (isEndNode) {
            if (total > max) {
                endpoint = start;
                max = total;
            }
        }
    }
}