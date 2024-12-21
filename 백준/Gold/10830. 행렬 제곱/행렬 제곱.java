import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] input = in.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        long b = Long.parseLong(input[1]);

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] result = solution(matrix, b);
        printMatrix(result);
    }

    private static int[][] solution(int[][] matrix, long b) {
        if (b == 1) {
            return modMatrix(matrix);
        }

        int[][] half = solution(matrix, b / 2);
        int[][] result = multiplyMatrix(half, half);

        return b % 2 == 0 ? result : multiplyMatrix(result, matrix);
    }

    private static int[][] multiplyMatrix(int[][] a, int[][] b) {
        int aRow = a.length;
        int bCol = b[0].length;
        int[][] multiplied = new int[aRow][bCol];

        for (int i = 0; i < aRow; i++) {
            for (int j = 0; j < bCol; j++) {
                for (int k = 0; k < aRow; k++) {
                    multiplied[i][j] += a[i][k] * b[k][j];
                }
                multiplied[i][j] %= 1000;
            }
        }
        return multiplied;
    }

    private static int[][] modMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] mod = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mod[i][j] = matrix[i][j] % 1000;
            }
        }
        return mod;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
