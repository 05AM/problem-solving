import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] selected;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        selected = new int[m];

        solution(0, 1);
        System.out.println(answer);
    }

    private static void solution(int level, int start) {
        if (level == m) {
            for (int num : selected) {
                answer.append(num).append(" ");
            }

            answer.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            selected[level] = i;
            solution(level + 1, i);
        }
    }
}