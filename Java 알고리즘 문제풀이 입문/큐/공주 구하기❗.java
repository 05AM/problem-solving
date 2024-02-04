import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private int solution(int n, int k) {
        Queue<Integer> circularQueue = IntStream.rangeClosed(1, n)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        while (circularQueue.size() != 1) {
            for (int i = 1; i < k; i++) {
                circularQueue.offer(circularQueue.poll());
            }
            circularQueue.poll();
        }
        return circularQueue.poll();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        System.out.println(T.solution(n, k));
    }
}
