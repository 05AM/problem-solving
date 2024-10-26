import java.util.Scanner;

public class Main {
    static int[][] cntWhite;
    static int[][] cntBlack;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        cntWhite = new int[n + 1][m + 1];
        cntBlack = new int[n + 1][m + 1];
        char[][] board = new char[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            char[] chars = in.next().toCharArray();

            for (int j = 0; j < m; j++) {
                board[i][j + 1] = chars[j];
            }
        }

        int result = solution(n, m, k, board);
        System.out.println(result);
    }

    private static int solution(int n, int m, int k, char[][] board) {
        int min = Integer.MAX_VALUE;

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= m; col++) {
                cntWhite[row][col] = cntWhite[row - 1][col] + cntWhite[row][col - 1] - cntWhite[row - 1][col - 1];
                cntBlack[row][col] = cntBlack[row - 1][col] + cntBlack[row][col - 1] - cntBlack[row - 1][col - 1];

                boolean isWhitePattern = (row + col) % 2 == 0;

                if (isWhitePattern) {
                    cntWhite[row][col] += (board[row][col] == 'W') ? 0 : 1;
                    cntBlack[row][col] += (board[row][col] == 'B') ? 0 : 1;
                } else {
                    cntWhite[row][col] += (board[row][col] == 'W') ? 1 : 0;
                    cntBlack[row][col] += (board[row][col] == 'B') ? 1 : 0;
                }

                if (row >= k && col >= k) {
                    int resultWhite = cntWhite[row][col] - cntWhite[row][col - k] - cntWhite[row - k][col] + cntWhite[row - k][col - k];
                    int resultBlack = cntBlack[row][col] - cntBlack[row][col - k] - cntBlack[row - k][col] + cntBlack[row - k][col - k];

                    min = Math.min(min, resultWhite);
                    min = Math.min(min, resultBlack);
                }
            }
        }

        return min;
    }
}