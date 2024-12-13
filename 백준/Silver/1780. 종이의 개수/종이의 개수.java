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

    private static void solution(int size, int row, int col) {
        if (checkSame(size, row, col)) {
            int value = paper[row][col];
            results[value + 1]++;
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                solution(newSize, row + i * newSize, col + j * newSize);
            }
        }
    }

    private static boolean checkSame(int size, int row, int col) {
        int value = paper[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}