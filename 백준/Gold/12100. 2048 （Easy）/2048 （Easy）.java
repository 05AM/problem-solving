import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int max = Integer.MIN_VALUE;
    private static int n;
    private static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0);
        System.out.println(max);
    }

    private static void solution(int level) {
        if (level == 5) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    max = Math.max(max, board[r][c]);
                }
            }
            return;
        }

        int[][] base = deepCopy(board);

        for (int dir = 0; dir < 4; dir++) {
            board = rotateTimes(base, dir);
            simulateUp();
            solution(level + 1);
        }

        board = base;
    }

    private static void simulateUp() {
        for (int col = 0; col < n; col++) {
            int[] line = new int[n];

            // 압축 (0 제거)
            int idx = 0;
            for (int row = 0; row < n; row++) {
                if (board[row][col] != 0) {
                    line[idx++] = board[row][col];
                }
            }

            // 합치기
            for (int i = 0; i < n - 1; i++) {
                if (line[i] == 0) {
                    continue;
                }

                if (line[i] == line[i + 1]) {
                    line[i] *= 2;
                    line[i + 1] = 0;
                    i++;
                }
            }

            // 열 전체 0으로 초기화
            for (int row = 0; row < n; row++) {
                board[row][col] = 0;
            }

            // 다시 압축하면서 위부터 채우기
            idx = 0;
            for (int i = 0; i < n; i++) {
                if (line[i] != 0) {
                    board[idx++][col] = line[i];
                }
            }
        }
    }

    private static int[][] rotateTimes(int[][] src, int times) {
        int[][] result = deepCopy(src);
        for (int i = 0; i < times; i++) {
            result = rotateRight(result);
        }
        return result;
    }

    private static int[][] rotateRight(int[][] b) {
        int[][] rotated = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                rotated[col][n - 1 - row] = b[row][col];
            }
        }
        return rotated;
    }

    private static int[][] deepCopy(int[][] original) {
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            copy[i] = Arrays.copyOf(original[i], n);
        }
        return copy;
    }
}
