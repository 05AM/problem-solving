import java.util.Scanner;

public class Main {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static int[][] map;
    private static int[][] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();

        map = new int[m][n];
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = in.nextInt();
                dp[i][j] = -1;
            }
        }

        System.out.println(findAvailablePathCnt(0, 0));
    }

    private static int findAvailablePathCnt(int row, int col) {
        int mapRow = map.length;
        int mapCol = map[0].length;

        if (row == mapRow - 1 && col == mapCol - 1) {
            return 1;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        dp[row][col] = 0;

        for (int[] direction : DIRECTIONS) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if (nextRow >= 0 && nextRow < mapRow && nextCol >= 0 && nextCol < mapCol) {
                if (map[nextRow][nextCol] < map[row][col]) {
                    dp[row][col] += findAvailablePathCnt(nextRow, nextCol);
                }
            }
        }

        return dp[row][col];
    }
}