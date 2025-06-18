import java.util.Scanner;

public class Main {
    private static int answer = 0;

    private static int targetRow;
    private static int targetCol;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        targetRow = in.nextInt();
        targetCol = in.nextInt();

        int side = 1 << n;
        solution(side, 0, 0);

        System.out.println(answer);
    }

    private static void solution(int side, int row, int col) {
        if (side == 1) {
            return;
        }

        int half = side / 2;
        int blockSize = half * half;

        if (targetRow < row + half && targetCol < col + half) {
            // 1사분면
            solution(half, row, col);
        } else if (targetRow < row + half) {
            // 2사분면
            answer += blockSize;
            solution(half, row, col + half);
        } else if (targetCol < col + half) {
            // 3사분면
            answer += 2 * blockSize;
            solution(half, row + half, col);
        } else {
            // 4사분면
            answer += 3 * blockSize;
            solution(half, row + half, col + half);
        }
    }
}