import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int MAX = 100000;
    static final int[] visited = new int[MAX + 1];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        System.out.println(solution(n, k));
    }

    private static int solution(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == target) {
                return visited[now] - 1;
            }

            int[] nextPositions = {now - 1, now + 1, now * 2};
            for (int next : nextPositions) {
                if (next >= 0 && next <= MAX && visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    queue.add(next);
                }
            }
        }

        return -1;
    }
}