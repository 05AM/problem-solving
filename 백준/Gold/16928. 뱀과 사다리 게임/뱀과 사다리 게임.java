import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final int N = 10;
    private static final int START = 1;
    private static final int GOAL = N * N;

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
        boolean[] isVisited = new boolean[GOAL + 1];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {START, 0});
        isVisited[START] = true;

        int answer = -1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int trial = current[1];

            if (position == GOAL) {
                answer = trial;
                break;
            }

            for (int i = 1; i <= 6; i++) {
                int next = position + i;

                if (next > GOAL || isVisited[next]) {
                    continue;
                }

                isVisited[position] = true;
                queue.offer(new int[] {board[next], trial + 1});
            }
        }

        return answer;
    }
}