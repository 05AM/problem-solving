import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static final int MAX = 10000;

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

        String answer = "";
        while (!queue.isEmpty()) {
            Object[] current = queue.poll();
            String command = current[0].toString();
            int n = (int)current[1];

            // 같으면
            if (n == b) {
                answer = command;
                break;
            }

            // 함수 처리
            int result;
            // D
            result = (n * 2) % MAX;
            if (!isVisited[result]) {
                queue.add(new Object[] {command + "D", result});
                isVisited[result] =true;
            }

            // S
            result = (((n - 1) % MAX) + MAX) % MAX;
            if (!isVisited[result]) {
                queue.add(new Object[] {command + "S", result});
                isVisited[result] =true;
            }

            // L
            result = (n % 1000) * 10 + (n / 1000);
            if (!isVisited[result]) {
                queue.add(new Object[] {command + "L", result});
                isVisited[result] =true;
            }

            // R
            result = (n / 10) + (n % 10) * 1000;
            if (!isVisited[result]) {
                queue.add(new Object[] {command + "R", result});
                isVisited[result] =true;
            }
        }

        return answer;
    }
}