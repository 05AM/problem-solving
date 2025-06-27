import java.util.Scanner;

public class Main {

    private static final int[] dx = new int[] {1, 0, -1, 0};
    private static final int[] dy = new int[] {0, 1, 0, -1};

    private static int max = Integer.MIN_VALUE;
    private static int n;
    private static int m;
    private static int[][] nums;
    private static boolean[][] isVisited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        nums = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = in.nextInt();
            }
        }

        solution();
        System.out.println(max);
    }

    private static void solution() {
        // dfs로 4칸 전진
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                isVisited[i][j] = true;
                dfs(i, j, nums[i][j], 1);
                isVisited[i][j] = false;
            }
        }

        // ㅗ 모양만 따로
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                checkExtraShapes(i, j);
            }
        }
    }

    private static void dfs(int i, int j, int sum, int depth) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nextRow = i + dx[k];
            int nextCol = j + dy[k];

            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m || isVisited[nextRow][nextCol]) {
                continue;
            }

            isVisited[nextRow][nextCol] = true;
            dfs(nextRow, nextCol, sum + nums[nextRow][nextCol], depth + 1);
            isVisited[nextRow][nextCol] = false;
        }
    }

    private static void checkExtraShapes(int i, int j) {
        int wing = 0;
        int min = Integer.MAX_VALUE;
        int sum = nums[i][j];

        for (int k = 0; k < 4; k++) {
            int nextRow = i + dx[k];
            int nextCol = j + dy[k];

            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) {
                continue;
            }

            wing++;
            sum += nums[nextRow][nextCol];
            min = Math.min(min, nums[nextRow][nextCol]);
        }

        if (wing == 4) {
            sum -= min;
        }

        if (wing >= 3) {
            max = Math.max(max, sum);
        }
    }
}