import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String input = in.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        System.out.println(solution(n, m, grid));
    }

    private static int solution(int n, int m, int[][] grid) {
        int answer = 0;
        int cheezeCnt = 0;

        int[][] originGrid = new int[n][m];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 1) {
                    originGrid[row][col] = 1;
                    cheezeCnt++;
                }
            }
        }
        int[][] newGrid = new int[n][m];


        while (cheezeCnt != 0) {
            // 바깥 공기 마킹
            boolean[][] isOuter = new boolean[n][m];

            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[] {0, 0});
            isOuter[0][0] = true;

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                for (int i = 0; i < 4; i++) {
                    int nextRow = row + dx[i];
                    int nextCol = col + dy[i];

                    if (!isInRange(n, m, nextRow, nextCol)) {
                        continue;
                    }

                    if (originGrid[nextRow][nextCol] == 1 || isOuter[nextRow][nextCol]) {
                        continue;
                    }

                    queue.add(new int[] {nextRow, nextCol});
                    isOuter[nextRow][nextCol] = true;
                }
            }

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    // 치즈인 경우,
                    if (originGrid[row][col] == 1) {
                        int exposureCnt = getExposureCnt(n, m, row, col, isOuter);

                        if (exposureCnt >= 2) {
                            cheezeCnt--;
                        } else {
                            newGrid[row][col] = 1;
                        }
                    }
                }
            }

            // 초기화
            originGrid = newGrid;
            newGrid = new int[n][m];

            answer++;
        }

        return answer;
    }

    private static boolean isInRange(int n, int m, int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    private static int getExposureCnt(int n, int m, int row, int col, boolean[][] isOuter) {
        int exposureCnt = 0;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];

            if (!isInRange(n, m, nextRow, nextCol)) {
                continue;
            }

            if (isOuter[nextRow][nextCol]) {
                exposureCnt++;
            }
        }

        return exposureCnt;
    }
}