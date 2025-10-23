import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        long[][] dist = new long[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            int cost = in.nextInt();

            dist[from][to] = Math.min(dist[from][to], cost);
        }

        for (int through = 1; through <= n; through++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {
                    dist[start][end] = Math.min(dist[start][end], dist[start][through] + dist[through][end]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                long value = dist[i][j] != Integer.MAX_VALUE ? dist[i][j] : 0;
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
