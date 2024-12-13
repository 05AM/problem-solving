import java.util.Scanner;

public class Main {
    private static int[][] paper;
    private static int[] results = new int[3];

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

        for (int result : results) {
            System.out.println(result);
        }
        in.close();
    }

    private static void solution(int n, int row, int col) {
        if (isAllSame(n, row, col)) {
            int value = paper[row][col];
            results[value + 1]++;
            return;
        }

        int newSize = n / 3;
        solution(newSize, row, col);
        solution(newSize, row + newSize, col);
        solution(newSize, row + 2 * newSize, col);

        solution(newSize, row, col + newSize);
        solution(newSize, row + newSize, col + newSize);
        solution(newSize, row + 2 * newSize, col + newSize);

        solution(newSize, row, col + 2 * newSize);
        solution(newSize, row + newSize, col + 2 * newSize);
        solution(newSize, row + 2 * newSize, col + 2 * newSize);
    }

    private static boolean isAllSame(int n, int row, int col) {
        int value = paper[row][col];

        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if (paper[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}