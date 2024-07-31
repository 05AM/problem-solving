import java.util.Scanner;

class Main {
    static int n, m;
    static char[][] board;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        board = new char[n][m];

        for (int row = 0; row < n; row++) {
            board[row] = in.next().toCharArray();
        }

        solution();
    }

    private static void solution() {
        int answer = Integer.MAX_VALUE;

        for (int row = 0; row <= (n - 8); row++) {
            for (int col = 0; col <= (m - 8); col++) {
                answer = Math.min(answer, changesToBeChessBoard(row, col));
            }
        }

        System.out.println(answer);
    }

    private static int changesToBeChessBoard(int startRow, int startCol) {
        int changes1 = 0;
        int changes2 = 0;

        for (int row = startRow; row < startRow + 8; row++) {
            for (int col = startCol; col < startCol + 8; col++) {
                char currentColor = board[row][col];

                if ((row + col) % 2 == 0) {
                    if (currentColor != 'W') {
                        changes1++;
                    }
                    if (currentColor != 'B') {
                        changes2++;
                    }
                } else {
                    if (currentColor != 'B') {
                        changes1++;
                    }
                    if (currentColor != 'W') {
                        changes2++;
                    }
                }
            }
        }

        return Math.min(changes1, changes2);
    }
}