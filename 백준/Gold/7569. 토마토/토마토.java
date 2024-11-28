import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final int[] dx = {0, 1, 0, -1, 0, 0};
    private static final int[] dy = {1, 0, -1, 0, 0, 0};
    private static final int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();
        int h = in.nextInt();

        int[][][] box = new int[n][m][h];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    box[j][k][i] = in.nextInt();
                }
            }
        }

        System.out.println(bfs(n, m, h, box));
    }

    private static int bfs(int n, int m, int h, int[][][] box) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < h; k++) {
                    if (box[i][j][k] == 1) {
                        queue.add(new int[] {j, i, k});
                    }
                }
            }
        }

        int result = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int z = now[2];

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || nz < 0 || nz >= h) {
                    continue;
                }

                if (box[ny][nx][nz] == 0) {
                    box[ny][nx][nz] = box[y][x][z] + 1;
                    result = Math.max(result, box[ny][nx][nz]);
                    queue.add(new int[] {nx, ny, nz});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < h; k++) {
                    if (box[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }

        return result == 0 ? result : result - 1;
    }
}