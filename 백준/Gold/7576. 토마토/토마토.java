import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();

        int[][] box = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                box[i][j] = in.nextInt();
            }
        }

        System.out.println(bfs(n, m, box));
    }

    private static int bfs(int n, int m, int[][] box) {
        int[][] visited = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 1) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        int result = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[1] + dx[i];
                int ny = now[0] + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }

                if (box[ny][nx] == 0) {
                    box[ny][nx] = 1;
                    visited[ny][nx] = visited[now[0]][now[1]] + 1;
                    result = Math.max(result, visited[ny][nx]);

                    queue.add(new int[] {ny, nx});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    return -1;
                }
            }
        }

        return result;
    }
}