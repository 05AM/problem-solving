import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static final int LOC = 9;
    private static final int BLANK = 0;
    private static final int[] dx = new int[] {0, -1, 0, 1};
    private static final int[] dy = new int[] {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] map = new int[n][n];
        int row = -1;
        int col = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = in.nextInt();

                if (map[i][j] == LOC) {
                    row = i;
                    col = j;
                }
            }
        }

        System.out.println(solution(n, map, row, col));
    }

    private static int solution(int n, int[][] map, int initialRow, int initialCol) {
        int answer = 0;
        int size = 2;
        int eaten = 0;
        map[initialRow][initialCol] = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        int[] loc = new int[] {initialRow, initialCol, 0};  // row, col, distance

        boolean canMove = true;
        while (canMove) {
            canMove = false;
            int newRow = Integer.MAX_VALUE;
            int newCol = Integer.MAX_VALUE;
            int newDist = Integer.MAX_VALUE;

            boolean[][] isVisited = new boolean[n][n];
            isVisited[loc[0]][loc[1]] = true;
            map[loc[0]][loc[1]] = 0;
            queue.add(loc);

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                int distance = curr[2];

                if (distance > newDist) {
                    break;
                }

                // 먹을 수 있으면,
                if (map[row][col] != BLANK && map[row][col] < size) {
                    canMove = true;

                    if (row < newRow || (row == newRow && col < newCol)) {
                        newRow = row;
                        newCol = col;
                        newDist = distance;
                    }
                }

                for (int i = 0; i < 4; i++) {
                    int nextRow = row + dy[i];
                    int nextCol = col + dx[i];

                    if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
                        continue;
                    }

                    if (!isVisited[nextRow][nextCol] && map[nextRow][nextCol] <= size) {
                        queue.add(new int[] {nextRow, nextCol, distance + 1});
                        isVisited[nextRow][nextCol] = true;
                    }
                }
            }

            if (canMove) {
                // 사이즈 조정
                eaten++;
                if (size == eaten) {
                    size++;
                    eaten = 0;
                }

                loc = new int[] {newRow, newCol, 0};
                answer += newDist;
                queue.clear();
            }
        }

        return answer;
    }
}