import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private static boolean[][] isVisited;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int count;
    static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        map = new int[n][n];
        isVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = in.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }

        solution();
    }

    private static void solution() {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !isVisited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }

        result.sort(Comparator.naturalOrder());
        System.out.println(result.size());
        for (int cnt : result) {
            System.out.println(cnt);
        }
    }

    private static void dfs(int i, int j) {
        isVisited[i][j] = true;
        count++;

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x < 0 || x >= n || y < 0 || y >= n) {
                continue;
            }

            if (map[x][y] == 1 && !isVisited[x][y]) {
                dfs(x, y);
            }
        }
    }
}