import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] moveRow = {0, 1, 0, -1};
    static int[] moveCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        String[] firstLine = in.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        // 결과 구하기
        int[][] dist = solution(n, m, map);

        // 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] solution(int n, int m, int[][] map) {
        int targetRow = -1;
        int targetCol = -1;
        int[][] dist = new int[n][m];

        // 목표지점 찾으며 정해진 예정 결과 값 채우기
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                int type = map[row][col];

                if (type == 0) {
                    dist[row][col] = 0;
                } else if (type == 1) {
                    dist[row][col] = -1;
                } else if (type == 2) {
                    targetRow = row;
                    targetCol = col;
                }
            }
        }

        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        visited[targetRow][targetCol] = true;
        queue.add(new int[] {targetRow, targetCol, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            // 이동
            for (int i = 0; i < 4; i++) {
                int nextRow = row + moveRow[i];
                int nextCol = col + moveCol[i];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m || visited[nextRow][nextCol]) {
                    continue;
                }

                if (map[nextRow][nextCol] == 1) {
                    dist[nextRow][nextCol] = dist[row][col] + 1;
                    visited[nextRow][nextCol] = true;
                    queue.add(new int[] {nextRow, nextCol});
                }
            }
        }

        return dist;
    }
}