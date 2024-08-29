import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] selected;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        selected = new int[m];
        check = new boolean[n + 1];

        solution(0, 1);
    }

    private static void solution(int level, int start) {
        if (level == m) {
            for (int num : selected) {
                System.out.print(num + " ");
            }

            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {
            if (check[i]) {
                continue;
            }

            check[i] = true;
            selected[level] = i;
            solution(level + 1, i + 1);
            check[i] = false;
        }
    }
}