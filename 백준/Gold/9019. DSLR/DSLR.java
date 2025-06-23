import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static final int MAX = 10000;
    private static final char[] ops = new char[] {'D', 'S', 'L', 'R'};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        while (T-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();

            System.out.println(solution(a, b));
        }
    }

    private static String solution(int a, int b) {
        boolean[] isVisited = new boolean[10000];

        Queue<Object[]> queue = new LinkedList<>();
        queue.add(new Object[] {"", a});    // 0: 사용한 명령어 목록 / 1: 현재 값
        isVisited[a] = true;

        while (!queue.isEmpty()) {
            Object[] current = queue.poll();
            String command = current[0].toString();
            int n = (int)current[1];

            // 같으면
            if (n == b) {
                return command;
            }

            // 함수 처리
            for (int i = 0; i < 4; i++) {
                int result = apply(ops[i], n);

                if (!isVisited[result]) {
                    queue.add(new Object[] {command + ops[i], result});
                    isVisited[result] =true;
                }
            }
        }

        return "";
    }

    private static int apply(char op, int n) {
        switch (op) {
            case 'D': return (n * 2) % MAX;
            case 'S': return (((n - 1) % MAX) + MAX) % MAX;
            case 'L': return (n % 1000) * 10 + (n / 1000);
            case 'R': return (n / 10) + (n % 10) * 1000;
            default: throw new IllegalArgumentException();
        }
    }
}
