import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static final int SHARK = 9;
    static final int[] dx = {0, -1, 0, 1};
    static final int[] dy = {-1, 0, 1, 0};

    static int n;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        map = new int[n][n];

        int sharkRow = 0, sharkCol = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = in.nextInt();
                if (map[i][j] == SHARK) {
                    sharkRow = i;
                    sharkCol = j;
                    map[i][j] = 0;
                }
            }
        }

        System.out.println(simulate(sharkRow, sharkCol));
    }

    private static int simulate(int sharkRow, int sharkCol) {
        int sharkSize = 2;   // 상어 초기 크기
        int eatenCount = 0;  // 먹은 물고기 수
        int totalTime = 0;   // 총 이동 시간

        int currentRow = sharkRow;
        int currentCol = sharkCol;

        while (true) {
            int[] target = bfs(currentRow, currentCol, sharkSize);
            if (target == null) break; // 더 이상 먹을 물고기 없음

            int targetRow = target[0];
            int targetCol = target[1];
            int distance = target[2];

            totalTime += distance;
            eatenCount++;

            // 이동 후 상태 갱신
            map[targetRow][targetCol] = 0;
            currentRow = targetRow;
            currentCol = targetCol;

            if (eatenCount == sharkSize) {
                sharkSize++;
                eatenCount = 0;
            }
        }

        return totalTime;
    }

    private static int[] bfs(int startRow, int startCol, int sharkSize) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        queue.add(new int[]{startRow, startCol, 0});
        visited[startRow][startCol] = true;

        int minDistance = Integer.MAX_VALUE;
        int targetRow = Integer.MAX_VALUE;
        int targetCol = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int distance = current[2];

            // 이미 더 먼 거리면 중단
            if (distance > minDistance) break;

            // 먹을 수 있는 물고기 발견
            if (map[row][col] != 0 && map[row][col] < sharkSize) {
                if (row < targetRow || (row == targetRow && col < targetCol)) {
                    minDistance = distance;
                    targetRow = row;
                    targetCol = col;
                }
                continue;
            }

            // 아직 목표 거리 미확정이면 계속 확장
            for (int dir = 0; dir < 4; dir++) {
                int nextRow = row + dy[dir];
                int nextCol = col + dx[dir];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) continue;
                if (visited[nextRow][nextCol]) continue;
                if (map[nextRow][nextCol] > sharkSize) continue;

                visited[nextRow][nextCol] = true;
                queue.add(new int[]{nextRow, nextCol, distance + 1});
            }
        }

        if (targetRow == Integer.MAX_VALUE) return null; // 먹을 수 있는 물고기 없음
        return new int[]{targetRow, targetCol, minDistance};
    }
}
