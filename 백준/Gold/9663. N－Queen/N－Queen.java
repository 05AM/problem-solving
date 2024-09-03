import java.util.Scanner;

public class Main {
    static int answer = 0;
    static boolean[][] board;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        board = new boolean[n][n];

        solution(0, n);
        System.out.println(answer);
    }

    private static void solution(int row, int n) {
        if (row == n) {
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n)) {
                board[row][col] = true;
                solution(row + 1, n);
                board[row][col] = false;
            }
        }
    }

    private static boolean isValid(int row, int col, int n) {
        // 같은 열에 퀸이 존재하는지 확인
        for (int i = 0; i < n; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // 오른쪽 대각선에 퀸이 존재하는지 확인
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }

        // 왼쪽 대각선에 퀸이 존재하는지 확인
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j]) {
                return false;
            }
        }

        return true;
    }
}