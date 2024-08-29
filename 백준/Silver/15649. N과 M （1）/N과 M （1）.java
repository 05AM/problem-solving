import java.util.Scanner;

public class Main {

    private static boolean[] check;
    private static int[] selected;

    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        check = new boolean[n + 1];
        selected = new int[m];

        solution(0);
    }

    private static void solution(int cnt) {
        if (cnt == m) {
            for (int num : selected) {
                System.out.print(num + " ");
            }

            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (check[i]) {
                continue;
            }

            selected[cnt] = i;
            check[i] = true;
            solution(cnt + 1);
            check[i] = false;
        }
    }
}