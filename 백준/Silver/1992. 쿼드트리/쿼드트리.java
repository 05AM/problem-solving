import java.util.Scanner;

public class Main {
    private static int[][] video;
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        video = new int[n][n];

        for (int i = 0; i < n; i++) {
            video[i] = in.next().chars()
                    .map(Character::getNumericValue)
                    .toArray();
        }

        solution(n, 0, 0);
        System.out.println(result.toString());

        in.close();
    }

    private static void solution(int n, int row, int col) {
        if (isOneColor(n, row, col)) {
            result.append(video[row][col]);
            return;
        }

        result.append("(");

        int nextSize = n / 2;
        solution(nextSize, row, col);
        solution(nextSize, row, col + nextSize);
        solution(nextSize, row + nextSize, col);
        solution(nextSize, row + nextSize, col + nextSize);

        result.append(")");
    }

    private static boolean isOneColor(int n, int row, int col) {
        int color = video[row][col];

        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if (video[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}