import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final int N = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(in.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int n = input[0];
        int m = input[1];

        HashMap<Integer, Integer> paths = new HashMap<>();
        for (int i = 0; i < n + m; i++) {
            input = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            paths.put(input[0], input[1]);
        }

        System.out.println(solution(paths));
    }

    private static int solution(HashMap<Integer, Integer> paths) {
        int size = (N + 1) * (N + 1);
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

                if (isVisited[next]) {
                    continue;
                }

                if (paths.containsKey(next)) {
                    queue.offer(new int[] {paths.get(next), trial + 1});
                } else {
                    queue.offer(new int[] {next, trial + 1});
                }
            }
        }

        return answer;
    }
}