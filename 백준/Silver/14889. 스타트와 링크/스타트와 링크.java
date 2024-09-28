import java.util.Scanner;

public class Main {
    static int[][] s;
    static boolean[] check;
    static int n, answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();

        check = new boolean[n];
        s = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s[i][j] = in.nextInt();
            }
        }

        solution(0, 0);
        System.out.println(answer);
    }

    private static void solution(int level, int start) {
        if (level == n / 2) {
            int sum1 = 0;
            int sum2 = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (check[i] && check[j]) {
                        sum1 += s[i][j];
                    } else if (!check[i] && !check[j]) {
                        sum2 += s[i][j];
                    }
                }
            }

            answer = Math.min(answer, Math.abs(sum1 - sum2));
            return;
        }

        for (int i = start; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                solution(level + 1, i + 1);
                check[i] = false;
            }
        }
    }
}