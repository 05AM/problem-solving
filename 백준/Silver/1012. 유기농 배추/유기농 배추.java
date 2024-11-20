import java.util.Scanner;

public class Main {
    private static int[][] field;
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            m = in.nextInt();
            n = in.nextInt();
            int k = in.nextInt();

            field = new int[n][m];
            for (int j = 0; j < k; j++) {
                int x = in.nextInt();
                int y = in.nextInt();

                field[y][x] = 1;
            }

            int cnt = 0;
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    if (field[row][col] == 1) {
                        cnt++;
                        field[row][col] = -1;
                        dfs(row, col);
                    }
                }
            }

            System.out.println(cnt);
        }

        in.close();
    }

    private static void dfs(int row, int col) {
        for (int i = 0; i < 4; i++) {
            int x = col + dx[i];
            int y = row + dy[i];

            if (x < 0 || x >= m || y < 0 || y >= n) {
                continue;
            }

            if (field[y][x] == 1) {
                field[y][x] = -1;
                dfs(y, x);
            }
        }
    }
}