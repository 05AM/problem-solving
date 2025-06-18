import java.util.Scanner;

public class Main {
    private static int answer = -1;
    private static boolean isFound;

    private static int targetRow;
    private static int targetCol;

    private static final int[] moveRow = {0, 0, 1, 1};
    private static final int[] moveCol = {0, 1, 0, 1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        targetRow = in.nextInt();
        targetCol = in.nextInt();

        int side = (int) Math.pow(2, n);
        solution(n, side, 0, 0);

        System.out.println(answer);
    }

    private static void solution(int n, int side, int startRow, int startCol) {
        if (isFound) {
            return;
        }

        // 범위 안에 없으면 사이즈 더하고 빠져나오기
        if (targetRow < startRow || targetRow > startRow + side || targetCol < startCol || targetCol > startCol + side) {
            answer += side * side;
            return;
        }

        if (n == 1) {
            for (int i = 0; i < 4; i++) {
                answer++;

                if (startRow + moveRow[i] == targetRow && startCol + moveCol[i] == targetCol) {
                    isFound = true;
                    return;
                }
            }
            return;
        }

        int nextSize = n - 1;
        int nextSide = (int) Math.pow(2, nextSize);

        solution(nextSize, nextSide, startRow, startCol);
        solution(nextSize, nextSide, startRow, startCol + nextSide);
        solution(nextSize, nextSide, startRow + nextSide, startCol);
        solution(nextSize, nextSide, startRow + nextSide, startCol + nextSide);
    }
}