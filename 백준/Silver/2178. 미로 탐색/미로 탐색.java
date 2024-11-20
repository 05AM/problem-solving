import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[][] miro = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = in.next();
            for (int j = 0; j < m; j++) {
                miro[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }

        System.out.println(bfs(n, m, miro));

        in.close();
    }

    private static int bfs(int n, int m, int[][] miro) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            if (x == m - 1 && y == n - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }

                if (miro[ny][nx] == 1) {
                    miro[ny][nx] = miro[y][x] + 1;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }

        return miro[n - 1][m - 1];
    }
}