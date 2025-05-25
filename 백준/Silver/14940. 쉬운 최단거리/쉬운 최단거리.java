import java.io.*;
import java.util.*;

public class Main {

    static int[] dRow = {0, 1, 0, -1};
    static int[] dCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        int[][] map = new int[n][m];
        int[][] dist = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        int startRow = -1, startCol = -1;

        for (int i = 0; i < n; i++) {
            String[] parts = in.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(parts[j]);
                if (map[i][j] == 2) {
                    startRow = i;
                    startCol = j;
                }
                dist[i][j] = -1;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;
        dist[startRow][startCol] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            for (int d = 0; d < 4; d++) {
                int newRow = row + dRow[d];
                int newCol = col + dCol[d];

                if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m)
                    continue;

                if (!visited[newRow][newCol] && map[newRow][newCol] == 1) {
                    visited[newRow][newCol] = true;
                    dist[newRow][newCol] = dist[row][col] + 1;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    dist[i][j] = 0;
                }
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
