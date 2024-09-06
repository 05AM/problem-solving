import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static final int N = 9;
    static int[][] board = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        if (solution()) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private static boolean solution() {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (board[row][col] == 0) {
                    for (int n = 1; n <= N; n++) {
                        if (isValid(row, col, n)) {
                            board[row][col] = n;

                            if (solution()) {
                                return true;
                            }

                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int row, int col, int num) {
        // 열 체크
        for (int i = 0; i < N; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // 행 체크
        for (int i = 0; i < N; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // 3x3 영역 체크
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}