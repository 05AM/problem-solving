import java.util.*;

public class Main {

    static int n;
    static int answer = 0;
    static int[] col;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        col = new int[n];

        count(0);
        System.out.println(answer);
    }

    private static void count(int r) {
        if (r == n) {
            answer++;
        } else {
            for (int c = 0; c < n; c++) {
                if (isValid(r, c)) {
                    col[r] = c;
                    count(r + 1);
                }
            }
        }
    }

    private static boolean isValid(int r, int c) {
        // 현재 놓을 자리와 윗 행들이 겹치지 않는지 판단
        for (int i = 0; i < r; i++) {
            // 세로 겹치는지
            if (col[i] == c) {
                return false;
            }

            // 대각선 겹치는지
            if (Math.abs(r - i) == Math.abs(c - col[i])) {
                return false;
            }
        }

        return true;
    }
}