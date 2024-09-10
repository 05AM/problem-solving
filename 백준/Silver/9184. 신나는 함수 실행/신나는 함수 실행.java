import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final String format = "w(%d, %d, %d) = %d";
    static int[][][] memory = new int[21][21][21];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int i = 1; i < 21; i++) {
            for (int j = 1; j < 21; j++) {
                Arrays.fill(memory[i][j], Integer.MIN_VALUE);
            }
        }

        int a, b, c;
        while (true) {
            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            System.out.printf((format) + "%n", a, b, c, w(a, b, c));
        }
    }

    private static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a <= 20 && b <= 20 && c <= 20 && memory[a][b][c] != Integer.MIN_VALUE) {
            return memory[a][b][c];
        }

        if (a > 20 || b > 20 || c > 20) {
            return memory[20][20][20] = w(20, 20, 20);
        }

        if (a < b && b < c) {
            memory[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            memory[a][b][c] = w(a - 1, b, c)
                    + w(a - 1, b - 1, c)
                    + w(a - 1, b, c - 1)
                    - w(a - 1, b - 1, c - 1);
        }

        return memory[a][b][c];
    }
}