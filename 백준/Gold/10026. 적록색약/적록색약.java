import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[n][n];
        int normal = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, map[i][j]);
                    normal++;
                }
            }
        }

        visited = new boolean[n][n];
        int weak = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfsWeak(i, j, map[i][j]);
                    weak++;
                }
            }
        }

        System.out.println(normal + " " + weak);
    }

    static void dfs(int x, int y, char color) {
        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (visited[nx][ny]) continue;
            if (map[nx][ny] != color) continue;

            dfs(nx, ny, color);
        }
    }

    static void dfsWeak(int x, int y, char color) {
        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (visited[nx][ny]) continue;

            if (color == 'R' || color == 'G') {
                if (map[nx][ny] == 'R' || map[nx][ny] == 'G') {
                    dfsWeak(nx, ny, color);
                }
            } else {
                if (map[nx][ny] == color) {
                    dfsWeak(nx, ny, color);
                }
            }
        }
    }
}
