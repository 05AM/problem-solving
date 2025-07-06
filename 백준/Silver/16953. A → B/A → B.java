import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();

        System.out.println(solution(a, b));
    }

    private static long solution(long a, long b) {
        long answer = -2;

        Set<Long> isVisited = new HashSet<>();
        Queue<long[]> queue = new LinkedList<>();

        queue.add(new long[] {a, 0});
        isVisited.add(a);

        while (!queue.isEmpty()) {
            long[] current = queue.poll();
            long n = current[0];
            long trial = current[1];

            if (n == b) {
                answer = trial;
                break;
            }

            long next = n * 2;
            if (next <= b && !isVisited.contains(next)) {
                isVisited.add(next);
                queue.add(new long[] {next, trial + 1});
            }

            next = (n * 10) + 1;
            if (next <= b && !isVisited.contains(next)) {
                isVisited.add(next);
                queue.add(new long[] {next, trial + 1});
            }
        }

        return answer + 1;
    }
}