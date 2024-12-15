import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = in.nextInt();
            }
        }

        m = in.nextInt();
        int k = in.nextInt();
        int[][] b = new int[m][k];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                b[i][j] = in.nextInt();
            }
        }

        int[][] result = solution(a, b);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] solution(int[][] a, int[][] b) {
        int rowA = a.length;
        int colA = a[0].length;
        int colB = b[0].length;

        int[][] result = new int[rowA][colB];
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                for (int l = 0; l < colA; l++) {
                    result[i][j] += (a[i][l] * b[l][j]);
                }
            }
        }

        return result;
    }
}