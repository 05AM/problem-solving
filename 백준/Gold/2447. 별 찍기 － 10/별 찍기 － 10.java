import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        char[][] pattern = new char[N][N];

        createPattern(pattern, N, 0, 0);
        printPattern(pattern);
    }

    private static void createPattern(char[][] pattern, int size, int x, int y) {
        if (size == 1) {
            pattern[x][y] = '*';
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    fillBlank(pattern, newSize, x + i * newSize, y + j * newSize);
                } else {
                    createPattern(pattern, newSize, x + i * newSize, y + j * newSize);
                }
            }
        }
    }

    private static void fillBlank(char[][] pattern, int size, int x, int y) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                pattern[x + i][y + j] = ' ';
            }
        }
    }

    private static void printPattern(char[][] pattern) {
        for (char[] row : pattern) {
            System.out.println(row);
        }
    }
}
