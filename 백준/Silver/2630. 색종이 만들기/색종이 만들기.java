import java.util.Scanner;

public class Main {
    private static int[][] paper;
    private static int whiteCnt = 0;
    private static int blueCnt = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                paper[i][j] = in.nextInt();
            }
        }

        solution(n, 0, 0);

        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }

    private static void solution(int n, int startRow, int startCol) {
        boolean isOneColor = true;
        int currentColor = paper[startRow][startCol];

        for (int i = startRow; i < startRow + n; i++) {
            for (int j = startCol; j < startCol + n; j++) {
                int now = paper[i][j];

                if (now == currentColor) {
                    currentColor = now;
                } else {
                    isOneColor = false;
                    break;
                }
            }

            if (!isOneColor) {
                break;
            }
        }

        if (isOneColor) {
            whiteCnt += paper[startRow][startCol] == 0 ? 1 : 0;
            blueCnt += paper[startRow][startCol] == 1 ? 1 : 0;
        } else {
            for (int i = startRow; i < startRow + n; i += n / 2) {
                for (int j = startCol; j < startCol + n; j += n / 2) {
                    solution(n / 2, i, j);
                }
            }
        }
    }
}