import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final int N = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int size = N * N + 1;
        int[] board = new int[size];
        for (int i = 1; i <= N * N; i++) {
            board[i] = i;
        }

        int[] input = Arrays.stream(in.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int n = input[0];
        int m = input[1];

        for (int i = 0; i < n + m; i++) {
            input = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            board[input[0]] = input[1];
        }

        System.out.println(solution(board));
    }

    private static int solution(int[] board) {
        int size = N * N + 1;
        boolean[] isVisited = new boolean[size];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {1, 0});

        int goal = N * N;
        int answer = -1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int location = now[0];
            int trial = now[1];

            isVisited[location] = true;

            if (location == goal) {
                answer = trial;
                break;
            }

            for (int i = 1; i <= 6; i++) {
                int next = location + i;

                if (next > goal || isVisited[next]) {
                    continue;
                }

                queue.offer(new int[] {board[next], trial + 1});
            }
        }

        return answer;
    }
}