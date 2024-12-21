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

    private static int[][] modMatrix(int[][] matrix) {
        int n = matrix.length;
        int[][] modMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                modMatrix[i][j] = matrix[i][j] % 1000;
            }
        }
        return modMatrix;
    }

    private static int[][] multiplyMatrix(int[][] a, int[][] b) {
        int n = a.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += (a[i][k] * b[k][j]) % 1000;
                }
                result[i][j] %= 1000;
            }
        }

        return result;
    }

    private static void printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]);
                if (j < matrix[i].length - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
